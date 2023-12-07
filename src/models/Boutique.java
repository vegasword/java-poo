package models;

import java.util.*;

public class Boutique {
    private Objet objetDisponible;

    public Boutique() {
        Random random = new Random();
        int itemRandomId = random.nextInt(0, 2);
        switch (itemRandomId) {
            case 0:
                this.objetDisponible = new Arme("Tmp", 1, 2, 3, 4);
                break;

            case 1:
                this.objetDisponible = new Armure("Oe de ouf", 1, 2, 3, 4);
                break;

            case 2:
                this.objetDisponible = new PotionSoin(3);
                break;
        }
    }

    public Objet getObjetDisponible() {
        return objetDisponible;
    }

    public void acheterObjet(Joueur joueur) {
        int prixAchat = objetDisponible.getPrixAchat();
        if (joueur.getOr() >= prixAchat) {
            joueur.setOr(joueur.getOr() - prixAchat);
            this.objetDisponible.interagitAvecUnPersonnage(joueur);
        } else {
            System.out.println("Pas assez d'or ! Impossible d'acheter " + objetDisponible.getNom() + ".");
        }
    }

    public void vendreObjet(Joueur joueur, Objet objet) {
        int prixVente = objet.getPrixVente();

        joueur.setOr(joueur.getOr() + prixVente);
        System.out.println("Vente réussie : " + objet.getNom() + " pour " + prixVente + " ecus.");
    }


}

