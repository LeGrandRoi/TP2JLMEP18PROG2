/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author 1745982
 */
public class MammifereMarin extends Animal implements Serializable {
    
    public enum TypeEau {
        DOUCE,
        SALEE
    };
    
    
    public enum TypeManger {
        CARNIVORE,
        VEGETARIEN
    };
    private TypeEau typeEau;
    private TypeManger typeManger;

    
    public MammifereMarin(TypeEau typeEau, TypeManger typeManger, Sexe sexe, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee,String type) {
        super(sexe, numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee,type);
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
    
    @Override
    public String toString()
    {
        return "numéroSérie: "+numeroSerie+", dateObservation: "+dateObservation+", nom: "+nom+", taille: "+taille+", couleur: "+couleur+", personne: "+personne.getNom()+", quantitéObservée: "+quantiteObservee+", type: "+type+", sexe: "+sexe+", typeEau: "+typeEau+", typeManger: "+typeManger+" cri: "+cri;
    }
    
     @Override
   public void cri() {
         Scanner clavier = new Scanner(System.in);
         System.out.println("Entrez le cri du mammifère marin.");
         cri=clavier.nextLine();
    }
    
}
