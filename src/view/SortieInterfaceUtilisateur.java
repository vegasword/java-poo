package view;

import java.util.ArrayList;
import models.*; // Import des modèles nécessaires, comme Joueur, Ennemi, Personnage, Objet, etc.

/**
 * Classe pour l'interface utilisateur de sortie, affichant différents éléments du jeu.
 */
public class SortieInterfaceUtilisateur {

   /**
    * Affiche le menu principal du jeu.
    */
   public void menuPrincipal()  {
      System.out.println("-~-~- FAIR FIGHT -~-~-\n1. Play\n2. Quit");
   }

   /**
    * Affiche les détails du joueur et des ennemis.
    * @param joueur L'objet Joueur représentant le joueur.
    * @param ennemis Liste des ennemis actuellement dans le jeu.
    */
   public void afficherJeu(Joueur joueur, ArrayList<Ennemi> ennemis) {
      // Affichage des informations du joueur
      System.out.println(joueur.getNom() + " : " + joueur.getPv() + " PV, " + joueur.getForce() + " FORCE, " + joueur.getOr() + " OR");

      // Boucle pour afficher les informations de chaque ennemi
      for (Ennemi ennemi : ennemis) {
         System.out.println(ennemi.getNom() + " : " + ennemi.getPv() + " PV, " + ennemi.getForce() + " FORCE");
      }

      // Options disponibles pour le joueur
      System.out.println("-----------------------\n1. Attaque\n2. Défendre\n3. Utiliser objet");
   }

   /**
    * Affiche une interaction entre un personnage et un objet.
    * @param personnage Le personnage impliqué dans l'interaction.
    * @param objet L'objet utilisé ou ramassé.
    * @param utilisation Booléen indiquant si l'objet est utilisé (true) ou ramassé (false).
    */
   public void interactionPersonnageObject(Personnage personnage, Objet objet, boolean utilisation) {
      if (utilisation) {
         System.out.println(personnage.getNom() + " utilise " + objet.getNom());
      } else {
         System.out.println(personnage.getNom() + " ramasse " + objet.getNom());
      }
   }

   /**
    * Affiche les détails d'une attaque entre deux personnages.
    * @param a Le personnage attaquant.
    * @param b Le personnage défendant.
    * @param degat Les dégâts infligés lors de l'attaque.
    */
   public void afficherAttaque(Personnage a, Personnage b, int degat) {
      System.out.println(a.getNom() + " attaque " + b.getNom() + " en lui infligeant " + degat + " dégâts !");
   }

   /**
    * Méthode pour afficher les options disponibles pendant l'entracte.
    * ToDo : Implémenter l'affichage de la boutique.
    * @param joueur L'objet Joueur représentant le joueur.
    */
   public void afficherEntracte(Joueur joueur)
   {
      System.out.println("-----------------------\n" +
              "Vous avez fini une bataille, que vous voulez vous faire :\n" +
              "1_modifier équipement" +
              "2_aller a la boutique" +
              "3_retourner au combat");
   }

}
