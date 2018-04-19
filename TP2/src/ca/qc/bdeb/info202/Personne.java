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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1660802
 */
public class Personne {
    ArrayList<String> liste = new ArrayList();
    private String nom, nomUtilisisateur, codeEncrypte;
    private int age;

    public Personne(String nom, String nomUtilisisateur, String codeEncrypte, int age) {
        this.nom = nom;
        this.nomUtilisisateur = nomUtilisisateur;
        this.codeEncrypte = codeEncrypte;
        this.age = age;
    }
    
    public void lecturePersonne(){
        BufferedReader lecture=null;
        String ligne=null;
        
        while(ligne!=null){
        try{
             lecture = new BufferedReader ( new FileReader("personnes.txt"));
        }catch(FileNotFoundException e){ 
            System.out.println("Le fichier n'est pas trouvé.");
        }
        try {   
           ligne=lecture.readLine();
        } catch (IOException ex) {
            
        }
        
        liste.add(ligne);
        
    }
    }
    
}
