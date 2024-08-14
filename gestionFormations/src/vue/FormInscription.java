/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;


import controller.FactoryInscription;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Inscription;
import java.sql.*;

public class FormInscription extends JFrame implements ActionListener{
    
    JLabel matr,nom,prenom,dateinsc,stat,email;
    JTextField tmatr,tnom,tprenom,tdateinsc,temail;
    JComboBox listestatut;
    String[] statut={"inscrit","present","absent"};
    JButton enr,vis,init,del,rech,upd;
       ArrayList<Inscription> listeInscription = new ArrayList();
    JTable tableinscription;
    private final DefaultTableModel model;
    Inscription inscr= null;
    Inscription inscro=null;
    
     // Constructeur de la classe
    public FormInscription(){
        
    matr = new JLabel("Matricule");
    matr.setBounds(10,30,100,30);
    this.getContentPane().add(matr);    
    
    tmatr = new JTextField();
    tmatr.setBounds(120,30,100,30);
    this.getContentPane().add(tmatr);
    
     nom = new JLabel("Nom");
    nom.setBounds(10,70,100,30);
    this.getContentPane().add(nom); 
    
    tnom = new JTextField();
    tnom.setBounds(120,70,100,30);
    this.getContentPane().add(tnom);
    
     prenom = new JLabel("Prenom");
    prenom.setBounds(10,110,100,30);
    this.getContentPane().add(prenom); 
    
     tprenom = new JTextField();
    tprenom.setBounds(120,110,100,30);
    this.getContentPane().add(tprenom);
    
    
    dateinsc = new JLabel("Date_inscription");
    dateinsc.setBounds(10,150,100,30);
    this.getContentPane().add(dateinsc); 
    
    tdateinsc = new JTextField();
    tdateinsc.setBounds(120,150,100,30);
    this.getContentPane().add(tdateinsc);
    
    
    stat = new JLabel("Statut");
    stat.setBounds(10,190,100,30);
    this.getContentPane().add(stat);
        
    listestatut = new JComboBox(statut);
    listestatut.setBounds(120,190,100,30);
    this.getContentPane().add(listestatut);
    
    email = new JLabel("Email");
    email.setBounds(10,230,100,30);
    this.getContentPane().add(email);
    
    temail = new JTextField();
    temail.setBounds(120,230,100,30);
    this.getContentPane().add(temail);
    
     enr=new JButton("Enregistrer");
     enr.setBounds(10,390,100,30);
     enr.addActionListener(this);
     this.getContentPane().add(enr);
     
        vis=new JButton("Visualiser");
        vis.setBounds(120,390,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Initialiser");
        init.setBounds(230,390,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Supprimer");
        del.setBounds(340,390,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Modifier");
        upd.setBounds(450,390,100,30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
       rech=new JButton("Rechercher");
        rech.setBounds(560,390,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
            
        model=new DefaultTableModel();
        model.addColumn("Matricule");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Date_inscription");
        model.addColumn("Statut");
        model.addColumn("Email");
       
    
    
     this.setLayout(null);
    
    
}
     public void effacer(){
        tmatr.setText("");
        tnom.setText("");
        tprenom.setText("");
        tdateinsc.setText("");
        temail.setText("");
    }
       public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeInscription= FactoryInscription.getInscription();
        for(Inscription inscr:listeInscription){
            model.addRow(new Object[]{
                    inscr.getMatricule(),inscr.getNom(),inscr.getPrenom(),inscr.getDate_inscription(),inscr.getStatut(),inscr.getEmail()}
            );
        }
        
    tableinscription=new JTable(model);
    JScrollPane p=new JScrollPane(tableinscription);
    p.setBounds(60,310,300,100);
    this.getContentPane().add(p);
    }
          public void recupInfo(Inscription inscr){
        //tnum.setText(cr.getNum());
        tmatr.setText(String.valueOf(inscr.getMatricule()));
        tnom.setText(inscr.getNom());
        tprenom.setText(inscr.getPrenom());
        tdateinsc.setText(inscr.getDate_inscription());
        temail.setText(inscr.getStatut());
        listestatut.setSelectedItem(inscr.getStatut());
    }
          
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == enr) {
        try {
            int m = Integer.parseInt(tmatr.getText());
            String n = tnom.getText();
            String p = tprenom.getText();
            String dats = tdateinsc.getText();
            String em = temail.getText();
            String st = String.valueOf(listestatut.getSelectedItem());

            inscr = new Inscription(m, n, p, dats, em, st);
            FactoryInscription.insererInscription(inscr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } else if (e.getSource() == vis) {
        afficher();
    } else if (e.getSource() == init) {
        effacer();
//    } else if (e.getSource() == del) {
//        if (inscro != null) {
//            String msg = "Voulez-vous réellement supprimer " + inscro.getNom() + " de la liste des inscriptions ?";
//            int rep = JOptionPane.showConfirmDialog(null, msg);
//            if (rep == JOptionPane.YES_OPTION) {
//                FactoryInscription.getDeleteInscription(inscro);
//                afficher();
//                effacer();
//            }
//        }
   } else if (e.getSource() == del) {
        if (inscro != null) {
            String msg = "Voulez-vous réellement supprimer " + inscro.getNom() + " de la liste des inscriptions ?";
            int rep = JOptionPane.showConfirmDialog(null, msg);
            if (rep == JOptionPane.YES_OPTION) {
                FactoryInscription.getDeleteInscription(inscro);
                afficher();
                effacer();
            }
        }
    
//    } else if (e.getSource() == rech) {
//        int ct = Integer.parseInt(tmatr.getText());
//        inscro = FactoryInscription.getRechins(ct);
//        if (inscro != null) {
//            recupInfo(inscro);
//        }
    }else if (e.getSource() == rech) {
        int ct = Integer.parseInt(tmatr.getText());
        inscro = FactoryInscription.getRechins(ct);
        if (inscro != null) {
            recupInfo(inscro);
        }

    } else if (e.getSource() == upd) {
        int mt = Integer.parseInt(tmatr.getText());
        String nm = tnom.getText();
        String prn = tprenom.getText();
        String datsc = tdateinsc.getText();
        String emai = temail.getText();
        String state = String.valueOf(listestatut.getSelectedItem());

        if (JOptionPane.showConfirmDialog(null, "Voulez-vous modifier ?", "Modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            FactoryInscription.ModifyInscriptionID(mt, nm, prn, datsc, emai, state);
            afficher();
        }
    }
}
}
       
          
         
     
    
    
    
    
    
    
    
        
    

