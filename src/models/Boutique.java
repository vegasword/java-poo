package models;

import java.util.ArrayList;
import java.util.List;

public class Boutique {
    private final List<Objet> objetsDisponibles;

    public Boutique() {
        objetsDisponibles = new ArrayList<>();
        initialiserBoutique();
        System.out.println("Boutique Crée !");

    }

    private void initialiserBoutique() {
        Arme sword1 = new Arme("Épée en bois", 5, 2, 5, 10);
        Arme lance = new Arme("Lance en bois", 5, 2, 10, 5);
        objetsDisponibles.add(sword1);
        objetsDisponibles.add(lance);
    }
    public List<Objet> getObjetsDisponibles() {
        return objetsDisponibles;
    }

    public void acheterObjet(Joueur joueur, Objet objet) {
        int prixAchat = objet.getPrixAchat();

        if (joueur.getOr() >= prixAchat) {
            joueur.setOr(joueur.getOr() - prixAchat);
            System.out.println("Achat réussi : " + objet.getnom() + " pour " + prixAchat + " ecus.");
        } else {
            System.out.println("Pas assez d'ecus. Impossible d'acheter " + objet.getnom() + ".");
        }
    }

    public void vendreObjet(Joueur joueur, Objet objet) {
        int prixVente = objet.getPrixVente();

        joueur.setOr(joueur.getOr() + prixVente);
        System.out.println("Vente réussie : " + objet.getnom() + " pour " + prixVente + " ecus.");
    }


}

