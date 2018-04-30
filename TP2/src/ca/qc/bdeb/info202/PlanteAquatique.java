/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

import ca.qc.bdeb.info202.MammifereMarin.TypeEau;

/**
 *
 * @author 1745982
 */
public class PlanteAquatique extends Specimen {
   
    private TypeEau typeEau;
    public enum TypePlante{
        FLOTTANTE,
        IMMERGEE
    };
    private TypePlante typePlante;

    public PlanteAquatique(TypeEau typeEau, TypePlante typePlante, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee,String type) {
        super(numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee,type);
        this.typeEau = typeEau;
        this.typePlante = typePlante;
    }


    public TypeEau getTypeEau() {
        return typeEau;
    }

    public TypePlante getTypePlante() {
        return typePlante;
    }

    public void setTypeEau(TypeEau typeEau) {
        this.typeEau = typeEau;
    }

    public void setTypePlante(TypePlante typePlante) {
        this.typePlante = typePlante;
    }
    
    @Override
    public String toString()
    {
        return "numéroSérie: "+numeroSerie+", dateObservation: "+dateObservation+", nom: "+nom+", taille: "+taille+", couleur: "+couleur+", personne: "+personne+", quantitéObservée: "+quantiteObservee+", type: "+type+", typeEau: "+typeEau+", typePlante: "+typePlante;
    }
    
}
