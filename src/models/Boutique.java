package models;

import java.util.*;

public class Boutique {
    private Objet objetDisponible;

    public Boutique() {
        Random random = new Random();
        int itemRandomId = random.nextInt(0, 2);
        switch (itemRandomId) {
            case 0: {
                int armeRandomId = random.nextInt(0, 3);
                switch (armeRandomId) {
                    case 0: this.objetDisponible = new EpeeCourte(); break;
                    case 1: this.objetDisponible = new EpeeLongue(); break;
                    case 2: this.objetDisponible = new Claymore(); break;
                }
            }
            break;

            case 1: {
                int armureRandomId = random.nextInt(0, 3);
                switch (armureRandomId) {
                    case 0: this.objetDisponible = new ArmureEnCarton(); break;
                    case 1: this.objetDisponible = new ArmureEnPierre(); break;
                    case 2: this.objetDisponible = new ArmureLourde(); break;
                }
            }
            break;

            case 2: {
                int potionRandomId = random.nextInt(0, 2);
                switch (potionRandomId) {
                    case 0: this.objetDisponible = new PetitePotionSoin(); break;
                    case 1: this.objetDisponible = new GrossePotionSoin(); break;
                }
            }
            break;
        }
    }

    public Objet getObjetDisponible() {
        return this.objetDisponible;
    }

    public void acheterObjet(Joueur joueur) {
        int prixAchat = this.objetDisponible.getPrixAchat();
        if (joueur.getOr() >= prixAchat) {
            joueur.setOr(joueur.getOr() - prixAchat);
            if (this.objetDisponible instanceof Arme) {
                joueur.setArme((Arme)this.objetDisponible);
            } else {
                joueur.getInventaire().add(this.objetDisponible);
            }
            this.objetDisponible.interagitAvecUnPersonnage(joueur);
        } else {
            System.out.println("Pas assez de pièces d'or ! Impossible d'acheter " + objetDisponible.getNom() + ".");
        }
    }

    public void vendreObjet(Joueur joueur, Objet objet) {
        int prixVente = objet.getPrixVente();

        joueur.setOr(joueur.getOr() + prixVente);
        System.out.println("Vous avez vendu " + objet.getNom() + " pour " + prixVente + " pièces d'or.");
    }


}

