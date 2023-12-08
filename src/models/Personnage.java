package models;

import java.util.ArrayList;

public abstract class Personnage implements Interactif {
    private int maxPV;
    private int pv;
    private String nom;
    private int force;
    private boolean seDefend;
    private boolean estEnVie;

    private Arme arme;
    private Armure armure;
    private ArrayList<Objet> inventaire = new ArrayList();

    /**
     * Constructeur de la base de personnage
     * @param pv Nombre de points de vie du personnage
     * @param nom Nom du personnage
     * @param force Points de force du personnage
     */
    public Personnage(int pv, String nom, int force) {
        this.force = force;
        this.maxPV = pv;
        this.pv = pv;
        this.nom = nom;
        this.seDefend = false;
        this.estEnVie = true;
        this.arme = null;
        this.armure = null;
    }

    // Getters

    public int getPv() {
        return this.pv;
    }

    public int getMaxPV() { return this.maxPV; }

    public int getForce() {
        return this.force;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean getSeDefend() {
        return this.seDefend;
    }

    public boolean getEstEnVie() {
        return this.estEnVie;
    }

    public Arme getArme() {
        return this.arme;
    }

    public Armure getArmure() {
        return this.armure;
    }

    public ArrayList<Objet> getInventaire() {
        return this.inventaire;
    }

    // Setters

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setSeDefend(boolean seDefend) {
        this.seDefend = seDefend;
    }

    public void setEstEnVie(boolean estEnVie) {
        this.estEnVie = estEnVie;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setArmure(Armure armure) {
        this.armure = armure;
    }

    /**
     *  Le personnage attaque une cible
     *  @param cible Personnage ciblé par l'attaque
     *  @return Retourne les dégâts infligé
     */
    public abstract int attaque(Personnage cible);

    /**
     * Le personnage se défend et réduit les dégâts qu'il subit
     */
    public abstract void defense();

    public void interagitAvecUnPersonnage(Personnage personnage) { }
}

