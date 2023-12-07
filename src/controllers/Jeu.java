package controllers;

import models.*;
import view.SortieInterfaceUtilisateur;

import java.util.ArrayList;

public class Jeu {
    private Joueur joueur;
    private ArrayList<Ennemi> ennemis;
    private Boutique boutique;

    public Jeu() {
        this.joueur = new Joueur("Steve", 20, 15, 30);

        this.ennemis = new ArrayList<Ennemi>();
        this.ennemis.add(new Zombie());
        this.ennemis.add(new Zombie());
        this.ennemis.add(new Zombie());
        this.ennemis.add(new Squelette());
        this.ennemis.add(new Squelette());
        this.ennemis.add(new Squelette());

        this.boutique = new Boutique(this.joueur);
    }

    public void boucleDeJeu() {
        SortieInterfaceUtilisateur.menuPrincipal();
        if(EntreeInterfaceUtilisateur.menuPrincipal() == 1){
            while(this.joueur.getPv() > 0 || !ennemis.isEmpty()) {
                // Choix des actions disponible
                SortieInterfaceUtilisateur.afficherJeu(this.joueur, this.ennemis);
                int choix = EntreeInterfaceUtilisateur.choixJeu();
                switch (choix) {
                    case 1: { // Attaquer
                        //TODO: Choix attaquer quel ennemi
                        int degat = this.joueur.attaque(this.ennemis.get(0), this.joueur.getArme());
                        SortieInterfaceUtilisateur.afficherAttaque(this.joueur,this.ennemis.get(0),degat);
                    } break;

                    case 2: { // Défense
                        this.joueur.setDefensif(true);
                        SortieInterfaceUtilisateur.afficherDefense(this.joueur);
                    } break;

                    case 3: { // Utiliser un objet
                        SortieInterfaceUtilisateur.afficherObjets(this.joueur);
                        int choixObjet = EntreeInterfaceUtilisateur.choixObjets(this.joueur);
                        this.joueur.getInventaire().get(choixObjet).utiliser();
                    } break;
                }

                //TODO: Execution du combat (Joueur puis ennemis)
                this.joueur.setDefensif(false);
            }
            //TODO: Execution boutique

            //TODO: Fin du jeu
        }
    }
}
