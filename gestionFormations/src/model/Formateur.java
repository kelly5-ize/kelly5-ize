/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kelly
 */
public class Formateur {
    private int id_formateur,tel;
    private String nom,prenom,age,date_naissance,sexe,adresse;

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
         public Formateur(int id_formateur, int tel, String nom, String prenom, String age,String date_naissance,String sexe,String adresse) {
        this.id_formateur = id_formateur;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date_naissance = date_naissance;
        this.sexe = sexe;
        this.adresse = adresse;
        
    }
    
    public Formateur(){}
}
   
    

