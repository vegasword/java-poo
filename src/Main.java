import java.util.*;
import models.*;


public class Main {
    public static void main(String[] args) {

        ArrayList<Ennemi> listeEnemie = new ArrayList<>();
        listeEnemie.add(new Zombie());

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
    }

}