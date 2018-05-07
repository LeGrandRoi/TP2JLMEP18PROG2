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
public abstract class Animal extends Specimen implements Serializable {
    public enum Sexe{
        MALE,
        FEMELE
    };
    protected Sexe sexe;
    
    protected String cri;

    public Animal(Sexe sexe, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee,String type) {
        super(numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee,type);
        this.sexe = sexe;
    }

    
    
    
    public abstract void cri();

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    

    
   
    
}
