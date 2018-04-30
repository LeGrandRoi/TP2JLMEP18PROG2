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
public class Mineral extends Specimen {

    public Mineral(int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee,String type) {
        super(numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee,type);
    }

    @Override
    public String toString()
    {
        return "numéroSérie: "+numeroSerie+", dateObservation: "+dateObservation+", nom: "+nom+", taille: "+taille+", couleur: "+couleur+", personne: "+personne+", quantitéObservée: "+quantiteObservee+", type: "+type;
    }

    
    
}
