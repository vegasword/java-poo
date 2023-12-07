package models;

public abstract class Objet {
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public void interraction()
    {
        System.out.print("un objet interragit avec le joueur");
    }
}



