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
public class Poisson extends Animal {
    
    private TypeEau typeEau;

    public Poisson(TypeEau typeEau, Sexe sexe, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee) {
        super(sexe, numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee);
        this.typeEau = typeEau;
    }


    public TypeEau getTypeEau() {
        return typeEau;
    }

    public void setTypeEau(TypeEau typeEau) {
        this.typeEau = typeEau;
    }
    
    
}
