package models;

import java.util.ArrayList;

public abstract class Personnage implements Interactif {
    private int pv;
    private String nom;
    private int force;

    private boolean formation;

    ArrayList<Objet> inventaire  = new ArrayList();

    public Personnage(int pv, String nom, int force) {

        this.force = force;
        this.pv = pv;
        this.nom = nom;
        this.formation = false;
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

    public abstract void  attaque (Personnage cible);
    public abstract void  defense ();

    public void interraction()
    {
        System.out.print("un personnage interragit avec le joueur");
    }

}

