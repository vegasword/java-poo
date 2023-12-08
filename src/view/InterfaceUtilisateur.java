package view;

import java.util.ArrayList;

import models.*;

/**
 * Classe de type Singleton (que des déclarations de méthodes statique)
 * En charge de l'interface utilisateur
 */
public class InterfaceUtilisateur {

    /**
     * Affiche le menu principal
     */
    public static void menuPrincipal() {
        System.out.println("-~-~- FAIR FIGHT -~-~-");
        System.out.println("1. Play");
        System.out.println("2. Quit");
    }

    /**
     * Demande le nom
     */
    public static void demandeNom() {
        System.out.println("Quel est votre surnom ?");
    }

    /**
     * Affiche l'état du jeu
     * @param joueur Joueur concerné
     * @param ennemis Liste des ennemis
     */
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

    /**
     * Affiche une attaque quelconque
     * @param attaquant Personnage attaquant
     * @param victime Personnage défendant
     * @param degat Dégâts infligé par l'attaquant
     */
    public static void afficherAttaque(Personnage attaquant, Personnage victime, int degat) {
        System.out.println(attaquant.getNom() + " attaque " + victime.getNom() +
                " en lui infligeant " + degat + " dégâts !");
    }

    /**
     * Affiche un message signalant que tel personnage se défend
     * @param personnage Personnage concerné
     */
    public static void afficherDefense(Personnage personnage) {
        System.out.println(personnage.getNom() + " choisit de se défendre");
    }

    /**
     * Affiche l'utilisation d'un objet par un personnage
     * @param personnage Personnage concerné
     */
    public static void afficherObjets(Personnage personnage) {
        System.out.println("Objets de " + personnage.getNom() + ": ");
        int objetId = 1;
        for (Objet objet : personnage.getInventaire()) {
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
