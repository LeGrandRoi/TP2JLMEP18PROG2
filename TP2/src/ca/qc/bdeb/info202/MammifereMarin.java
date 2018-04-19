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
public class MammifereMarin extends Animal {
    public enum TypeEau {
        DOUCE,
        SALEE
    };
    
    public  enum TypeManger {
        CARNIVORE,
        VEGETARIEN
    };
    private TypeEau typeEau;
    private TypeManger typeManger;

    public MammifereMarin(TypeEau typeEau, TypeManger typeManger, String dateObservation, String nom, int taille, String couleur, String personne, Sexe sexe) 
    {
        super(dateObservation, nom, taille, couleur, personne, sexe);
        this.typeEau = typeEau;
        this.typeManger = typeManger;
    }
    
}
