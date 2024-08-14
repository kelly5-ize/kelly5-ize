package vue;

import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Employe;
import java.sql.*;

public class FormEmploye extends JFrame implements ActionListener {
    
    JLabel id, nom, prenom, age, datenaiss, sexe, tel, adress;
    JTextField tid, tnom, tprenom, tage, tdatenaiss, ttel, tadress;
    JRadioButton sexe1, sexe2;
    ButtonGroup listesexe;
    JButton enr, vis, init, del, rech, upd;
    ArrayList<Employe> listeEmploye = new ArrayList<>();
    JTable tablemploye;
    private final DefaultTableModel model;
    Employe empl = null;
    Employe Emple = null;
    
    // Constructeur de la classe
    public FormEmploye() {
    
        id = new JLabel("Id_employe");
        id.setBounds(10, 30, 100, 30);
        this.getContentPane().add(id);
        
        tid = new JTextField();
        tid.setBounds(120, 30, 100, 30);
        this.getContentPane().add(tid);
        
        nom = new JLabel("Nom");
        nom.setBounds(10, 70, 100, 30);
        this.getContentPane().add(nom);
        
        tnom = new JTextField();
        tnom.setBounds(120, 70, 100, 30);
        this.getContentPane().add(tnom);
        
        prenom = new JLabel("Prenom");
        prenom.setBounds(10, 110, 100, 30);
        this.getContentPane().add(prenom);
        
        tprenom = new JTextField();
        tprenom.setBounds(120, 110, 100, 30);
        this.getContentPane().add(tprenom);
        
        age = new JLabel("Age");
        age.setBounds(10, 150, 100, 30);
        this.getContentPane().add(age);
        
        tage = new JTextField();
        tage.setBounds(120, 150, 100, 30);
        this.getContentPane().add(tage);
        
        datenaiss = new JLabel("Date_naissance");
        datenaiss.setBounds(10, 190, 100, 30);
        this.getContentPane().add(datenaiss);
        
        tdatenaiss = new JTextField();
        tdatenaiss.setBounds(120, 190, 100, 30);
        this.getContentPane().add(tdatenaiss);
        
        sexe = new JLabel("Sexe");
        sexe.setBounds(10, 230, 100, 30);
        this.getContentPane().add(sexe);
        
        sexe1 = new JRadioButton("Masculin");
        sexe1.setBounds(120, 230, 70, 30);
        sexe2 = new JRadioButton("Feminin");
        sexe2.setBounds(200, 230, 70, 30);
        listesexe = new ButtonGroup();
        listesexe.add(sexe1);
        listesexe.add(sexe2);
        this.getContentPane().add(sexe1);
        this.getContentPane().add(sexe2);
        
        tel = new JLabel("Tel");
        tel.setBounds(10, 270, 100, 30);
        this.getContentPane().add(tel);
        
        ttel = new JTextField();
        ttel.setBounds(120, 270, 100, 30);
        this.getContentPane().add(ttel);
        
        adress = new JLabel("Adresse");
        adress.setBounds(10, 310, 100, 30);
        this.getContentPane().add(adress);
        
        tadress = new JTextField();
        tadress.setBounds(120, 310, 100, 30);
        this.getContentPane().add(tadress);
        
        enr = new JButton("Enregistrer");
        enr.setBounds(10, 450, 100, 30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis = new JButton("Visualiser");
        vis.setBounds(120, 450, 100, 30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init = new JButton("Initialiser");
        init.setBounds(230, 450, 100, 30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del = new JButton("Supprimer");
        del.setBounds(340, 450, 100, 30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd = new JButton("Modifier");
        upd.setBounds(450, 450, 100, 30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
        rech = new JButton("Rechercher");
        rech.setBounds(560, 450, 100, 30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        model = new DefaultTableModel();
        model.addColumn("Id_employe");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Age");
        model.addColumn("Date_naissance");
        model.addColumn("Sexe");
        model.addColumn("Tel");
        model.addColumn("Adresse");
        
        this.setLayout(null);
    }
    
    public void effacer() {
        tid.setText("");
        tnom.setText("");
        tprenom.setText("");
        tage.setText("");
        tdatenaiss.setText("");
        listesexe.clearSelection();
        ttel.setText("");
        tadress.setText("");
    }
    
    public void afficher() {
        model.setRowCount(0); // il sert initialiser le nombre de lignes car une fois omis il affiche les lignes mais en faisant des répétitions  
        listeEmploye = FactoryEmploye.getEmploye();
        for (Employe c : listeEmploye) {
            model.addRow(new Object[]{
                c.getId_employe(), c.getNom(), c.getPrenom(), c.getAge(), c.getDate_naissance(), c.getSexe(), c.getTel(), c.getAdresse()
            });
        }
        
        tablemploye = new JTable(model);
        JScrollPane p = new JScrollPane(tablemploye);
        p.setBounds(60, 310, 300, 100);
        this.getContentPane().add(p);
    }
    
    public void recupInfo(Employe e) {
        tid.setText(String.valueOf(e.getId_employe()));
        tnom.setText(e.getNom());
        tprenom.setText(e.getPrenom());
        tage.setText(e.getAge());
        tdatenaiss.setText(e.getDate_naissance());
        if (e.getSexe().equalsIgnoreCase("Masculin")) {
            sexe1.setSelected(true);
        } else if (e.getSexe().equalsIgnoreCase("Feminin")) {
            sexe2.setSelected(true);
        }
        ttel.setText(String.valueOf(e.getTel()));
        tadress.setText(e.getAdresse());
    }
    
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == enr) {
        int i = Integer.valueOf(tid.getText());
        String n = tnom.getText();
        String p = tprenom.getText();
        String ag = tage.getText();
        String d = tdatenaiss.getText();
        String s = sexe1.isSelected() ? "Masculin" : (sexe2.isSelected() ? "Feminin" : "");
        int t = Integer.valueOf(ttel.getText());
        String a = tadress.getText();
        empl = new Employe(i, t, n, p, ag, d, s, a);
        FactoryEmploye.insererEmploye(empl);
    } else if (e.getSource() == vis) {
        afficher();
    } else if (e.getSource() == init) {
        effacer();
    } else if (e.getSource() == del) {
        if (Emple != null) {
            String msg = "Voulez-vous réellement supprimer " + Emple.getNom() + " de la liste des employés";
            int rep = JOptionPane.showConfirmDialog(null, msg);
            if (rep == 0) {
                FactoryEmploye.getDeleteEmploye(Emple);
                afficher();
                effacer();
            }
        }
    } else if (e.getSource() == rech) {
        int ct = Integer.valueOf(tid.getText());
        Emple = FactoryEmploye.getEmployeID(ct);
        if (Emple != null) {
            recupInfo(Emple);
        }
    } else if (e.getSource() == upd) {
        int idd = Integer.valueOf(tid.getText());
        String nm = tnom.getText();
        String prn = tprenom.getText();
        String agi = tage.getText();
        String dtn = tdatenaiss.getText();
        String se = sexe1.isSelected() ? "Masculin" : (sexe2.isSelected() ? "Feminin" : "");
        int tp = Integer.valueOf(ttel.getText());
        String adr = tadress.getText();
        
        if (JOptionPane.showConfirmDialog(null, "Voulez-vous modifier?", "Modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            controller.FactoryEmploye.ModifyEmployeID(idd, tp, nm, prn, agi, dtn, se, adr);
            afficher();
        }
    }
}
}


             
