/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

import java.io.Serializable;

/**
 *
 * @author 1745982
 */
public class Specimen implements Serializable {

    protected String dateObservation;
    protected String nom;
    protected int taille;
    protected String couleur;
    protected Personne personne;
    protected int numeroSerie;
    int quantiteObservee;

    public Specimen(int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee) {
        this.dateObservation = dateObservation;
        this.nom = nom;
        this.taille = taille;
        this.couleur = couleur;
        this.personne = personne;
        this.numeroSerie = numeroSerie;
        this.quantiteObservee = quantiteObservee;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public Personne getPersonne() {
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

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getQuantiteObservee() {
        return quantiteObservee;
    }

    public void setQuantiteObservee(int quantiteObservee) {
        this.quantiteObservee = quantiteObservee;
    }



}
