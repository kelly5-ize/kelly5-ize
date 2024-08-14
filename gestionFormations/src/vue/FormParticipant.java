/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;
import controller.FactoryParticipant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Participant;
import java.sql.*;

public class FormParticipant extends JFrame  implements ActionListener {
    
    JLabel id,nom,prenom,email,nomentr,adress;
    JTextField tid,tnom,tprenom,temail,tnomentr,tadress;
    JButton enr,vis,init,del,rech,upd;
    ArrayList<Participant> listeParticipant = new ArrayList();
    JTable tableparticipant;
    private final DefaultTableModel model;
    Participant p= null;
    Participant part=null;
   
    
    public FormParticipant(){
        
        
    id = new JLabel("Id_participant");
    id.setBounds(10,30,100,30);
    this.getContentPane().add(id);
    
    tid = new JTextField();
    tid.setBounds(120,30,100,30);
    this.getContentPane().add(tid);
    
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
    
    email = new JLabel("Email");
    email.setBounds(10,150,100,30);
    this.getContentPane().add(email);
    
    temail = new JTextField();
    temail.setBounds(120,150,100,30);
    this.getContentPane().add(temail);
    
    nomentr = new JLabel("Nom d_entreprise");
    nomentr.setBounds(10,190,100,30);
    this.getContentPane().add(nomentr);
    
     tnomentr = new JTextField();
    tnomentr.setBounds(120,190,100,30);
    this.getContentPane().add(tnomentr);
    
    adress = new JLabel("Adresse");
    adress.setBounds(10,230,100,30);
    this.getContentPane().add(adress);
    
    tadress = new JTextField();
    tadress.setBounds(120,230,100,30);
    this.getContentPane().add(tadress);
    
        
     enr=new JButton("Enregistrer");
     enr.setBounds(10,270,100,30);
     enr.addActionListener(this);
     this.getContentPane().add(enr);
     
        vis=new JButton("Visualiser");
        vis.setBounds(120,270,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Initialiser");
        init.setBounds(230,270,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Supprimer");
        del.setBounds(340,270,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Modifier");
        upd.setBounds(450,270,100,30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
       rech=new JButton("Rechercher");
        rech.setBounds(560,270,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        model=new DefaultTableModel();
        model.addColumn("Id_participant");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Email");
        model.addColumn("Nom d_entreprise");
        model.addColumn("Adresse");
 
    
    
     this.setLayout(null);
     
    
    }
    
       public void effacer(){
        tid.setText("");
        tnom.setText("");
        tprenom.setText("");
        temail.setText("");
        tnomentr.setText("");
        tadress.setText("");
       
        
}
             public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeParticipant= FactoryParticipant.getParticipant();
        for(Participant pa:listeParticipant){
            model.addRow(new Object[]{
                    pa.getId_participant(),pa.getNom(),pa.getPrenom(),pa.getEmail(),pa.getNom_entreprise(),pa.getAdresse()}
            );
        }
         
        tableparticipant=new JTable(model);
    JScrollPane pq=new JScrollPane(tableparticipant);
    pq.setBounds(60,310,300,100);
    this.getContentPane().add(pq);
    }
        public void recupInfo(Participant p){
        //tnum.setText(cr.getNum());
        tid.setText(String.valueOf(p.getId_participant()));
        tnom.setText(p.getNom());
        tprenom.setText(p.getPrenom());
        temail.setText(p.getEmail());
        tnomentr.setText(p.getNom_entreprise());
        tadress.setText(p.getAdresse());
      
    }
               public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){
            int i=Integer.valueOf(tid.getText());
            String  n=tnom.getText();
            String pe=tprenom.getText();
            String em=temail.getText();
            String noment=tnomentr.getText();
         
            String a=tadress.getText();
            
            
           
            p=new Participant(i,n,pe,em,noment,a);
            FactoryParticipant.insererParticipant(p);
        }else if(e.getSource()==vis){
            afficher();
        }else if(e.getSource()==init){
            effacer();
        }else if(e.getSource()==del){
            if(part !=null){
                String msg="Voulez-vous reelement supprimer "+part.getNom()+" de la liste des participants";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    FactoryParticipant.getDeleteParticipant(part);
                    afficher();
                    effacer();
                }
            }
            
                 }else if(e.getSource()==rech){
            int ct=Integer.valueOf(tid.getText());
            part=FactoryParticipant.getParticipantID(ct);
            if(part !=null){
                recupInfo(part);
            }
        }else if(e.getSource()==upd){
           int idd=Integer.valueOf(tid.getText());
            String  nm=tnom.getText();
            String prn=tprenom.getText();
            String ema=temail.getText();
            String nomen=tnomentr.getText();
          
            String adre=tadress.getText();
           
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.FactoryParticipant.ModifyParticipantID(idd,nm,prn,ema,nomen,adre);
                afficher();
            }
        }
    }
}
                       
      

