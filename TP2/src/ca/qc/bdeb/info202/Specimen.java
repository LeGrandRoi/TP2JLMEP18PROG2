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
}
