package vue;

import controller.FactoryFormateur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Formateur;

public class FormFormateur extends JFrame implements ActionListener {
    
    JLabel id, nom, prenom, age, datenaiss, sexe, tel, adress;
    JTextField tid, tnom, tprenom, tage, tdatenaiss, ttel, tadress;
    JRadioButton sexe1, sexe2;
    ButtonGroup listesexe;
    JButton enr, vis, init, del, rech, upd;
    ArrayList<Formateur> listeFormateur = new ArrayList<>();
    JTable tableformateur;
    private final DefaultTableModel model;
    Formateur f = null;
    Formateur fori = null;
    
    public FormFormateur() {
        
        id = new JLabel("Id_formateur");
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
        age.setBounds(10, 190, 100, 30);
        this.getContentPane().add(age);
        
        tage = new JTextField();
        tage.setBounds(120, 190, 100, 30);
        this.getContentPane().add(tage);
        
        datenaiss = new JLabel("Date_naissance");
        datenaiss.setBounds(10, 230, 100, 30);
        this.getContentPane().add(datenaiss);
        
        tdatenaiss = new JTextField();
        tdatenaiss.setBounds(120, 230, 100, 30);
        this.getContentPane().add(tdatenaiss);
        
        sexe = new JLabel("Sexe");
        sexe.setBounds(10, 270, 100, 30);
        this.getContentPane().add(sexe);
        
        sexe1 = new JRadioButton("Masculin");
        sexe1.setBounds(120, 270, 70, 30);
        sexe2 = new JRadioButton("Feminin");
        sexe2.setBounds(200, 270, 70, 30);
        listesexe = new ButtonGroup();
        listesexe.add(sexe1);
        listesexe.add(sexe2);
        this.getContentPane().add(sexe1);
        this.getContentPane().add(sexe2);
        
        tel = new JLabel("Tel");
        tel.setBounds(10, 310, 100, 30);
        this.getContentPane().add(tel);
        
        ttel = new JTextField();
        ttel.setBounds(120, 310, 100, 30);
        this.getContentPane().add(ttel);
        
        adress = new JLabel("Adresse");
        adress.setBounds(10, 350, 100, 30);
        this.getContentPane().add(adress);
        
        tadress = new JTextField();
        tadress.setBounds(120, 350, 100, 30);
        this.getContentPane().add(tadress);
        
        enr = new JButton("Enregistrer");
        enr.setBounds(10, 500, 100, 30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis = new JButton("Visualiser");
        vis.setBounds(120, 500, 100, 30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init = new JButton("Initialiser");
        init.setBounds(230, 500, 100, 30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del = new JButton("Supprimer");
        del.setBounds(340, 500, 100, 30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd = new JButton("Modifier");
        upd.setBounds(450, 500, 100, 30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
        rech = new JButton("Rechercher");
        rech.setBounds(560, 500, 100, 30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        model = new DefaultTableModel();
        model.addColumn("Id_formateur");
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
        model.setRowCount(0); // réinitialiser le nombre de lignes
        listeFormateur = FactoryFormateur.getFormateur();
        for (Formateur c : listeFormateur) {
            model.addRow(new Object[]{
                c.getId_formateur(), c.getNom(), c.getPrenom(), c.getAge(), c.getDate_naissance(), c.getSexe(), c.getTel(), c.getAdresse()
            });
        }
        
        tableformateur = new JTable(model);
        JScrollPane p = new JScrollPane(tableformateur);
        p.setBounds(60, 310, 300, 100);
        this.getContentPane().add(p);
    }
    
    public void recupInfo(Formateur f) {
        tid.setText(String.valueOf(f.getId_formateur()));
        tnom.setText(f.getNom());
        tprenom.setText(f.getPrenom());
        tage.setText(f.getAge());
        tdatenaiss.setText(f.getDate_naissance());
        if (f.getSexe().equalsIgnoreCase("Masculin")) {
            sexe1.setSelected(true);
        } else if (f.getSexe().equalsIgnoreCase("Feminin")) {
            sexe2.setSelected(true);
        }
        ttel.setText(String.valueOf(f.getTel()));
        tadress.setText(f.getAdresse());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enr) {
           
                int i = Integer.parseInt(tid.getText());
                String n = tnom.getText();
                String p = tprenom.getText();
                String ag = tage.getText();
                String d = tdatenaiss.getText(); // Assurez-vous de convertir dans le format correct
                String s = sexe1.isSelected() ? "Masculin" : sexe2.isSelected() ? "Feminin" : "";
                int t = Integer.parseInt(ttel.getText());
                String a = tadress.getText();
                
                f = new Formateur(i, t,n, p, ag, d, s, a);
                FactoryFormateur.insererFormateur(f);
            
//             catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
//            }
        } else if (e.getSource() == vis) {
            afficher();
        } else if (e.getSource() == init) {
            effacer();
        } else if (e.getSource() == del) {
            if (fori != null) {
            String msg = "Voulez-vous réellement supprimer " + fori.getNom() + " de la liste des formateurs";
            int rep = JOptionPane.showConfirmDialog(null, msg);
            if (rep == 0) {
                FactoryFormateur.getDeleteFormateur(fori);
                afficher();
                effacer();
            }
        }
//                } else if (e.getSource() == upd) {
//            int i = Integer.parseInt(tid.getText());
//            String n = tnom.getText();
//            String p = tprenom.getText();
//            String ag = tage.getText();
//            String d = tdatenaiss.getText();
//            String s = sexe1.isSelected() ? "Masculin" : sexe2.isSelected() ? "Feminin" : "";
//            int t = Integer.parseInt(ttel.getText());
//            String a = tadress.getText();
//            
//            Formateur f = new Formateur(i, t,n, p, ag, d, s, a);
//            FactoryFormateur.ModifyFormateurID(f);
//        } else if (e.getSource() == rech) {
//            int i = Integer.parseInt(tid.getText());
//            fori = FactoryFormateur.getRechfoma(i);
//            recupInfo(fori);
//        }
                 }else if(e.getSource()==rech){
         int ct=Integer.valueOf(tid.getText());
          fori=FactoryFormateur.getFormateurID(ct);
           if(fori !=null){
                recupInfo(fori);
            }
        }else if(e.getSource()==upd){
           int idd=Integer.valueOf(tid.getText());
            String  nm=tnom.getText();
            String prn=tprenom.getText();
            String agi=tage.getText();
           String dtn=tdatenaiss.getText();
           String se = sexe1.isSelected() ? "Masculin" : (sexe2.isSelected() ? "Feminin" : "");
          int tp=Integer.valueOf(ttel.getText());
           String adr=tadress.getText();
          
           if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
               controller.FactoryFormateur.ModifyFormateurID(idd,tp,nm,prn,agi,dtn,se,adr);                afficher();
            }
       }
    }
    
}
