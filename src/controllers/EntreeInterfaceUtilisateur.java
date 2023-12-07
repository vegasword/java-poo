package controllers;
import models.Joueur;

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

    public static int entreeMenuPrincipal()
    {
        return faireUnChoix(1, 2);
    }

    public static int choixCombat()
    {
        return faireUnChoix(0, 4);
    }

    public int entreeAfficherEntracte(){return faireUnChoix(0, 4);}

    //TODO: Choix de l'ennemi à attaquer
}
