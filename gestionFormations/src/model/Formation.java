/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



public class Formation {
    
    private int id_formation,id_participant,cout;
    private String intitule,date_debut,heure_debut,date_fin,heure_fin,lieu;

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public int getId_participant() {
        return id_participant;
    }

    public void setId_participant(int id_participant) {
        this.id_participant = id_participant;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
        public Formation(int id_formation, int id_participant,int cout, String intitule, String date_debut, String heure_debut,String date_fin,String heure_fin,String lieu) {
        this.id_formation = id_formation;
        this.id_participant = id_participant;
        this.cout = cout;
        this.intitule = intitule;
        this.date_debut = date_debut;
        this.heure_debut = heure_debut;
        this.date_fin = date_fin;
        this.heure_fin = heure_fin;
        this.lieu = lieu;
    }
    
    public Formation(){}
    
}
