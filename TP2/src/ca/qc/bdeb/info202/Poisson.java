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
public class Poisson extends Animal {
    public enum TypeEau {
        DOUCE,
        SALEE
    };
    private TypeEau typeEau;

    public Poisson(TypeEau typeEau, String dateObservation, String nom, int taille, String couleur, String personne, Sexe sexe) 
    {
        super(dateObservation, nom, taille, couleur, personne, sexe);
        this.typeEau = typeEau;
    }

    public TypeEau getTypeEau() {
        return typeEau;
    }

    public void setTypeEau(TypeEau typeEau) {
        this.typeEau = typeEau;
    }
    
    
}
