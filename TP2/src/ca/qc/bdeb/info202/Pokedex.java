/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1745982
 */
public class Pokedex {
   private ArrayList <Specimen> liste=new ArrayList();
   private Scanner clavier=new Scanner(System.in);
   
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
}
