package models;

public abstract class Objet implements Interactif {
    private String nom;
    private int prixAchat;
    private int prixVente;

    public Objet(String nom, int prixAchat, int prixVente) {

        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;

    }

    public String getNom() {
        return this.nom;
    }

    public int getPrixAchat() {
        return this.prixAchat;
    }

    public int getPrixVente() {
        return this.prixVente;
    }

    public void interagitAvecUnPersonnage(Personnage personnage) { }
}



