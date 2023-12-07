package models;

public class Armure extends Objet{
    private int defense;
    private int durabilite;

    public Armure (String nom, int prixAchat, int prixVente,int  defense,int durabilite){
        super(nom, prixAchat, prixVente);

        this.defense = defense;
        this.durabilite = durabilite;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDurabilite() {
        return durabilite;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }
}
