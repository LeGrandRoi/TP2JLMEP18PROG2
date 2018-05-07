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
import ca.qc.bdeb.info202.Animal.Sexe;
import ca.qc.bdeb.info202.MammifereMarin.TypeEau;
import ca.qc.bdeb.info202.MammifereMarin.TypeManger;
import ca.qc.bdeb.info202.PlanteAquatique.TypePlante;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1745982
 */
public class Pokedex {

    private ArrayList<Specimen> liste = new ArrayList();
    private Scanner clavier = new Scanner(System.in);
    private int compteur = compter(), compteurcolonne = compterligne();
    private String tabPersonne[][] = new String[compteur][compteurcolonne];
    private ArrayList<Personne> listePersonne = new ArrayList();
    Personne personneActuelle;
    int cptSerie = 0; 
    int cptPoisson = 0;
    int cptMammifereMarin = 0;
    int cptPlanteAquatique;
    int cptMineral = 0;
    int cptAutre = 0;

    public void jouer() {
        liste = fichierBinaireOuverture(liste);
        remplir(tabPersonne);
        login();
        afficherMenu();

    }

    private void afficherMenu() {
        int choix = 0;
        boolean ok = true;
        do {
            do {
                ok = true;
                System.out.println("Veuillez choisir une option:");
                System.out.println("1. Consulter les spécimens déjà saisis.\n"
                        + "2. Saisir un nouveau spécimen.\n"
                        + "3. Modifier un spécimen.\n"
                        + "4. Statistiques.\n"
                        + "5. Quitter.\n");
                try {
                    choix = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
                if (choix < 1 || choix > 5) {
                    System.out.println("I. Veuillez entrer un choix entre 1 et 5.");
                    System.out.println("");
                    ok = false;
                }
            } while (choix < 1 || choix > 5 || !ok);
            System.out.println("");
            switch (choix) {
                case 1:
                    consulterSpecimens();
                    break;
                case 2:
                    nouveauSpecimen();
                    break;
                case 3:
                    modifierSpecimen();
                    break;
                case 4:
                    statistiques();
                    break;
                case 5:
                    fichierBinaireFermeture(liste);
                    break;
            }
        } while (choix != 5);

    }

    private void consulterSpecimens() {
        int choixConsulter = 0;
        boolean ok = true;
        if (liste.size() == 0) {
            System.out.println("Il n'y a présentement pas de spécimens dans le pokédex.");
            System.out.println("");
        } else {
            System.out.println("Vous avez choisi de consulter les spéimens.");
            do {
                try {
                    ok = true;
                    System.out.println("Que voulez-vous afficher? (1. Tout 2. Votre choix)");
                    choixConsulter = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (!ok || choixConsulter < 1 || choixConsulter > 2);
            if (choixConsulter == 1) {
                System.out.println("Affichage de toutes les entrées du pokédex (triés par nom):");
                System.out.println("1.- DE FAÇON CROISSANTE:");
                for (int i = 1; i < liste.size(); i++) {
                    String valeur = liste.get(i).getNom();
                    int position = i;
                    while (position > 0 && liste.get(i - 1).getNom().compareTo(valeur) > 0) {
                        liste.set(position, liste.get(position - 1));
                    }
                }
                for (int i = 0; i < liste.size(); i++) {
                    System.out.println(liste.get(i).toString());
                }
                Stack<Specimen> pile = new Stack();
                for (int i = 0; i < liste.size(); i++) {
                    pile.push(liste.get(i));
                }
                System.out.println("2.- DE FAÇON DÉCROISSANTE: ");
                while (pile.size()>=0) {
                    System.out.println(pile.pop().toString());
                }
            } else if (choixConsulter == 2) {
                int choixSpecimen = 0;
                do {
                    System.out.println("Quelles entrées voulez-vous voir?\n "
                            + "1. Animaux (triés par date d'observation)\n"
                            + "2. Poisons (triés par taille)\n"
                            + "3. Mammifères marins (triés par taille)\n"
                            + "4. Plantes aquatiques (triés par taille)\n"
                            + "5. Minéraux (triés par taille)\n");
                    try {
                        choixSpecimen = Integer.parseInt(clavier.nextLine());
                        ok = true;
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                } while (!ok || choixSpecimen < 1 || choixSpecimen > 5);

                if (choixSpecimen == 1) {
                    System.out.println("affichage de tous les animaux triés par taille:");
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals("Poisson") || liste.get(i).getType().equals("MammifereMarin") || liste.get(i).getType().equals("Autre")) {
                            String valeur = liste.get(i).getDateObservation();
                            int position = i;
                            while (position > 0 && liste.get(i - 1).getDateObservation().compareTo(valeur) > 0) {
                                liste.set(position, liste.get(position - 1));
                            }
                        }
                    }
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals("Poisson") || liste.get(i).getType().equals("MammifereMarin") || liste.get(i).getType().equals("Autre")) {
                            System.out.println(liste.get(i).toString());
                        }
                    }
                } else if (choixSpecimen == 2) {
                    System.out.println("affichage de tous les poissons triés par taille:");
                    Specimen temp;
                    for (int position = liste.size()-1; position >= 0; position--) {
                        if (liste.get(position).getType().equals("Poisson")) {
                            for (int recherche = 0; recherche <= position - 1; recherche++) {
                                if (liste.get(recherche).getTaille() > liste.get(recherche + 1).getTaille()) {
                                    temp = liste.get(recherche);
                                    liste.set(recherche, liste.get(recherche + 1));
                                    liste.set(recherche + 1, temp);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals("Poisson")) {
                            System.out.println(liste.get(i).toString());
                        }
                    }
                } else if (choixSpecimen == 3) {
                    System.out.println("affichage de tous les mammifères marina triés par taille:");
                    Specimen temp;
                    for (int position = liste.size()-1; position >= 0; position--) {
                        if (liste.get(position).getType().equals("MammifereMarin")) {
                            for (int recherche = 0; recherche <= position - 1; recherche++) {
                                if (liste.get(recherche).getTaille() > liste.get(recherche + 1).getTaille()) {
                                    temp = liste.get(recherche);
                                    liste.set(recherche, liste.get(recherche + 1));
                                    liste.set(recherche + 1, temp);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals("MammifereMarin")) {
                            System.out.println(liste.get(i).toString());
                        }
                    }
                } else if (choixSpecimen == 4) {
                    System.out.println("affichage de toutes les plantes aquatiques triés par taille:");
                    Specimen temp;
                    for (int position = liste.size()-1; position >= 0; position--) {
                        if (liste.get(position).getType().equals("PlanteAquatique")) {
                            for (int recherche = 0; recherche <= position - 1; recherche++) {
                                if (liste.get(recherche).getTaille() > liste.get(recherche + 1).getTaille()) {
                                    temp = liste.get(recherche);
                                    liste.set(recherche, liste.get(recherche + 1));
                                    liste.set(recherche + 1, temp);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals("PlanteAquatique")) {
                            System.out.println(liste.get(i).toString());
                        }
                    }
                } else if (choixSpecimen == 5) {
                    System.out.println("affichage de tous les minéraux triés par taille:");
                    Specimen temp;
                    for (int position = liste.size()-1; position >= 0; position--) {
                        if (liste.get(position).getType().equals("Mineral")) {
                            for (int recherche = 0; recherche <= position - 1; recherche++) {
                                if (liste.get(recherche).getTaille() > liste.get(recherche + 1).getTaille()) {
                                    temp = liste.get(recherche);
                                    liste.set(recherche, liste.get(recherche + 1));
                                    liste.set(recherche + 1, temp);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals("Mineral")) {
                            System.out.println(liste.get(i).toString());
                        }
                    }
                }
            }
        }
    }

    private void nouveauSpecimen() {
        TypeEau typeEau = null;
        TypePlante typePlante = null;
        TypeManger typeManger = null;
        Sexe sexe = null;
        int numeroSerie = 0;
        String dateObservation = null;
        String nom = null;
        int taille = 0;
        String couleur = null;
        Personne personne = null;
        int quantiteObservee = 0;
        String type = null;

        int typeS = 0;
        boolean ok = true;
        System.out.println("Vous avez choisi de créer un nouveau spécimen.");
        do {
            System.out.println("Veuillez choisir un type de spécimen:\n"
                    + "1-Poisson.\n"
                    + "2-Mammifère marin.\n"
                    + "3-Plante auqatique.\n"
                    + "4-Minéral.\n"
                    + "5-Autre.\n");
            try {
                ok = true;
                typeS = Integer.parseInt(clavier.nextLine());
            } catch (NumberFormatException e) {
                ok = false;
            }
            if (typeS < 1 || typeS > 5) {
                System.out.println("I. Veuillez entrer un choix entre 1 et 5.");
                System.out.println("");
            }
        } while (typeS < 1 || typeS > 5 || !ok);

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            System.out.println("Veuillez entrer le nom du spécimen:");
            nom = clavier.nextLine();
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            do {
                System.out.println("Veuillez entrer la taille du spécimen: (cm)");

                try {
                    ok = true;
                    taille = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (!ok);
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            System.out.println("Veuillez entrer la date d'observation du spécimen: (AAAAMMJJ)");
            dateObservation = clavier.nextLine();
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            System.out.println("Veuillez entrer la couleur du spécimen:");
            couleur = clavier.nextLine();
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            do {
                System.out.println("Veuillez entrer la quantitée observée:");

                try {
                    ok = true;
                    quantiteObservee = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (!ok);

        }

        if (typeS == 1 || typeS == 2 || typeS == 5) {
            int choix = 0;
            do {
                System.out.println("Veuillez entrer le genre: (1. pour mâle et 2. pour femelle)");

                try {
                    ok = true;
                    choix = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (ok == false || choix < 1 || choix > 2);
            if (choix == 1) {
                sexe = Sexe.MALE;
            } else if (choix == 2) {
                sexe = Sexe.FEMELE;
            }
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4) {
            int choix = 0;
            do {
                System.out.println("Veuillez entrer le type d'eau: (1. pour douce et 2. pour salée)");

                try {
                    ok = true;
                    choix = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (ok == false || choix < 1 || choix > 2);
            if (choix == 1) {
                typeEau = TypeEau.DOUCE;
            } else if (choix == 2) {
                typeEau = TypeEau.SALEE;
            }
        }

        if (typeS == 2) {
            int choix = 0;
            do {
                System.out.println("Veuillez entrer le type de manger: (1. pour carnivore et 2. pour végétarien)");

                try {
                    ok = true;
                    choix = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (ok == false || choix < 1 || choix > 2);
            if (choix == 1) {
                typeManger = TypeManger.CARNIVORE;
            } else if (choix == 2) {
                typeManger = TypeManger.VEGETARIEN;
            }
        }

        if (typeS == 3) {
            int choix = 0;
            do {
                System.out.println("Veuillez entrer le type de plante: (1. pour flottante et 2. pour immergée)");

                try {
                    ok = true;
                    choix = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
            } while (ok == false || choix < 1 || choix > 2);
            if (choix == 1) {
                typePlante = TypePlante.FLOTTANTE;
            } else if (choix == 2) {
                typePlante = TypePlante.IMMERGEE;
            }
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            numeroSerie = cptSerie + 1;
            cptSerie=numeroSerie;
        }

        if (typeS == 1 || typeS == 2 || typeS == 3 || typeS == 4 || typeS == 5) {
            personne = personneActuelle;
        }

        if (typeS == 1) {
            type = "Poisson";
        } else if (typeS == 2) {
            type = "MammifereMarin";
        } else if (typeS == 3) {
            type = "PlanteAquatique";
        } else if (typeS == 4) {
            type = "Mineral";
        } else if (typeS == 5) {
            type = "Autre";
        }

        if (typeS == 1) {
            Poisson poisson = new Poisson(typeEau, sexe, numeroSerie, dateObservation, nom, taille, couleur, personne, quantiteObservee, type);
            liste.add(poisson);
            cptPoisson = cptPoisson + 1;
            personneActuelle.setNbActions(personneActuelle.getNbActions() + 1);
        } else if (typeS == 2) {
            MammifereMarin mammifereMarin = new MammifereMarin(typeEau, typeManger, sexe, numeroSerie, dateObservation, nom, taille, couleur, personne, quantiteObservee, type);
            liste.add(mammifereMarin);
            cptMammifereMarin = cptMammifereMarin + 1;
            personneActuelle.setNbActions(personneActuelle.getNbActions() + 1);
        } else if (typeS == 3) {
            PlanteAquatique planteAquatique = new PlanteAquatique(typeEau, typePlante, numeroSerie, dateObservation, nom, taille, couleur, personne, quantiteObservee, type);
            liste.add(planteAquatique);
            cptPlanteAquatique = cptPlanteAquatique + 1;
            personneActuelle.setNbActions(personneActuelle.getNbActions() + 1);
        } else if (typeS == 4) {
            Mineral mineral = new Mineral(numeroSerie, dateObservation, nom, taille, couleur, personne, quantiteObservee, type);
            liste.add(mineral);
            cptMineral = cptMineral + 1;
            personneActuelle.setNbActions(personneActuelle.getNbActions() + 1);
        } else if (typeS == 5) {
            Autre autre = new Autre(sexe, numeroSerie, dateObservation, nom, taille, couleur, personne, quantiteObservee, type);
            liste.add(autre);
            cptAutre = cptAutre + 1;
            personneActuelle.setNbActions(personneActuelle.getNbActions() + 1);
            ;
        }

        System.out.println("Votre spécimen à été créé!");
        System.out.println("");
    }

    private void modifierSpecimen() {

        int choixAction = 0;
        boolean ok = true;
        if (liste.size() == 0) {
            System.out.println("Il n'y a présentement pas de spécimen dans le pokédex.");
            System.out.println("");
        } else {
            System.out.println("Vous avez choisi de modifier un spécimen.");
            do {
                System.out.println("Que voulez-vous faire?\n"
                        + "1. Supprimer un spécimen.\n"
                        + "2. Modifier la quantité d'un spécimen observé.\n");
                System.out.println("");
                try {
                    ok = true;
                    choixAction = Integer.parseInt(clavier.nextLine());
                } catch (NumberFormatException e) {
                    ok = false;
                }
                if (choixAction < 1 || choixAction > 2) {
                    System.out.println("Veuillez entrer un choix entre 1 et 2.");
                    System.out.println("");
                    ok = false;
                }
            } while (!ok);

            ok = true;
            int choixType = 0;
            if (choixAction == 1) {
                do {
                    System.out.println("Quel est le type du spécimen que vous voulez supprimer?");
                    System.out.println("1. Poisson\n"
                            + "2. Mammifère marin\n"
                            + "3. Plante Aquatique\n"
                            + "4. Minéral\n"
                            + "5. autre");
                    System.out.println("");
                    try {
                        ok = true;
                        choixType = Integer.parseInt(clavier.nextLine());
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                    if (choixAction < 1 || choixAction > 5) {
                        System.out.println("Veuillez entrer un choix entre 1 et 5.");
                        System.out.println("");
                        ok = false;
                    }
                } while (!ok);
                String type = null;
                if (choixType == 1) {
                    type = "Poisson";
                } else if (choixType == 2) {
                    type = "MammifereMarin";
                } else if (choixType == 3) {
                    type = "PlanteAquatique";
                } else if (choixType == 4) {
                    type = "Mineral";
                } else if (choixType == 5) {
                    type = "Autre";
                }

                int cpt = 0;
                int choixPourSupprimer = 0;
                do {
                    System.out.println("Veuillez choisir un spécimen à supprimer: (entrer le numéro)");
                    System.out.println("");
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals(type)) {
                            cpt++;
                            System.out.println((i + 1) + ". " + liste.get(i));
                        }
                    }

                    try {
                        ok = true;
                        choixPourSupprimer = Integer.parseInt(clavier.nextLine()) - 1;
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                    if (choixPourSupprimer < cpt || choixPourSupprimer > cpt) {
                        System.out.println("Veuillez entrer un choix entre 1 et " + cpt + ".");
                        System.out.println("");
                        ok = false;
                    }
                } while (!ok);
                System.out.println("");
                System.out.println("Le spécimen " + liste.get(choixPourSupprimer - 1).toString() + " à été supprimé!");
                liste.remove(choixPourSupprimer - 1);
            } else if (choixAction == 2) {
                do {
                    System.out.println("Quel est le type du spécimen dont vous voulez modifier la quantité?");
                    System.out.println("1. Poisson\n"
                            + "2. Mammifère marin\n"
                            + "3. Plante Aquatique\n"
                            + "4. Minéral\n"
                            + "5. autre");
                    System.out.println("");
                    try {
                        ok = true;
                        choixType = Integer.parseInt(clavier.nextLine());
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                    if (choixAction < 1 || choixAction > 5) {
                        System.out.println("Veuillez entrer un choix entre 1 et 5.");
                        System.out.println("");
                        ok = false;
                    }
                } while (!ok);

                String type = null;
                if (choixType == 1) {
                    type = "Poisson";
                } else if (choixType == 2) {
                    type = "MammifereMarin";
                } else if (choixType == 3) {
                    type = "PlanteAquatique";
                } else if (choixType == 4) {
                    type = "Mineral";
                } else if (choixType == 5) {
                    type = "Autre";
                }

                int cpt = 0;
                int choixPourModifier = 0;
                do {
                    System.out.println("Veuillez choisir un spécimen à modifier: (entrer le numéro)");
                    System.out.println("");
                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getType().equals(type)) {
                            cpt++;
                            System.out.println((i + 1) + ". " + liste.get(i));
                        }
                    }

                    try {
                        ok = true;
                        choixPourModifier = Integer.parseInt(clavier.nextLine()) - 1;
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                    if (choixPourModifier < cpt || choixPourModifier > cpt) {
                        System.out.println("Veuillez entrer un choix entre 1 et " + cpt + ".");
                        System.out.println("");
                        ok = false;
                    }
                } while (!ok);
                System.out.println("");
                System.out.println("Sa quantité actuelle est de: " + liste.get(choixPourModifier - 1).getQuantiteObservee());
                int nb = 0;
                do {
                    System.out.println("Combien voulez-vous ajouter/enlver?");

                    try {
                        ok = true;
                        nb = Integer.parseInt(clavier.nextLine());
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                } while (!ok);
                liste.get(choixPourModifier - 1).setQuantiteObservee((liste.get(choixPourModifier - 1).getQuantiteObservee()) + nb);
                System.out.println("La quantité du spécimen " + liste.get(choixPourModifier - 1).toString() + " à étée modifiée!");
            }

        }

    }

    private void statistiques() {
        System.out.println("Vous avez choisi de consulter les statistiques.");
        System.out.println("Voici le nombre d'entrées pour chaque spécimen:");
        System.out.println("Poisson: " + cptPoisson);
        System.out.println("Mammifère Marin: " + cptMammifereMarin);
        System.out.println("PlanteAquatique: " + cptPlanteAquatique);
        System.out.println("Minéral: " + cptMineral);
        System.out.println("Autre: " + cptAutre);
        System.out.println("");
        System.out.println("Voici le nombre d'entrées par utilisateur: ");
        for (int i = 0; i < listePersonne.size(); i++) {
            System.out.println(listePersonne.get(i).getNom() + ": " + listePersonne.get(i).getNbActions());
        }
        System.out.println("Voici les informations personnelles des utilisateurs:");
        for (int i = 0; i < listePersonne.size(); i++) {
            System.out.println(listePersonne.get(i).toString());
        }
    }

////////////////////////////////////////////////////////////////////////////////
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
            System.out.println("Fichier introuvable.");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Erreur d'accès au fichier.");
            System.exit(0);
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
            System.out.println("Fichier introuvable.");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Erreur d'accès au fichier.");
            System.exit(0);
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
            System.out.println("Fichier introuvable.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Erreur d'accès au fichier.");
            System.exit(0);

        }

        for (int i = 0; i < tabPersonne.length; i++) {
            for (int j = 0; j < tabPersonne[i].length; j++) {

            }
            int nbActions = 0;
            int age = Integer.parseInt(tabPersonne[i][3]);

            Personne personne = new Personne(tabPersonne[i][0], tabPersonne[i][1], tabPersonne[i][2], age, nbActions);

            listePersonne.add(personne);
        }

    }

    public Personne login() {
        String login = null;
        String motDePasseEncryptée = null, motDePasseDécryptée = null, motDePasse = null, nom = null;
        int emplacementMdpi = 0, emplacementMdpj = 0, compteurErreur = 0;
        boolean erreur, trouverlogin = false, trouvermdp = false;

        do {
            System.out.println("Entrez votre nom d'utilisateur.");
            try {
                login = clavier.nextLine();
                System.out.println("Entrez votre mot de passe.");
                motDePasse = clavier.nextLine();
                erreur = false;
            } catch (StringIndexOutOfBoundsException e) {

                erreur = true;
            }

            if (erreur == false) {
                for (int i = 0; i < tabPersonne.length; i++) {
                    for (int j = 0; j < tabPersonne[i].length; j++) {

                        if (login.equals(tabPersonne[i][j])) {
                            trouverlogin = true;
                            emplacementMdpi = i;
                            emplacementMdpj = j + 1;
                        } else {
                            trouvermdp = false;

                        }
                    }
                }
            }
            if (trouverlogin == true) {

                motDePasseEncryptée = tabPersonne[emplacementMdpi][emplacementMdpj];
                try {
                    Encryption encryption = new Encryption();
                    String decrypted = encryption.decrypt(motDePasseEncryptée);
                    motDePasseDécryptée = decrypted;
                } catch (Exception ex) {

                }
                System.out.println(motDePasseDécryptée);

                if (motDePasse.equals(motDePasseDécryptée)) {

                    nom = tabPersonne[emplacementMdpi][emplacementMdpj + 1];
                    System.out.println("Bienvenue dans le Pokédex, " + nom);
                    trouvermdp = true;
                } else {
                    trouvermdp = false;

                }
            }

            if (erreur == true || trouverlogin == false || trouvermdp == false) {
                System.out.println("Le mot de passe entrer ou le nom d'utilisateur n'est pas valide.");
                erreur = true;
                compteurErreur++;
            }

            if (compteurErreur == 3) {
                System.out.println("Vous avez effectué trop d'erreur.");
                System.exit(0);
            }
        } while (erreur == true);

        for (int i = 0; i < listePersonne.size(); i++) {
            if (nom.equals(listePersonne.get(i).getNom())) {
                personneActuelle = listePersonne.get(i);
            }
        }
        return personneActuelle;
    }

    public void fichierBinaireFermeture(ArrayList<Specimen> liste) {
        try {
            FileOutputStream fos
                    = new FileOutputStream("pokédex.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(liste);
            System.out.println("Le Pokédex est enregisté.");
            for (int i = 0; i < liste.size(); i++) {
                System.out.println(liste.get(i));
            }

        } catch (java.io.IOException e) {
            System.out.println("Erreur d'entrées-sorties");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Specimen> fichierBinaireOuverture(ArrayList<Specimen> liste) {
        try {
            FileInputStream fichier = new FileInputStream("pokédex.bin");

            ObjectInputStream ois = new ObjectInputStream(fichier);
            liste = (ArrayList<Specimen>) ois.readObject();
            System.out.println("Version du Pokédec chargé.");
            for (int i = 0; i < liste.size(); i++) {
                System.out.println(liste.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvable.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur classe introuvable");
        } catch (IOException e) {
            System.out.println("Aucune version du Pokédex trouvé.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return liste;
    }

}
