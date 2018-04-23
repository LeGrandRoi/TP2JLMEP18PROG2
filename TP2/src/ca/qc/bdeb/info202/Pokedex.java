/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

import ca.qc.bdeb.info202.Animal.Sexe;
import ca.qc.bdeb.info202.MammifereMarin.TypeEau;
import ca.qc.bdeb.info202.MammifereMarin.TypeManger;
import ca.qc.bdeb.info202.PlanteAquatique.TypePlante;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1745982
 */
public class Pokedex {
   private ArrayList <Specimen> liste=new ArrayList();
   private Scanner clavier=new Scanner(System.in);
           TypeEau typeEau;
           TypePlante typePlante;
           TypeManger typeManger;
           Sexe sexe;
           int numeroSerie;
           String dateObservation;
           String nom;
           int taille;
           String couleur;
           Personne personne;
           
   public Pokedex()
   {
       
   }
   public void jouer()
   {
       afficherInterface();
   }
   
   private void afficherInterface()
   {
       System.out.println("veuillez entrer votre nom d'utilisateur: ");
       String nomUtilisateur;
       nomUtilisateur=clavier.nextLine();
       System.out.println("Veuillez entrer votre mot de passe: ");
       String motPasse;
       motPasse=clavier.nextLine();
       
   }
   
   private void afficherMenu()
   {
       int choix=0;
       boolean ok=true;
       do
       {
           ok=true;
       System.out.println("Veuillez choisir une option:");
       System.out.println("1. Consulter les spécimens déjà saisis.\n"
               + "2. Saisir un nouveau spécimen.\n"
               + "3. Modifier un spécimen.\n"
               + "4. Statistiques.\n"
               + "5. Quitter.");
       try{
           choix=Integer.parseInt(clavier.nextLine());
       }
       catch(NumberFormatException e){ 
           ok=false;
       }
       if (choix<1 || choix>5)
       {
           System.out.println("I. Veuillez entrer un choix entre 1 et 5.");
           System.out.println("");
       }
       } while (choix<1 || choix>5 || !ok);
       
       switch (choix){
           case 1: consulterSpecimens();
               break;
           case 2: nouveauSpecimen();
               break;
           case 3:
               break;
           case 4:
               break;
           case 5:
               break;
       }
       
   }
   
   private void consulterSpecimens()
   {
       
   }
   
   private void nouveauSpecimen()
   {
       int dateObservation=0;
       int typeS=0;
       boolean ok=true;
       do
       {
       try
       {
           ok=true;
       System.out.println("II. Date d'observation: (AAAAJJMM)");
       dateObservation=Integer.parseInt(clavier.nextLine());
       }
       catch(NumberFormatException e){ 
           ok=false;
       }
       } while (!ok);
       
       do
       {
       System.out.println("Type de spécimen:\n"
               + "1-Poisson.\n"
               + "2-Mammifère marin.\n"
               + "3-Plante.\n"
               + "4-Minéral.\n");
       try
       {
           ok=true;
           typeS=Integer.parseInt(clavier.nextLine());
       }
       catch(NumberFormatException e){ 
           ok=false;
       }
       if (typeS<1 || typeS>4)
       {
           System.out.println("I. Veuillez entrer un choix entre 1 et 5.");
           System.out.println("");
       }
       } while (typeS<1 || typeS>4 || !ok);
       
       if (typeS==1 || typeS==2 || typeS==3 || typeS==4)
       {
           System.out.println("Veuillez entrer le nom du spécimen:");
           nom=clavier.nextLine();
       }
       
       if (typeS==1 || typeS==2 || typeS==3 || typeS==4)
       {
           System.out.println("Veuillez entrer la taille du spécimen:");
           do
           {
           try{
               ok=true;
           taille=Integer.parseInt(clavier.nextLine());
           }
           catch (NumberFormatException e){
               ok=false;
           }
           } while (!ok);
       }
       
       if (typeS==1 || typeS==2 || typeS==3 || typeS==4)
       {
           System.out.println("Veuillez entrer la taille du spécimen:");
           do
           {
           try{
           ok=true;
           dateObservation=Integer.parseInt(clavier.nextLine());
           }
           catch (NumberFormatException e){
           ok=false;
           }
           } while (!ok);
       }
       
       if (typeS==1 || typeS==2 || typeS==3 || typeS==4)
       {
           System.out.println("Veuillez entrer la couleur du spécimen:");
           couleur=clavier.nextLine();
       }
        if (typeS==1 || typeS==2)
       {
           System.out.println("Veuillez entrer le genre: ");
           
       }
       
       }
   }

