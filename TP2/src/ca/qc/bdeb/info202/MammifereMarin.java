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

    public MammifereMarin(TypeEau typeEau, TypeManger typeManger, Sexe sexe, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee) {
        super(sexe, numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee);
        this.typeEau = typeEau;
        this.typeManger = typeManger;
    }

    public TypeEau getTypeEau() {
        return typeEau;
    }

    public TypeManger getTypeManger() {
        return typeManger;
    }
    

    public void setTypeManger(TypeManger typeManger) {
        this.typeManger = typeManger;
    }

    public void setTypeEau(TypeEau typeEau) {
        this.typeEau = typeEau;
    }
    
    
    
}
