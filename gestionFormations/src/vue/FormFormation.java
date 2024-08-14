package vue;

import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Formation;
import model.Participant; // Ajout de l'importation de la classe Participant
import java.sql.*;

public class FormFormation extends JFrame implements ActionListener {

    JLabel id, inti, datdeb, herdeb, datfin, herfin, cout, lieu, idp;
    JTextField tid, tinti, tdatdeb, therdeb, tdatfin, therfin, tcout, tlieu;
    JComboBox tidp;
    JButton enr, vis, init, del, rech, upd;

    ArrayList<Formation> listeFormation = new ArrayList<>();
    ArrayList<Participant> listeParticipant = new ArrayList<>();
    JTable tableformation;
    private final DefaultTableModel model;
    Formation form = null;
    Formation forma = null;
    int index = 0;

    public FormFormation() {

        id = new JLabel("Id_formation");
        id.setBounds(10, 30, 100, 30);
        this.getContentPane().add(id);

        tid = new JTextField("");
        tid.setBounds(120, 30, 100, 30);
        this.getContentPane().add(tid);

        inti = new JLabel("Intitule");
        inti.setBounds(10, 70, 100, 30);
        this.getContentPane().add(inti);

        tinti = new JTextField("");
        tinti.setBounds(120, 70, 100, 30);
        this.getContentPane().add(tinti);

        datdeb = new JLabel("Date_debut");
        datdeb.setBounds(10, 110, 100, 30);
        this.getContentPane().add(datdeb);

        tdatdeb = new JTextField("");
        tdatdeb.setBounds(120, 110, 100, 30);
        this.getContentPane().add(tdatdeb);

        herdeb = new JLabel("Heure_debut");
        herdeb.setBounds(10, 150, 100, 30);
        this.getContentPane().add(herdeb);

        therdeb = new JTextField("");
        therdeb.setBounds(120, 150, 100, 30);
        this.getContentPane().add(therdeb);

        datfin = new JLabel("Date_fin");
        datfin.setBounds(10, 190, 100, 30);
        this.getContentPane().add(datfin);

        tdatfin = new JTextField("");
        tdatfin.setBounds(120, 190, 100, 30);
        this.getContentPane().add(tdatfin);

        herfin = new JLabel("Heure_fin");
        herfin.setBounds(10, 230, 100, 30);
        this.getContentPane().add(herfin);

        therfin = new JTextField("");
        therfin.setBounds(120, 230, 100, 30);
        this.getContentPane().add(therfin);

        cout = new JLabel("Cout");
        cout.setBounds(10, 270, 100, 30);
        this.getContentPane().add(cout);

        tcout = new JTextField("");
        tcout.setBounds(120, 270, 100, 30);
        this.getContentPane().add(tcout);

        lieu = new JLabel("Lieu");
        lieu.setBounds(10, 310, 100, 30);
        this.getContentPane().add(lieu);

        tlieu = new JTextField("");
        tlieu.setBounds(120, 310, 100, 30);
        this.getContentPane().add(tlieu);

        idp = new JLabel("Participant");
        idp.setBounds(10, 350, 100, 30);
        this.getContentPane().add(idp);

        tidp = new JComboBox();
        listeParticipant = FactoryParticipant.getParticipant();
        for (Participant p : listeParticipant) {
            tidp.addItem(p.getIDParticipant());
        }
        tidp.setBounds(120, 350, 150, 30);
        tidp.addItemListener((ItemEvent e) -> {
            index = tidp.getSelectedIndex();
        });
        this.getContentPane().add(tidp);

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
        model.addColumn("Id_formation");
        model.addColumn("Intitule");
        model.addColumn("Date_debut");
        model.addColumn("Heure_debut");
        model.addColumn("Date_fin");
        model.addColumn("Heure_fin");
        model.addColumn("Cout");
        model.addColumn("Lieu");
        model.addColumn("Id_participant");
        this.setLayout(null);
    }

