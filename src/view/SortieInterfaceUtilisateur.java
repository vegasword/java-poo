package view;

import java.util.ArrayList;

import models.*;

public class SortieInterfaceUtilisateur {
   public static void menuPrincipal()  {
      System.out.println("-~-~- FAIR FIGHT -~-~-\n1. Play\n2. Quit");
   }

   public static void  afficherJeu(Joueur joueur, ArrayList<Ennemi> ennemis) {
      System.out.println(joueur.getNom() + " : " + joueur.getPv() + " PV, " + joueur.getForce() + " FORCE, " + joueur.getOr() + " OR");
      for (Ennemi ennemi : ennemis) {
         System.out.println(ennemi.getNom() + " : " + ennemi.getPv() + " PV, " + ennemi.getForce() + " FORCE");
      }
      System.out.println("-----------------------\n1. Attaque\n2. Défendre\n3. Utiliser objet");
   }

   public static void afficherAttaque(Personnage a, Personnage b, int degat) {
      System.out.println(a.getNom() + " attaque " + b.getNom() + " en lui infligeant " + degat + " dégâts !");
   }

   public static void afficherDefense(Personnage p) {
      System.out.println( p.getNom() + " choisit de se défendre au prochani tour");
   }

   public static void afficherObjets(Personnage p) {
      System.out.println("Objets de " + p.getNom() + ": ");
      for(Objet objet : p.getInventaire()) {
         System.out.println("-> " + objet.getNom());
      }
   }

   public static void interactionPersonnageObject(Personnage personnage, Objet objet, boolean utilisation) {
      if (utilisation) {
         System.out.println(personnage.getNom() + " utilise " + objet.getNom());
      } else {
         System.out.println(personnage.getNom() + " ramasse " + objet.getNom());
      }
   }

   // ToDo : afficher boutique
   public static void afficherEntracte(Joueur joueur)
   {
      System.out.println("-----------------------\n" +
              "Vous avez fini une bataille, que vous voulez vous faire :\n" +
              "1_modifier équipement" +
              "2_aller a la boutique" +
              "3_retourner au combat");
   }

}
