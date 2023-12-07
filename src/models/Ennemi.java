package models;

public class Ennemi extends Personnage {
    public Ennemi(String nom, int pv, int force) {
        super(pv, nom, force);
    }

    @Override
    public int attaque(Personnage cible) {
        int degat = this.getForce();
        if (this.getArme() != null) {
            degat += this.getArme().getDegat();
        }
        if (cible.getSeDefend()) degat /= 2;
        cible.setPv(cible.getPv() - degat);
        return degat;
    }

    @Override
    public void defense() {
        this.setSeDefend(true);
    }

    public void interagitAvecUnPersonnage(Personnage p) {
        if (p instanceof Joueur) {
            System.out.println(this.getNom() + " insulte " + p.getNom());
        } else if (p instanceof Ennemi) {
            System.out.println(this.getNom() + " encourage ses alliés à aller se battre avant lui...");
        }
    }
}
