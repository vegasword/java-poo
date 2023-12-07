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

    public Jeu(int maxEnnemis) {
        this.random = new Random(1337);
        this.maxEnnemis = maxEnnemis;
    }

    public boolean initialiseJeu() {
        InterfaceUtilisateur.menuPrincipal();
        if (EntreeUtilisateur.menuPrincipal() == 1) {
            InterfaceUtilisateur.demandeNom();
            String nomDuJoueur = EntreeUtilisateur.demandeNom();
            this.joueur = new Joueur(nomDuJoueur, 20, 15, 30);

            this.ennemis = new ArrayList<Ennemi>();
            int nombreZombie = this.random.nextInt(1, maxEnnemis);
            for (int i = 0; i < nombreZombie; ++i) this.ennemis.add(new Zombie());
            if (maxEnnemis - nombreZombie > 0) {
                int nombreSquelette = this.random.nextInt(1, maxEnnemis);
                for (int i = 0; i < nombreSquelette; ++i) this.ennemis.add(new Squelette());
            }

            this.boutique = new Boutique();

            return true;
        } else {
            return false;
        }
    }

    public void boucleDeJeu() {
        while (this.joueur.getPv() > 0) {
            // Combat
            while (!ennemis.isEmpty()) {
                System.out.flush();
                InterfaceUtilisateur.afficherJeu(this.joueur, this.ennemis);
                int choixAction = EntreeUtilisateur.choixAction();
                switch (choixAction) {
                    case 1: { // Attaquer
                        System.out.print("Attaquer la cible n°");
                        int choixCible = EntreeUtilisateur.choixAttaque(this.ennemis.size());
                        int degat = this.joueur.attaque(this.ennemis.get(choixCible - 1));
                        InterfaceUtilisateur.afficherAttaque(this.joueur, this.ennemis.get(0), degat);
                    }
                    break;

                    case 2: { // Défense
                        this.joueur.setSeDefend(true);
                        InterfaceUtilisateur.afficherDefense(this.joueur);
                    }
                    break;

                    case 3: { // Utiliser un objet
                        InterfaceUtilisateur.afficherObjets(this.joueur);
                        int choixObjet = EntreeUtilisateur.choixObjets(this.joueur);
                        Objet objetChoisi = this.joueur.getInventaire().get(choixObjet);
                        objetChoisi.interagitAvecUnPersonnage(this.joueur);
                        InterfaceUtilisateur.affichierUtilisationObjet(this.joueur, objetChoisi);
                    }
                    break;
                }

                // Phase attaque ennemie
                for (Ennemi ennemi : this.ennemis) {
                    if (ennemi.getPv() > 0) {
                        int degat = ennemi.attaque(this.joueur);
                        InterfaceUtilisateur.afficherAttaque(this.joueur, ennemi, degat);
                    }
                }
                this.joueur.setSeDefend(false);
            }

            // Phase boutique
            this.boutique = new Boutique();
            InterfaceUtilisateur.afficherBoutique(this.boutique);
            int choixBoutique = EntreeUtilisateur.choixBoutique();
            switch (choixBoutique) {
                case 1: { // Achat
                    this.boutique.acheterObjet(this.joueur);
                }
                break;

                case 2: { // Vente objet
                    int choixVente = EntreeUtilisateur.choixObjets(this.joueur);
                    this.boutique.vendreObjet(this.joueur, this.joueur.getInventaire().get(choixVente));
                }
                break;

                case 3: {
                    System.out.println("Le combat continue !");
                    break;
                }
            }
        }

        // Fin du jeu
        InterfaceUtilisateur.afficherGameOver(this.joueur.getScore());
    }
}
