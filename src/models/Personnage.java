package models;

public class Personnage {
    private int pv;
    private String nom;
    private int force;

    public Personnage(int pv, String nom, int force) {

        this.force = force;
        this.pv = pv;
        this.nom = nom;

    }

    public int getPv() {
        return this.pv;
    }

    public int getForce() {
        return this.force;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}

