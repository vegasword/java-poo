package models;

public class Joueur extends Personnage {
    private int or;
    private int victimes;

    public Joueur(String nom, int pv, int force, int or) {
        super(pv, nom, force);
        this.or = or;
    }

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public int getScore() {
        return this.victimes * this.or;
    }

    @Override
    public int attaque(Personnage cible) {
        int degat = this.getForce();
        Arme armeDuJoueur = this.getArme();
        if (armeDuJoueur != null) {
            degat += armeDuJoueur.getDegat();
            int durabiliteArmeDuJoueur = armeDuJoueur.getDurabilite();;
            armeDuJoueur.setDurabilite(durabiliteArmeDuJoueur - 1);
            if (durabiliteArmeDuJoueur <= 0) {
                System.out.println(this.getNom() + " a cassé son arme " + this.getArme().getNom());
                this.setArme(null);
            }
        }
        if (cible.getSeDefend()) degat /= 4;
        cible.setPv(cible.getPv() - degat);
        int cibleNewPv = cible.getPv();
        if (cibleNewPv < 0) {
            cible.setEstEnVie(false);
            this.or += Math.abs(cibleNewPv);
            victimes++;
        }
        return degat;
    }

    @Override
    public void defense() {
        this.setSeDefend(true);
    }

    public void interagitAvecUnPersonnage(Personnage p) {
        if (p instanceof Ennemi) {
            System.out.println(this.getNom() + " lâche son meilleur regard noir sur " + p.getNom());
        }
    }
}
