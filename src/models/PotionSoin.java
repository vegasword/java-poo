package models;

public class PotionSoin extends Objet {
    private int bonusSante;

    public PotionSoin(int bonusSante){
        super("Potion", 20, 10);
        this.bonusSante = bonusSante;
    }

    public int getBonusSante() {
        return bonusSante;
    }

    public void setBonusSante(int bonusSante) {
        this.bonusSante = bonusSante;
    }

    private void soin(Personnage cible) {
        int maxPV = cible.getMaxPV();
        int totalSoin  = cible.getPv() + getBonusSante();
        if (totalSoin < maxPV) {
            cible.setPv(totalSoin);
        } else {
            cible.setPv(maxPV);
        }
    }

    public void interagitAvecUnPersonnage(Personnage personnage) {
        this.soin(personnage);
    }
}
