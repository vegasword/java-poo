package models;

public class PotionSoin extends Objet {
    private int bonusSante;

    public PotionSoin(String nom, int prixAchat, int prixVente, int bonusSante){
        super(nom, prixAchat, prixVente);
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
        System.out.println(personnage.getNom() + " se soigne de " + this.bonusSante + " PV !");
        this.soin(personnage);
    }
}
