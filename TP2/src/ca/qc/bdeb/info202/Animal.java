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
public class Animal extends Specimen {
    public enum Sexe{
        MALE,
        FEMELE
    };
    protected Sexe sexe;

    public Animal(Sexe sexe, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee,String type) {
        super(numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee,type);
        this.sexe = sexe;
    }

    
    
    
   // protected abstract void cri();

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    

    
   
    
}
