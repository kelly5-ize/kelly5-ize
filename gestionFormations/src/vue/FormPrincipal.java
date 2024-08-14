/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class FormPrincipal extends JFrame implements ActionListener {
    JMenuBar bar; 
    JMenu mdonne,mtrait,mfich; 
    JMenuItem iemploye,iformat,ipart,iinscr,iform,iquit;
    
    public FormPrincipal(){
        bar = new JMenuBar(); 
        
        mfich = new JMenu("Fichier"); 
        mdonne = new JMenu("Donnees de base"); 
        mtrait = new JMenu("Traitement");
        
        iemploye= new JMenuItem("Employe"); 
        iemploye.addActionListener(this);
        
        iformat = new JMenuItem("Formateur");
        iformat.addActionListener(this);
        
        ipart = new JMenuItem("Participant");
        ipart.addActionListener(this);
        
        iinscr = new JMenuItem("Inscription");
        iinscr.addActionListener(this);
        
          iform = new JMenuItem("Formation");
        iform.addActionListener(this);
        
        iquit = new JMenuItem("Quitter");
        mfich.add(iquit); 
        
        mdonne.add(iemploye); 
        mdonne.add(iformat);
        mdonne.add(ipart); 
        mdonne.add(iinscr);
        mdonne.add(iform);
        
        bar.add(mdonne); 
        bar.add(mtrait); 
        bar.add(mfich);
        
        this.getContentPane().add(bar);
        bar.setBounds(10,10,500,30);
        
        this.setLayout(null);
//         this.getContentPane().add(bar);
//        
//        this.setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==iemploye){
        FormEmploye  empl = new FormEmploye();
        empl.setSize(800,800);
        empl.setTitle("Gestion des employes");
        empl.setVisible(true);  
        }
        else
            if(e.getSource()==iformat){
                FormFormateur f = new FormFormateur();
                f.setSize(800,800);
                f.setTitle("Gestion des formateurs");
                f.setVisible(true);
            }
            
            else
            if(e.getSource()==ipart){
                FormParticipant p = new FormParticipant();
                p.setSize(800,800);
                p.setTitle("Gestion des participants");
                p.setVisible(true);
            } 
            
             else
            if(e.getSource()==iinscr){
                FormInscription insc = new FormInscription();
                insc.setSize(800,800);
                insc.setTitle("Gestion des inscriptions");
                insc.setVisible(true);
            }
        
             else
            if(e.getSource()==iform){
                FormFormation form = new FormFormation();
                form.setSize(800,800);
                form.setTitle("Gestion des formations");
                form.setVisible(true);
            }   
            
    }
    }
    
        
    

    
