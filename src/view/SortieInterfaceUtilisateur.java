package view;

import java.util.ArrayList;

import models.*;

public class SortieInterfaceUtilisateur {
   public void menuPrincipal()  {
      System.out.println("-~-~- FAIR FIGHT -~-~-\n1. Play\n2. Quit");
   }

   public void afficherJeu(Joueur joueur, ArrayList<Ennemi> ennemis) {
      System.out.println(joueur.getNom() + " : " + joueur.getPv() + " PV, " + joueur.getForce() + " FORCE, " + joueur.getOr() + " OR");
      for (Ennemi ennemi : ennemis) {
         System.out.println(ennemi.getNom() + " : " + ennemi.getPv() + " PV, " + ennemi.getForce() + " FORCE");
      }
      System.out.println("-----------------------\n1. Attaque\n2. Défendre\n3. Utiliser objet");
   }

   public void interactionPersonnageObject(Personnage personnage, Objet objet, boolean utilisation) {
     if (utilisation) {
        System.out.println(personnage.getNom() + " utilise " + objet.getNom());
     } else {
        System.out.println(personnage.getNom() + " ramasse " + objet.getNom());
     }
   }

   public void afficherAttaque(Personnage a, Personnage b, int degat) {
      System.out.println(a.getNom() + " attaque " + b.getNom() + " en lui infligeant " + degat + " dégâts !");
   }

   // ToDo : afficher boutique
   //todo : afficher interface entre 2 combat

}
