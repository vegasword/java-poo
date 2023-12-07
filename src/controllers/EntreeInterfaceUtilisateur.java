package controllers;
import java.util.*;

public class EntreeInterfaceUtilisateur {
    private Scanner scanner = new Scanner(System.in);

    private int faireUnChoix(int min, int max) {
        int choix;
        do {
            choix = scanner.nextInt();
            if (choix < min && choix > max) {
                System.out.println("Entrez une valeur valide !");
            }
        } while (choix < min && choix > max);
        return choix;
    }

    public int entreeMenuPrincipal()
    {
        return faireUnChoix(1, 2);
    }

    public int entreeAfficherJeu()
    {
        return faireUnChoix(0, 4);
    }

    //TODO: Choix de l'ennemi à attaquer
}
