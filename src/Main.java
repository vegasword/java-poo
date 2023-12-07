import java.util.*;
import models.*;
import view.*;
import controllers.*;
public class Main {
    public static void main(String[] args) {

        SortieInterfaceUtilisateur sortie = new SortieInterfaceUtilisateur();
        sortie.menuPrincipal();
        EntreeInterfaceUtilisateur entree = new EntreeInterfaceUtilisateur();

        Joueur joueur = new Joueur("Jean Eudes", 40, 10, 50, false);
        ArrayList<Ennemi> ennemis = new ArrayList<>();
        ennemis.add(new Zombie());
        ennemis.add(new Squelette());
        ennemis.add(new Zombie());

        sortie.afficherJeu(joueur, ennemis);

        switch (entree.entreeAfficherJeu())
        {
            case 1:
                sortie.afficherAttaque(joueur,ennemis.get(1),24);
        }



        /*

        Scanner scanner = new Scanner(System.in);
        System.out.println("entrer le nom de votre perso");
        String nom = scanner.next();

        System.out.println("Si vous la classe lepreux, taper 1");
        System.out.println("Si vous la classe noble, taper 2");
        int choix = scanner.nextInt();
        Joueur persoJoueur = new Joueur(nom,1,1,0,true);
        if (choix == 1)
        {
            persoJoueur.setPv(10);
            persoJoueur.setForce(5);
            Arme penetrator = new Arme("Penetrator",0,0,1,250);
            persoJoueur.inventaire.add(penetrator);
        }
        else if (choix == 2) {
            persoJoueur.setPv(10);
            persoJoueur.setForce(5);
        }

        System.out.println(persoJoueur.inventaire.get(0).getnom());
         */
    }

}