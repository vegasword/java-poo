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
        SortieInterfaceUtilisateur.menuPrincipal();
        if(EntreeInterfaceUtilisateur.entreeMenuPrincipal() == 1){
            while(this.joueur.getPv() > 0) {
                //TODO: Phase Combat + Boutique
                do{
                    SortieInterfaceUtilisateur.afficherJeu(this.joueur,this.ennemis);
                    int choix = EntreeInterfaceUtilisateur.choixCombat();
                    if (choix == 1)
                    {
                        int degat = this.joueur.attaque(this.ennemis.get(0), this.joueur.getArme());
                        SortieInterfaceUtilisateur.afficherAttaque(this.joueur,this.ennemis.get(0),degat);
                    }


                }
                while(!ennemis.isEmpty());

            }
        }



       //TODO: Fin du jeu
    }

}
