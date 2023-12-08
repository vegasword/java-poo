package models;

public class Ennemi extends Personnage {
    /**
     * Constructeur de la base de l'ennemi
     * @param nom Nom
     * @param pv Pv
     * @param force Force
     */
    public Ennemi(String nom, int pv, int force) {
        super(pv, nom, force);
    }

    /**
     * L'ennemi attaque une cible
     * @param cible Personnage ciblé par l'attaque
     * @return
     */
    @Override
    public int attaque(Personnage cible) {
        int degat = this.getForce();
        Arme armeEnnemie = this.getArme();
        if (armeEnnemie != null) {
            degat += armeEnnemie.getDegat();
        }
        if (cible.getSeDefend()) {
            degat /= 2;
        }

        Armure armureCible = cible.getArmure();
        if (armureCible != null) {
            degat -= armureCible.getDefense();
            if (degat < 0) {
                degat = 0;
            }

            armureCible.setDurabilite(armureCible.getDurabilite() - 1);
            if (armureCible.getDurabilite() < 0) {
                cible.setArmure(null);
            }
        }

        cible.setPv(cible.getPv() - degat);
        if (cible.getPv() < 0) {
            cible.setEstEnVie(false);
        }
        return degat;
    }

    /**
     * L'ennemi se défend de la prochaine attaque subit
     */
    @Override
    public void defense() {
        this.setSeDefend(true);
    }

    /**
     * Interaction de la base d'ennemi avec un personnage spécifié
     * @param personnage Personnage concerné
     */
    public void interagitAvecUnPersonnage(Personnage personnage) {
        if (personnage instanceof Joueur) {
            System.out.println(this.getNom() + " insulte " + personnage.getNom());
        } else if (personnage instanceof Ennemi) {
            System.out.println(this.getNom() + " encourage ses alliés à aller se battre avant lui...");
        }
    }
}
