package controllers;

import models.Personnage;

import java.util.*;

public class EntreeInterfaceUtilisateur {
    private static Scanner scanner = new Scanner(System.in);

    private static int faireUnChoix(int min, int max) {
        int choix;
        do {
            choix = scanner.nextInt();
            if (choix < min && choix > max) {
                System.out.println("Entrez une valeur valide !");
            }
        } while (choix < min && choix > max);
        return choix;
    }

    public static int menuPrincipal()
    {
        return faireUnChoix(1, 2);
    }

    public static int choixJeu()
    {
        return faireUnChoix(0, 4);
    }

    public static int choixObjets(Personnage p) {
        int choix = faireUnChoix(0, p.getInventaire().size());
        p.getInventaire().get(choix).utiliser();
        return choix;
    }

    public int entreeAfficherEntracte(){return faireUnChoix(0, 4);}

    //TODO: Choix de l'ennemi à attaquer
}
