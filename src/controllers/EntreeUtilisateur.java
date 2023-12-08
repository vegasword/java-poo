package controllers;

import models.Personnage;

import java.util.*;
public class EntreeUtilisateur {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * Fonction permettant a l'utilisateur de faire tous les choix qu'il peut faire
     * 
     * @param min La valeur minimale que l'utilisateur peut entrer pour son choix
     * @param max La valeur maximal que l'utilisateur peut rentrer pour faire son choix
     * @return Renvoie un nombre entier correspondant au choix de l'utilisateur
     */

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
    /**
     * Fonction permettant a l'utilisateur d'entrer une chaine de caractère, elle permettra ainsi d'initialiser son nom
     * 
     * @param tailleMax Le nombre maximal de caractère de la chaine que le joueur peut envoyer au programme
     * @return Renvoie de la chaine de caractère entré par l'utilisateur
     */
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
    /**
     * Fonction que l'on appelle pour que l'utilisateur puisser rentrer son nom 
     * @return Renvoie une chaine de caractère contenant le nom du joueur
     */

    public static String demandeNom() {
        return entrerChaineCaractere(32);
    }
    
    /**
     * Fonction que l'on appelle pour que l'utilisateur puisse faire son choix dans le menu principale
     * @return Renvoie un entier en fonction du choix de l'utilisateur dans le menu principale
     */

    public static int menuPrincipal() {
        return faireUnChoix(1, 2);
    }

    /**
     * Fonction que l'on appelle pour que l'utilisateur puisse faire son choix dans le menu action en combat
     * @return Renvoie un entier en fonction du choix de l'utilisateur dans le menu action en combat
     */


    public static int choixAction() {
        return faireUnChoix(1, 4);
    }
    /**
     * Fonction que l'on appelle pour que l'utilisateur puisse choisir l'enemie qu'il veut attaquer
     * @return Renvoie un entier en fonction du choix de l'enemie a attaquer par l'utilisateur
     */

    public static int choixAttaque(int nombreEnnemis) {
        return faireUnChoix(1, nombreEnnemis);
    }

    /**
     * Fonction que l'on appelle pour que l'utilisateur puisse choisir l'objet a utiliser
     * @return Renvoie un entier en fonction du choix de l'objet à utiliser
     */

    public static int choixObjets(Personnage p) {
        return faireUnChoix(1, p.getInventaire().size());
    }

    /**
     * Fonction que l'on appelle pour que l'utilisateur puisse faire son choix dans la boutique
     * @return Renvoie un entier en fonction du choix de l'utilisateur dans la boutique
     */

    public static int choixBoutique() {
        return faireUnChoix(1, 3);
    }
}
