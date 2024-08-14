/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import model.*;
public class FactoryFormateur {
    
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
    
    
    public static void insererFormateur(Formateur f) {
        try {
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into bdgestion_formation.formateur(id_formateur, nom, prenom, age, date_naissance, sexe, tel, adresse) values (?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, f.getId_formateur());
            pstmet.setString(2, f.getNom());
            pstmet.setString(3, f.getPrenom());
            pstmet.setString(4, f.getAge());
            pstmet.setString(5, f.getDate_naissance());
            pstmet.setString(6, f.getSexe());
            pstmet.setInt(7, f.getTel());
            pstmet.setString(8, f.getAdresse());
            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    get & set formateur
    
    public static void setFormateur(Formateur f){
        
        try{
            
                 conn = getConnection();
            pstmet = conn.prepareStatement("insert into gestion.formateur(id_formateur,nom,prenom,age,date_naissance,sexe,tel,adresse) values (?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, f.getId_formateur());
            pstmet.setString(2, f.getNom());
            pstmet.setString(3, f.getPrenom());
            pstmet.setString(4, f.getAge());
            pstmet.setString(5, f.getDate_naissance());
            pstmet.setString(6, f.getSexe());
            pstmet.setInt(7, f.getTel());
            pstmet.setString(8, f.getAdresse());
            pstmet.executeUpdate();
            conn.close();
        }
        
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
    }
    
}
    public static ArrayList<Formateur> getFormateur(){
        
         ArrayList<Formateur> lic = new ArrayList();
        Formateur f = null;
          try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from gestion.formateur");
            while(rs.next()){
                f= new Formateur();
                f.setId_formateur(rs.getInt("id_formateur"));
                f.setNom(rs.getString("nom"));
                f.setPrenom(rs.getString("prenom"));
                f.setAge(rs.getString("age"));
                f.setDate_naissance(rs.getString("date_naissance"));
                f.setSexe(rs.getString("Sexe"));
                f.setTel(rs.getInt("tel"));
                f.setAdresse(rs.getString("adresse"));
                lic.add(f);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
        
       }
        public static Formateur getFormateurID(int fota) {
        Formateur f = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.formateur where id_formateur='" + fota + "'");
            if (rs.next()) {
                f = new Formateur();
                f.setId_formateur(rs.getInt("id_formateur"));
                f.setNom(rs.getString("nom"));
                f.setPrenom(rs.getString("prenom"));
                f.setAge(rs.getString("age"));
                f.setDate_naissance(rs.getString("date_naissance"));
                f.setSexe(rs.getString("sexe"));
                f.setTel(rs.getInt("tel"));
                f.setAdresse(rs.getString("adresse"));
            }
            conn.close();
            stm.close();
            return f;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
//    delete formateur
    
  public static void getDeleteFormateur(Formateur fo){
        try{
      
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete * from gestion.formateur where id_formateur='"+fo.getId_formateur()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
  
  
     
//   recherche formateur
   
       public static Formateur getRechfoma(int foma){
        Formateur f = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from gestion.formateur where id_formateur='"+foma+"'");
            if(rs.next()){
                f = new Formateur();
                f.setId_formateur(rs.getInt("id_formateur"));
                f.setNom(rs.getString("nom"));
                f.setPrenom(rs.getString("prenom"));
                f.setAge(rs.getString("age"));
                f.setDate_naissance(rs.getString("date_naissance"));
                f.setSexe(rs.getString("sexe"));
                f.setTel(rs.getInt("tel"));
                f.setAdresse(rs.getString("adresse"));
            }
            conn.close();
            stm.close();
            return f;
        }
        catch(Exception e){
        return null;
        }
        }
       
//       modifier formateur
       
                public static void ModifyFormateurID(int id_formateur, int tel, String nom, String prenom, String age,String date_naissance,String sexe,String adresse){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion.formateur set nom='"+nom+"',prenom='"+prenom+"',age='"+age+"',date_naissance='"+date_naissance+"',sexe='"+sexe+"',tel='"+tel+"',adresse='"+adresse+"' where id_formateur='"+id_formateur+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }

    public static void ModifyFormateurID(Formateur f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
    
