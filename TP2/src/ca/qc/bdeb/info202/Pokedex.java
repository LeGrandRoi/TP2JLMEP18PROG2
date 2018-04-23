/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1745982
 */
public class Pokedex {

    private ArrayList<Specimen> liste = new ArrayList();
    private Scanner clavier = new Scanner(System.in);
    int compteur = compter(), compteurcolonne = compterligne();
    String tabPersonne[][] = new String[compteur][compteurcolonne];
    
    public void jouer() {
        remplir(tabPersonne);
//       afficherInterface();
    }

    private void afficherInterface() {
        System.out.println("veuillez entrer votre nom d'utilisateur: ");
        String nomUtilisateur;
        nomUtilisateur = clavier.nextLine();
        System.out.println("Veuillez entrer votre mot de passe: ");
        String motPasse;
        motPasse = clavier.nextLine();

    }

    public int compter() {
        BufferedReader lecture;
        int compteur = 0;
        System.out.println("");
        try {
            lecture = new BufferedReader(new FileReader("personnes.txt"));
            String ligne = lecture.readLine();
            while (ligne != null) {
                compteur++;
                ligne = lecture.readLine();
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        System.out.println(compteur);
        return compteur;

    }

    public int compterligne() {
        BufferedReader lecture;
        int compteurcolonne = 0;
        try {

            lecture = new BufferedReader(new FileReader("personnes.txt"));
            String ligne = lecture.readLine();
            String tabcolonne[];
            while (ligne != null) {
                tabcolonne = ligne.split(";");
                ligne = lecture.readLine();
                compteurcolonne = tabcolonne.length;
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        System.out.println(compteurcolonne);
        return compteurcolonne;
    }

    public void remplir(String tabPersonne[][]) {
        BufferedReader lecture;
        try {

            lecture = new BufferedReader(new FileReader("personnes.txt"));
            String ligne = lecture.readLine();
            for (int i = 0; i < tabPersonne.length; i++) {
                tabPersonne[i] = ligne.split(";");
                ligne = lecture.readLine();
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        for (int i = 0; i < tabPersonne.length; i++) {
            for (int j = 0; j < tabPersonne[i].length; j++) {
                System.out.print(tabPersonne[i][j]);
                System.out.print("\t");

            }
            System.out.println("");
        }

    }

    public void login() {
        
    }
    
    public boolean pseudo(){
        
    }
}
