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
public class PlanteAquatique extends Specimen {
    public enum TypeEau {
        DOUCE,
        SALEE
    };
    private TypeEau typeEau;
    public enum TypePlante{
        FLOTTANTE,
        IMMERGEE
    };
    private TypePlante typePlante;

    public PlanteAquatique(TypeEau typeEau, TypePlante typePlante, String dateObservation, String nom, int taille, String couleur, String personne) 
    {
        super(dateObservation, nom, taille, couleur, personne);
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
    
    
}