    public void effacer() {
        tid.setText("");
        tinti.setText("");
        tdatdeb.setText("");
        therdeb.setText("");
        tdatfin.setText("");
        therfin.setText("");
        tcout.setText("");
        tlieu.setText("");
    }

    public void afficher() {
        model.setRowCount(0);// il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions
        listeFormation = FactoryFormation.getFormation();
        for (Formation form : listeFormation) {
            model.addRow(new Object[]{
                form.getId_formation(), form.getIntitule(), form.getDate_debut(), form.getHeure_debut(), form.getDate_fin(), form.getHeure_fin(), form.getCout(), form.getLieu(), form.getId_participant()
            });
        }

        tableformation = new JTable(model);
        JScrollPane p = new JScrollPane(tableformation);
        p.setBounds(60, 270, 300, 100);
        this.getContentPane().add(p);
    }

    public void recupInfo(Formation e) {
//        tid.setText(String.valueOf(e.getId_formation()));
//        tinti.setText(e.getIntitule());
//        tdatdeb.setText(e.getDate_debut());
//        therdeb.setText(e.getHeure_debut());
//        tdatfin.setText(e.getDate_fin());
//        therfin.setText(e.getHeure_fin());
//
//        tcout.setText(String.valueOf(e.getCout()));
//        tlieu.setText(e.getLieu());
//
//        String etr = getIDParticipant(e.getId_participant());
//        tidp.setSelectedItem(etr);
       tid.setText(String.valueOf(e.getId_formation()));
        tinti.setText(e.getIntitule());
        tdatdeb.setText(e.getDate_debut());
        therdeb.setText(e.getHeure_debut());
         tdatfin.setText(e.getDate_fin());
        therfin.setText(e.getHeure_fin());
         tcout.setText(String.valueOf(e.getCout()));
        tlieu.setText(e.getLieu());
        String etr=getParticipant(e.getId_participant());
        tidp.setSelectedItem(etr);
    }
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == enr) {
                 int id = Integer.parseInt(tid.getText());
            int cou = Integer.parseInt(tcout.getText());
           String inte = tinti.getText();
            String ddeb = tdatdeb.getText();
            String hd = therdeb.getText();
            String dfin = tdatfin.getText();
            String hf = therfin.getText();
            String li = tlieu.getText();
            int id_participant = listeParticipant.get(index).getId_participant();

            form = new Formation(id, id_participant, cou, inte, ddeb, hd, dfin, hf, li);
            FactoryFormation.insererFormation(form);
    } else if (e.getSource() == vis) {
        afficher();
    } else if (e.getSource() == init) {
        effacer();
    } else if (e.getSource() == del) {
        if (forma != null) {
            String msg = "Voulez-vous réellement supprimer " + forma.getIntitule() + " de la liste des formations";
            int rep = JOptionPane.showConfirmDialog(null, msg);
            if (rep == 0) {
                FactoryFormation.DeleteFormation(forma);
                afficher();
                effacer();
            }
        }
    } else if (e.getSource() == rech) {
        int ct = Integer.valueOf(tid.getText());
        forma = FactoryFormation.getFormationID(ct);
        if (forma != null) {
            recupInfo(forma);
        }
    } else if (e.getSource() == upd) {
     int idd = Integer.parseInt(tid.getText());
     int coue = Integer.parseInt(tcout.getText());
       String intie = tinti.getText();
      String ddebi = tdatdeb.getText();
      String hdi = therdeb.getText();
      String dfini = tdatfin.getText();
       String hfi = therfin.getText();
       String lie = tlieu.getText();
       int p = listeParticipant.get(index).getId_participant();
        
        if (JOptionPane.showConfirmDialog(null, "Voulez-vous modifier?", "Modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            controller.FactoryEmploye.ModifyEmployeID(idd, coue, intie, ddebi, hdi, dfini, hfi, lie);
            afficher();
        }
    }
}
}







//      String getParticipant(int num){
//        String nume="";
//        for(Participant p:listeParticipant){
//            if(p.getId_participant()==num){
//                nume=p.getIDParticipant();
//                break;
//            }
//        }return nume;
//    }
//
//}

