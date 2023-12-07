package models;

public class Arme {
    private String nom;

    private int prixAchat;

    private int prixVente;
    private int degat;
    private int durabilite;

    public Arme (String nom, int prixAchat, int prixVente,int degat,int durabilite){
        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.degat = degat;
        this.durabilite = durabilite;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrixAchat() {
        return this.prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getPrixVente() {
        return this.prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public int getDurabilite() {
        return this.durabilite;
    }

    public int  getDegat() {
        return  this.degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }


    public void interraction()
    {
        System.out.print("un personnage interragit avec le joueur");
    }
}
