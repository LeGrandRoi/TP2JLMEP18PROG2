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
public class Autre extends Animal implements Serializable{
    

    public Autre(Sexe sexe, int numeroSerie, String dateObservation, String nom, int taille, String couleur, Personne personne, int quantiteObservee,String type) {
        super(sexe, numeroSerie, dateObservation, nom, taille, couleur, personne,quantiteObservee,type);
    }
    
    @Override
    public String toString()
    {
        return "numéroSérie: "+numeroSerie+", dateObservation: "+dateObservation+", nom: "+nom+", taille: "+taille+", couleur: "+couleur+", personne: "+personne.getNom()+", quantitéObservée: "+quantiteObservee+", type: "+type+", sexe: "+sexe+", cri: "+cri;
    }

    @Override
    public void cri() {
         Scanner clavier = new Scanner(System.in);
         System.out.println("Entrez le cri de l'animal.");
         cri=clavier.nextLine();
    }
    
    
    
}
