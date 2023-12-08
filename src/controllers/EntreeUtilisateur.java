package controllers;

import models.Personnage;

import java.util.*;

public class EntreeUtilisateur {
    private static Scanner scanner = new Scanner(System.in);

    private static int faireUnChoix(int min, int max) {
        int choix = 0;
        do {
            try {
                choix = scanner.nextInt();
                if (choix < min || choix > max) {
                    System.out.println("Entrez une valeur valide !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Java est tellement cool que si tu met du texte à la place d'un chiffre, ça fait crash ! Aurevoir et à très bientôt pour de nouvelles aventures !");
                System.exit(0);
            }
        } while (choix < min || choix > max);
        return choix;
    }

    private static String entrerChaineCaractere(int tailleMax) {
       String chaine = new String();
       boolean chaineValide = false;
       do {
           chaine = scanner.next();
           if (chaine.length() > tailleMax) {
            System.out.println("Votre chaîne de caractères doit être inférieure à " + tailleMax);
           } else {
               chaineValide = true;
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
