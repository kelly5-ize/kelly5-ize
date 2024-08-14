package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Employe;

public class FactoryEmploye {
    public static Connection conn = null;
    public static Statement stm;
    public static PreparedStatement pstmet = null;
    public static ResultSet rs = null;

    public static Connection getConnection() {
        String serveur = "localhost";
        int port = 3306;
        String database = "bdgestion_formation";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + serveur + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insererEmploye(Employe empl) {
        try {
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into bdgestion_formation.employe(id_employe, nom, prenom, age, date_naissance, sexe, tel, adresse) values (?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, empl.getId_employe());
            pstmet.setString(2, empl.getNom());
            pstmet.setString(3, empl.getPrenom());
            pstmet.setString(4, empl.getAge());
            pstmet.setString(5, empl.getDate_naissance());
            pstmet.setString(6, empl.getSexe());
            pstmet.setInt(7, empl.getTel());
            pstmet.setString(8, empl.getAdresse());
            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employe> getEmploye() {
        ArrayList<Employe> lic = new ArrayList<>();
        Employe empl = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.employe");
            while (rs.next()) {
                empl = new Employe();
                empl.setId_employe(rs.getInt("id_employe"));
                empl.setNom(rs.getString("nom"));
                empl.setPrenom(rs.getString("prenom"));
                empl.setAge(rs.getString("age"));
                empl.setDate_naissance(rs.getString("date_naissance"));
                empl.setSexe(rs.getString("sexe"));
                empl.setTel(rs.getInt("tel"));
                empl.setAdresse(rs.getString("adresse"));
                lic.add(empl);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lic;
    }

    public static Employe getEmployeID(int emi) {
        Employe empl = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.employe where id_employe='" + emi + "'");
            if (rs.next()) {
                empl = new Employe();
                empl.setId_employe(rs.getInt("id_employe"));
                empl.setNom(rs.getString("nom"));
                empl.setPrenom(rs.getString("prenom"));
                empl.setAge(rs.getString("age"));
                empl.setDate_naissance(rs.getString("date_naissance"));
                empl.setSexe(rs.getString("sexe"));
                empl.setTel(rs.getInt("tel"));
                empl.setAdresse(rs.getString("adresse"));
            }
            conn.close();
            stm.close();
            return empl;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }

    public static void getDeleteEmploye(Employe em) {
        try {
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from bdgestion_formation.employe where id_employe='" + em.getId_employe() + "'";
            stm.executeUpdate(requete);
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void ModifyEmployeID(int id_employe, int tel, String nom, String prenom, String age, String date_naissance, String sexe, String adresse) {
        try {
            conn = getConnection();
            stm = conn.createStatement();
            String re = "update bdgestion_formation.employe set nom='" + nom + "', prenom='" + prenom + "', age='" + age + "', date_naissance='" + date_naissance + "', sexe='" + sexe + "', tel='" + tel + "', adresse='" + adresse + "' where id_employe='" + id_employe + "'";
            stm.executeUpdate(re);
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
         public static Employe getRechemp(int emp){
        Employe empl = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from gestion.employe where id_employe='"+emp+"'");
            if(rs.next()){
                empl = new Employe();
                empl.setId_employe(rs.getInt("id_employe"));
                empl.setNom(rs.getString("nom"));
                empl.setPrenom(rs.getString("prenom"));
                empl.setAge(rs.getString("age"));
                empl.setDate_naissance(rs.getString("date_naissance"));
                empl.setSexe(rs.getString("sexe"));
                empl.setTel(rs.getInt("tel"));
                empl.setAdresse(rs.getString("adresse"));
            }
            conn.close();
            stm.close();
            return empl;
        }
        catch(Exception e){
        return null;
        }
        }
}