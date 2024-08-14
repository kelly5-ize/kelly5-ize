/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kelly
 */
public class Participant {
    
    private int id_participant;
    private String nom,prenom,email,nom_entreprise,adresse;

    public int getId_participant() {
        return id_participant;
    }

    public void setId_participant(int id_participant) {
        this.id_participant = id_participant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
      public String getIDParticipant(){
        return id_participant+"-"+nom+"-"+nom_entreprise;
    }
         public Participant(int id_participant, String nom, String prenom, String email,String nom_entreprise,String adresse) {
        this.id_participant = id_participant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nom_entreprise = nom_entreprise;
        this.adresse = adresse;
        
    }
    
    public Participant(){}
}
   
    

