package models;

public class Arme extends Objet{
    private int degat;
    private int durabilite;

    public Arme (String nom, int prixAchat, int prixVente,int degat,int durabilite){
        super(nom, prixAchat, prixVente);

        this.degat = degat;
        this.durabilite = durabilite;
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
}
