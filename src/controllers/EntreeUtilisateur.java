package controllers;

import models.Personnage;

import java.util.*;

public class EntreeUtilisateur {
    private static Scanner scanner = new Scanner(System.in);

    private static int faireUnChoix(int min, int max) {
        int choix;
        do {
            choix = scanner.nextInt();
            if (choix < min || choix > max) {
                System.out.println("Entrez une valeur valide !");
            }
        } while (choix < min || choix > max);
        return choix;
    }

    private static String entrerChaineCaractere(int tailleMax) {
       String chaine = new String();
       boolean chaineValide = false;
       do {
           try {
               chaine = scanner.next();
               if (chaine.length() > tailleMax) {
                System.out.println("Votre chaîne de caractères doit être inférieure à " + tailleMax);
               } else {
                   chaineValide = true;
               }
           } catch (NoSuchElementException e) {
               System.out.println("Entrez une chaîne de caractères non vide !\n" + e.getMessage());
           } catch (IllegalStateException e) {
               System.out.println("Impossible de récupérer la chaîne de caractères spécifiée !\n" + e.getMessage());
           }
       } while (!chaineValide);
       return chaine;
    }

    public static String demandeNom() {
        return entrerChaineCaractere(32);
    }

    public static int menuPrincipal() {
        return faireUnChoix(1, 2);
    }

    public static int choixAction() {
        return faireUnChoix(1, 4);
    }

    public static int choixAttaque(int nombreEnnemis) {
        return faireUnChoix(1, nombreEnnemis);
    }

    public static int choixObjets(Personnage p) {
        return faireUnChoix(1, p.getInventaire().size());
    }

    public static int choixBoutique() {
        return faireUnChoix(1, 3);
    }
}
