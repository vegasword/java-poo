package view;

import java.util.ArrayList;

import models.*;

public class InterfaceUtilisateur {
    public static void menuPrincipal() {
        System.out.println("-~-~- FAIR FIGHT -~-~-");
        System.out.println("1. Play");
        System.out.println("2. Quit");
    }

    public static void demandeNom() {
        System.out.println("Quel est votre surnom ?");
    }

    public static void afficherJeu(Joueur joueur, ArrayList<Ennemi> ennemis) {
        System.out.println(joueur.getNom() + " : " + joueur.getPv() + " PV, " +
                joueur.getForce() + " FORCE, " + joueur.getOr() + " OR");
        int ennemiId = 1;
        for (Ennemi ennemi : ennemis) {
            System.out.println("(" + ennemiId + ") " + ennemi.getNom() + " : " +
                    ennemi.getPv() + " PV, " + ennemi.getForce() + " FORCE");
            ennemiId++;
        }
        System.out.println("-----------------------");
        System.out.println("1. Attaque");
        System.out.println("2. Défendre");
        System.out.println("3. Utiliser objet");
    }

    public static void afficherAttaque(Personnage a, Personnage b, int degat) {
        System.out.println(a.getNom() + " attaque " + b.getNom() +
                " en lui infligeant " + degat + " dégâts !");
    }

    public static void afficherDefense(Personnage p) {
        System.out.println(p.getNom() + " choisit de se défendre");
    }

    public static void afficherObjets(Personnage p) {
        System.out.println("Objets de " + p.getNom() + ": ");
        int objetId = 1;
        for (Objet objet : p.getInventaire()) {
            System.out.println(objetId + ": " + objet.getNom());
            objetId++;
        }
    }

    public static void affichierUtilisationObjet(Personnage personnage, Objet objet) {
        System.out.println(personnage.getNom() + " utilise " + objet.getNom());
    }

    public static void afficherBoutique(Boutique boutique) {
        Objet objetEnVente = boutique.getObjetDisponible();
        System.out.println("La boutique vous offre pour " + objetEnVente.getPrixAchat() +
                " pièces d'or l'objet suivant: " + objetEnVente.getNom());
        System.out.println("-----------------------");
        System.out.println("1. Acheter");
        System.out.println("2. Vendre un unique objet");
        System.out.println("3. Continuer le combat");
    }

    public static void afficherGameOver(int score) {
        System.out.flush();
        System.out.println("-~-~- FAIR FIGHT -~-~-");
        System.out.println("Partie terminée ! Score: " + score);
    }
}
