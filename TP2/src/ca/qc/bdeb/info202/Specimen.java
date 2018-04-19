/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

/**
 *
 * @author 1745982
 */
public class Specimen {
    protected String dateObservation;
    protected String nom;
    protected int taille;
    protected String couleur;
    protected String personne;
    
    public Specimen (String dateObservation, String nom, int taille, String couleur, String personne)
    {
        this.dateObservation=dateObservation;
        this.nom=nom;
        this.taille=taille;
        this.couleur=couleur;
        this.personne=personne;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public String getPersonne() {
        return personne;
    }

    public int getTaille() {
        return taille;
    }

    public String getDateObservation() {
        return dateObservation;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setDateObservation(String dateObservation) {
        this.dateObservation = dateObservation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    
}
