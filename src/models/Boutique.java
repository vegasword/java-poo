package models;

import java.util.*;

public class Boutique {
    private ArrayList<Objet> objetDisponible;

    public Boutique(Joueur j) {
        this.objetDisponible = new ArrayList<Objet>();

        Random random = new Random();
        int itemRandomId = random.nextInt(0, 2);
        switch (itemRandomId) {
            case 0:
                j.setArme(new Arme("Tmp", 1, 2, 3, 4));
                break;

            case 1:
                this.objetDisponible.add(new Armure("Oe de ouf", 1, 2, 3, 4));
                break;

            case 2:
                this.objetDisponible.add(new Potion("Tkt", 1, 2, 3));
        }
    }

    public ArrayList<Objet> getObjetDisponible() {
        return objetDisponible;
    }

    public void acheterObjet(Joueur joueur, Objet objet) {
        int prixAchat = objet.getPrixAchat();

        if (joueur.getOr() >= prixAchat) {
            joueur.setOr(joueur.getOr() - prixAchat);
            System.out.println("Achat réussi : " + objet.getNom() + " pour " + prixAchat + " ecus.");
        } else {
            System.out.println("Pas assez d'ecus. Impossible d'acheter " + objet.getNom() + ".");
        }
    }

    public void vendreObjet(Joueur joueur, Objet objet) {
        int prixVente = objet.getPrixVente();

        joueur.setOr(joueur.getOr() + prixVente);
        System.out.println("Vente réussie : " + objet.getNom() + " pour " + prixVente + " ecus.");
    }


}

