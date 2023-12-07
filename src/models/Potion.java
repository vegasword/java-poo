package models;

public class Potion extends Objet{
    private int bonusSante;

    public Potion(String nom, int prixAchat, int prixVente, int bonusSante){
        super(nom, prixAchat, prixVente);
        this.bonusSante = bonusSante;
    }

    public int getBonusSante() {
        return bonusSante;
    }

    public void setBonusSante(int bonusSante) {
        this.bonusSante = bonusSante;
    }

    public void soin(Personnage cible) {
        cible.setPv(cible.getPv() + getBonusSante());
    }
}
