package controllers;

import models.*;
import view.InterfaceUtilisateur;

import java.util.ArrayList;
import java.util.Random;


public class Jeu {
    private Joueur joueur;
    private ArrayList<Ennemi> ennemis;
    private Boutique boutique;

    private int maxEnnemis;
    private Random random;

    public Jeu() {
        this.random = new Random(1337);
        this.maxEnnemis = 2;
    }

    private void genererEnnemis() {
        this.ennemis = new ArrayList<Ennemi>();
        int nombreZombie = this.random.nextInt(1, this.maxEnnemis);
        for (int i = 0; i < nombreZombie; ++i) this.ennemis.add(new Zombie());
        if (maxEnnemis - nombreZombie > 0) {
            int nombreSquelette = this.random.nextInt(1, this.maxEnnemis);
            for (int i = 0; i < nombreSquelette; ++i) this.ennemis.add(new Squelette());
        }
    }

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

    private void phaseEnnemie() {
        for (Ennemi ennemi : this.ennemis) {
            if (ennemi.getPv() > 0) {
                int degat = ennemi.attaque(this.joueur);
                InterfaceUtilisateur.afficherAttaque(ennemi, this.joueur, degat);
            }
        }
        this.joueur.setSeDefend(false);
    }

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
