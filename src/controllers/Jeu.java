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

        this.boutique = new Boutique();
    }

    public void boucleDeJeu() {
        //TODO: Phase d'accueil

       while(this.joueur.getPv() > 0) {
          //TODO: Phase Combat + Boutique
       }

       //TODO: Fin du jeu
    }

}
