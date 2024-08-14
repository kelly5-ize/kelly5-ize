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

public class FactoryParticipant {
    
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
    
        public static void insererParticipant(Participant p){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into bdgestion_formation.participant(	id_participant,nom,prenom,email,nom_entreprise,adresse) values(?,?,?,?,?,?)");
            pstmet.setInt(1,p.getId_participant());
            pstmet.setString(2,p.getNom());
            pstmet.setString(3,p.getPrenom());
            pstmet.setString(4,p.getEmail());
            pstmet.setString(5,p.getNom_entreprise());
             pstmet.setString(6,p.getAdresse());
            
             pstmet.executeUpdate();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //    get&set Participant
    
        public static void setParticipant(Participant p){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into bdgestion_formation.participant(id_participant,nom,prenom,email,nom_entreprise,adresse) values (?,?,?,?,?,?)");
            pstmet.setInt(1, p.getId_participant());
            pstmet.setString(2, p.getNom());
            pstmet.setString(3, p.getPrenom());
            pstmet.setString(4, p.getEmail());
            pstmet.setString(5, p.getNom_entreprise());
            pstmet.setString(6, p.getAdresse());
          
            pstmet.executeQuery();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        public static ArrayList<Participant> getParticipant(){
        ArrayList<Participant> lic = new ArrayList();
        Participant p=null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.participant");
            while(rs.next()){
                p= new Participant();
                p.setId_participant(rs.getInt("id_participant"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setNom_entreprise(rs.getString("nom_entreprise"));
                p.setAdresse(rs.getString("adresse"));
               
                lic.add(p);
               }
            conn.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lic;
    }
           public static Participant getParticipantID(int pi){
        Participant p=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from bdgestion_formation.participant where id_participant='"+pi+"'");
            if(rs.next()){
                p=new Participant();
                p.setId_participant(rs.getInt("id_participant"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setNom_entreprise(rs.getString("nom_entreprise"));
                p.setAdresse(rs.getString("adresse"));
                
            }
            conn.close();
            stm.close();
            return p;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
                
//        delete participant

   public static void getDeleteParticipant(Participant pa){
        try{
      
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete * from bdgestion_formation.participant where id_participant='"+pa.getId_participant()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
   
//   recherche participant
   
       public static Participant getRechparti(int parti){
        Participant p = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from bdgestion_formation.participant where id_participant='"+parti+"'");
            if(rs.next()){
                p = new Participant();
                p.setId_participant(rs.getInt("id_participant"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setNom_entreprise(rs.getString("nom_entreprise"));
                p.setAdresse(rs.getString("adresse"));
              
            }
            conn.close();
            stm.close();
            return p;
        }
        catch(Exception e){
        return null;
        }
        }
       
//       modifier participant
       
           public static void ModifyParticipantID(int id_participant,  String nom, String prenom, String email,String nom_entreprise,String adresse){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update bdgestion_formation.participant set nom='"+nom+"',prenom='"+prenom+"',email='"+email+"',nom_entreprise='"+nom_entreprise+"',adresse='"+adresse+"' where id_participant='"+id_participant+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
}
