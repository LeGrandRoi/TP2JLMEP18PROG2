/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202;



/**
 *
 * @author 1660802
 */
public class Personne {
    
    private String nom, nomUtilisisateur, codeEncrypte;
    private int age;

    public Personne( String nomUtilisisateur, String codeEncrypte,String nom, int age) {
        
        this.nomUtilisisateur = nomUtilisisateur;
        this.codeEncrypte = codeEncrypte;
        this.nom = nom;
        this.age = age;
    }

    public String getNomUtilisisateur() {
        return nomUtilisisateur;
    }

    public String getCodeEncrypte() {
        return codeEncrypte;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }
    

    
    
    
}
