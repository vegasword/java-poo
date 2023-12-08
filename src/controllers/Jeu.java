package controllers;

import models.*;
import view.InterfaceUtilisateur;

import java.util.ArrayList;
import java.util.Random;

/**
 * classe contenant les informations propre à la partie en cours
 * l'objet Joueur contient les informations du joueur
 * l'objet ennemie contient une liste de tous les enemis que le joueur combat
 * l'objet boutique contient les informations de la boutique 
 * maxEnemis correspond au nombre d'enemie que le joueur doit affronter
 */

public class Jeu {
    private Joueur joueur;
    private ArrayList<Ennemi> ennemis;
    private Boutique boutique;

    private int maxEnnemis;
    private Random random;
    
    /**
    * constructructeur permetant d'initialiser la classe jeu
    */
    public Jeu() {
        this.random = new Random(1337);
        this.maxEnnemis = 2;
    }
    /**
     * fonction permettant de générer les enemies au debut de chaque combat
     * On crée une nouvelle liste d'enemie
     * On la remplit d'un nombre aléatoire d'enemie inférieur ou égale au nombre d'enemie totale que l'on veut
     * On le reste la liste avec notre deuxième enemie
     */

    private void genererEnnemis() {
        this.ennemis = new ArrayList<Ennemi>();
        int nombreZombie = this.random.nextInt(1, this.maxEnnemis);
        for (int i = 0; i < nombreZombie; ++i) this.ennemis.add(new Zombie());
        if (maxEnnemis - nombreZombie > 0) {
            int nombreSquelette = this.random.nextInt(1, this.maxEnnemis);
            for (int i = 0; i < nombreSquelette; ++i) this.ennemis.add(new Squelette());
        }
    }
    /**
     * Fonction permettant d'initialiser une partie
     * Si le joueur décide de commencer une partie, on lui demande d'écrire son nom et on génère la 1ere vague d'enemie
     * Génération du joueur 
     * @return vraie si la partie peut commencer ou false si l'utilisateur demande a quitter le jeu
     */

    public boolean initialiseJeu() {
        InterfaceUtilisateur.menuPrincipal();
        if (EntreeUtilisateur.menuPrincipal() == 1) {
            InterfaceUtilisateur.demandeNom();
            String nomDuJoueur = EntreeUtilisateur.demandeNom();
            this.joueur = new Joueur(nomDuJoueur, 20, 15, 30);
            genererEnnemis();
            this.boutique = new Boutique();
            return true;
        } else {
            return false;
        }
    }

    /**
     * fonction permettant l'execution des actions des enemies lors de combats
     * execution de l'attaque
     * affichage de l'attaque
     */
    private void phaseEnnemie() {
        for (Ennemi ennemi : this.ennemis) {
            if (ennemi.getPv() > 0) {
                int degat = ennemi.attaque(this.joueur);
                InterfaceUtilisateur.afficherAttaque(ennemi, this.joueur, degat);
            }
        }
        this.joueur.setSeDefend(false);
    }
    /**
     * fonction permettant l'execution de la boucle de combat
     * La boucle continue tant que le joueur a des Pv et qu'il y a toujours des enemies
     * affichage de l'etat du combat
     * choix de l'utilisateur
     * execution du choix
     * execution phase enemie
     */
    private void phaseCombat() {
        while (this.joueur.getPv() > 0 && !ennemis.isEmpty()) {
            System.out.flush();
            InterfaceUtilisateur.afficherJeu(this.joueur, this.ennemis);
            int choixAction = EntreeUtilisateur.choixAction();
            switch (choixAction) {
                case 0: continue;

                case 1: { // Attaquer
                    System.out.print("Attaquer la cible n°");
                    int choixCible = EntreeUtilisateur.choixAttaque(this.ennemis.size());
                    Ennemi cible = this.ennemis.get(choixCible - 1);
                    int degat = this.joueur.attaque(cible);
                    InterfaceUtilisateur.afficherAttaque(this.joueur, cible, degat);
                    if (!cible.getEstEnVie()) {
                        ennemis.remove(cible);
                    }
                    phaseEnnemie();
                }
                break;

                case 2: { // Défense
                    this.joueur.setSeDefend(true);
                    InterfaceUtilisateur.afficherDefense(this.joueur);
                    phaseEnnemie();
                }
                break;

                case 3: { // Utiliser un objet
                    ArrayList<Objet> inventaireJoueur = this.joueur.getInventaire();
                    if (!inventaireJoueur.isEmpty()) {
                        InterfaceUtilisateur.afficherObjets(this.joueur);
                        int choixObjet = EntreeUtilisateur.choixObjets(this.joueur);

                        Objet objetChoisi = inventaireJoueur.get(choixObjet);
                        objetChoisi.interagitAvecUnPersonnage(this.joueur);
                        InterfaceUtilisateur.affichierUtilisationObjet(this.joueur, objetChoisi);
                    } else {
                        System.out.println("Votre inventaire est vide !");
                    }
                }
                break;
            }
        }
    }
    /**
     * Fonction permettant de faire son choix lors de la phase d'équipement
     * En fonction du choix, on appelle différentes fonction comme acheter objet, vendre objet
     */
    private void phaseBoutique() {
        this.boutique = new Boutique();
        InterfaceUtilisateur.afficherBoutique(this.boutique);
        int choixBoutique = EntreeUtilisateur.choixBoutique();
        switch (choixBoutique) {
            case 1: { // Achat
                this.boutique.acheterObjet(this.joueur);
            }
            break;

            case 2: { // Vente objet
                ArrayList<Objet> inventaireJoueur = this.joueur.getInventaire();
                if (!inventaireJoueur.isEmpty()) {
                    int choixVente = EntreeUtilisateur.choixObjets(this.joueur);
                    this.boutique.vendreObjet(this.joueur, inventaireJoueur.get(choixVente));
                } else {
                    System.out.println("Cheh ! Votre inventaire est vide !");
                    System.out.println("Le combat continue !");
                }
            }
            break;

            case 3: {
                System.out.println("Le combat continue !");
                break;
            }
        }
    }
/** Fonction contenant la boucle de jeu
 * Elle va apeller les fonction phaseCombat, PhaseBoutique et genererEnemie en boucle
 * C'est cette fonction qui va permettre de jouer autant que l'utilisateur le peux
 * A la sortie de la boucle, on affiche la fin du jeu
 */
    public void boucleDeJeu() {
        while (this.joueur.getPv() > 0) {
            phaseCombat();
            if (this.joueur.getPv() > 0) {
                phaseBoutique();
                this.maxEnnemis++;
                genererEnnemis();
            } else {
                break;
            }
        }
        InterfaceUtilisateur.afficherGameOver(this.joueur.getScore());
    }
}
