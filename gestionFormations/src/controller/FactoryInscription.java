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

public class FactoryInscription {
    
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
    
        public static void insererInscription(Inscription inscr) {
        try {
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into bdgestion_formation.inscription(matricule, nom, prenom,date_inscription, statut, email) values (?,?,?,?,?,?)");
            pstmet.setInt(1, inscr.getMatricule());
            pstmet.setString(2, inscr.getNom());
            pstmet.setString(3, inscr.getPrenom());
            pstmet.setString(4, inscr.getDate_inscription());
            pstmet.setString(5, inscr.getStatut());
            pstmet.setString(6, inscr.getEmail());
        
            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
//            e.printStackTrace();
        }
    }
    
    //    get&set Inscription
    
        public static void setInscription(Inscription inscr){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into bdgestion_formation.inscription(matricule,nom,prenom,date_inscription,statut,email) values (?,?,?,?,?,?)");
            pstmet.setInt(1, inscr.getMatricule());
            pstmet.setString(2, inscr.getNom());
            pstmet.setString(3, inscr.getPrenom());
            pstmet.setString(4, inscr.getDate_inscription());
            pstmet.setString(5, inscr.getStatut());
            pstmet.setString(6, inscr.getEmail());
           
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Inscription> getInscription(){
        ArrayList<Inscription> lic = new ArrayList();
        Inscription inscr = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.inscription");
            while(rs.next()){
                inscr= new Inscription();
                inscr.setMatricule(rs.getInt("Matricule"));
                inscr.setNom(rs.getString("nom"));
                inscr.setPrenom(rs.getString("prenom"));
                inscr.setDate_inscription(rs.getString("date_inscription"));
                inscr.setEmail(rs.getString("email"));
              
                lic.add(inscr);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
        }
        
            public static Inscription getInscriptionID(int ins) {
        Inscription inscr = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.inscription where id_employe='" + ins + "'");
            if (rs.next()) {
                inscr = new Inscription();
                inscr.setMatricule(rs.getInt("matricule"));
                inscr.setNom(rs.getString("nom"));
                inscr.setPrenom(rs.getString("prenom"));
               
                inscr.setDate_inscription(rs.getString("date_inscription"));
                inscr.setStatut(rs.getString("statut"));
                inscr.setEmail(rs.getString("email"));
               
            }
            conn.close();
            stm.close();
            return inscr;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
        
        //        delete inscription

   public static void getDeleteInscription(Inscription i){
        try{
      
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete * from bdgestion_formation.inscription where id_inscription='"+i.getMatricule()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
   
//   recherche inscription
   
       public static Inscription getRechins(int ins){
        Inscription inscr = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.inscription where matricule='"+ins+"'");
            if(rs.next()){
                inscr = new Inscription();
                inscr.setMatricule(rs.getInt("matricule"));
                inscr.setNom(rs.getString("nom"));
                inscr.setPrenom(rs.getString("prenom"));
                inscr.setDate_inscription(rs.getString("date_inscription"));
                inscr.setStatut(rs.getString("statut"));
                inscr.setEmail(rs.getString("Email"));
               
            }
            conn.close();
            stm.close();
            return inscr;
        }
        catch(Exception e){
        return null;
        }
        }
       
//       modifier employe
       
           public static void ModifyInscriptionID(int matricule,String nom, String prenom, String date_inscription,String statut,String email){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update  bdgestion_formation.inscription set nom='"+nom+"',prenom='"+prenom+"',date_inscription='"+date_inscription+"',statut='"+statut+"',email='"+email+"' where matricule='"+matricule+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }

 
    
}
