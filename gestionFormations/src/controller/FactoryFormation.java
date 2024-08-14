/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import model.*;

public class FactoryFormation {
    
        private static Connection conn=null;
    private static Statement stm;
    private static PreparedStatement pstmet=null;
    private static ResultSet rs=null;
    
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
    
        public static void insererFormation(Formation form){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into bdgestion_formation.formation(	id_formation,intitule,date_debut,heure_debut,date_fin,heure_fin,cout,lieu,id_participant) values(?,?,?,?,?,?,?,?,?)");
            pstmet.setInt(1,form.getId_formation());
            pstmet.setString(2,form.getIntitule());
            pstmet.setString(3,form.getDate_debut());
            pstmet.setString(4,form.getHeure_debut());
            pstmet.setString(5,form.getDate_fin());
            pstmet.setString(6,form.getHeure_fin());
            pstmet.setInt(7,form.getCout());
            pstmet.setString(8,form.getLieu());
            pstmet.setInt(9,form.getId_participant());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        
            
    public static ArrayList<Formation> getFormation(){
        ArrayList<Formation> lic=new ArrayList();
        Formation form=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from bdgestion_formation.formation");
            while(rs.next()){
                form=new Formation();
                form.setId_formation(rs.getInt("id_formation"));
                form.setIntitule(rs.getString("Intitule"));
                form.setDate_debut(rs.getString("date_debut"));
                form.setHeure_debut(rs.getString("heure_debut"));
                 form.setDate_fin(rs.getString("date_fin"));
                form.setHeure_fin(rs.getString("heure_fin"));
                 form.setCout(rs.getInt("cout"));
                form.setLieu(rs.getString("lieu"));
                form.setId_participant(rs.getInt("id_participant"));
                lic.add(form);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    
    public static Formation getFormationID(int fo) {
        Formation form = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.formation where id_formation='" + fo + "'");
            if (rs.next()) {
                form = new Formation();
                form.setId_formation(rs.getInt("id_formation"));
                form.setIntitule(rs.getString("intitule"));
                form.setDate_debut(rs.getString("date_debut"));
                form.setHeure_debut(rs.getString("heure_debut"));
                form.setDate_fin(rs.getString("date_fin"));
                form.setHeure_fin(rs.getString("heure_fin"));
                form.setCout(rs.getInt("cout"));
                 form.setLieu(rs.getString("lieu"));
                form.setId_participant(rs.getInt("id_participant"));
               
            }
            conn.close();
            stm.close();
            return form;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    
    public static void DeleteFormation(Formation fi) {
        try {
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from bdgestion_formation.formationwhere id_employe='" + fi.getId_formation() + "'";
            stm.executeUpdate(requete);
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void ModifyFormationID(int id_formation,int id_participant, int cout, String intitule, String date_debut, String heure_debut, String date_fin, String heure_fin, String lieu) {
        try {
            conn = getConnection();
            stm = conn.createStatement();
            String re = "update bdgestion_formation.formation set intitule='" + intitule + "', date_debut='" + date_debut + "', heure_debut='" + heure_debut + "', date_fin='" + date_fin + "', heure_fin='" + heure_fin + "', cout='" + cout + "', lieu='" + lieu + "' ,  id_participant='"+id_participant+"' where id_formation='"+id_formation+"'";
            stm.executeUpdate(re);
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
//         public static Formation getRechformt(int formt){
//        Formation form = null;
//        try{
//            conn = getConnection();
//            stm = conn.createStatement();
//            rs = stm.executeQuery("select * from gestion.employe where id_employe='"+formt+"'");
//            if(rs.next()){
//                form = new Formation();
//                form.setId_formation(rs.getInt("id_formation"));
//                form.setDate_debut(rs.getString("date_debut"));
//                form.setHeure_debut(rs.getString("heure_debut"));
//                form.setDate_fin(rs.getString("date_fin"));
//                form.setHeure_fin(rs.getString("heure_fin"));
//               
//                form.setCout(rs.getInt("cout"));
//                form.setLieu(rs.getString("lieu"));
//                
//            }
//            conn.close();
//            stm.close();
//            return form;
//        }
//        catch(Exception e){
//        return null;
//        }
//        }
    
}

