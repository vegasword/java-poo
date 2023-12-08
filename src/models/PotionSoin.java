package models;

public class PotionSoin extends Objet {
    private int bonusSante;

    /**
     * Constructeur de la base d'une potion de soin
     * @param nom Nom de la potion de soin
     * @param prixAchat Prix d'achat en boutique de la potion de soin
     * @param prixVente Prix de vente en boutique de la poition de soin
     * @param bonusSante Points de régénération lors du soin sur un personnage
     */
    public PotionSoin(String nom, int prixAchat, int prixVente, int bonusSante){
        super(nom, prixAchat, prixVente);
        this.bonusSante = bonusSante;
    }

    // Getters

    public int getBonusSante() {
        return bonusSante;
    }

    // Setters

    public void setBonusSante(int bonusSante) {
        this.bonusSante = bonusSante;
    }

    /**
     * Soigne n'importe quel personnage
     * @param cible Personnage concerné
     */
    private void soin(Personnage cible) {
        int maxPV = cible.getMaxPV();
        int totalSoin  = cible.getPv() + getBonusSante();
        if (totalSoin < maxPV) {
            cible.setPv(totalSoin);
        } else {
            cible.setPv(maxPV);
        }
    }

    /**
     * Implémentation de l'interaction entre la poition et n'importe quel personange souhaitant se soigner
     * @param personnage Personnage concerné
     */
    public void interagitAvecUnPersonnage(Personnage personnage) {
        System.out.println(personnage.getNom() + " se soigne de " + this.bonusSante + " PV !");
        this.soin(personnage);
    }
}
