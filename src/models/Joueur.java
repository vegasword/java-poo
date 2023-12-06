package models;

public class Joueur extends Personnage {
    private int or;

    public Joueur (String nom,int pv,int force,int or){
        super(pv, nom, force);
        this.or = or;

    }
    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }
}
