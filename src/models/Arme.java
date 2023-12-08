package models;

public class Arme extends Objet {
    private int degat;
    private int durabilite;

    /**
     * Constructeur de la base d'une arme
     * @param nom Nom
     * @param prixAchat Prix à l'achat en boutique
     * @param prixVente Prix de vente en boutique
     * @param degat Nombre de dégâts
     * @param durabilite Durabilité de l'arme
     */
    public Arme(String nom, int prixAchat, int prixVente, int degat, int durabilite) {
        super(nom, prixAchat, prixVente);
        this.degat = degat;
        this.durabilite = durabilite;
    }

    // Getters

    public int getDurabilite() {
        return this.durabilite;
    }

    public int getDegat() {
        return this.degat;
    }

    // Setters

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }

    /**
     * Implémentation de l'interaction de la base d'arme pour n'importe quel personnage
     * @param personnage Personnage concerné
     */
    public void interagitAvecUnPersonnage(Personnage personnage) {
        Arme armeDuPersonnage = personnage.getArme();
        if (armeDuPersonnage != null) {
            System.out.println(personnage.getNom() + " remplace " + armeDuPersonnage + " par " + this.getNom());
        } else {
            System.out.println(personnage.getNom() + " s'équipe de l'arme suivante: " + this.getNom());
        }
        personnage.setArme(this);
    }
}
