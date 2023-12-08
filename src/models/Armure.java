package models;

public class Armure extends Objet {
    private int defense;
    private int durabilite;

    /**
     * Constructeur de la base d'armure
     * @param nom Nom de l'armure
     * @param prixAchat Prix d'achat en boutique de l'armure
     * @param prixVente Prix de vente en boutique de l'armuer
     * @param defense Points de défense procuré par l'armure
     * @param durabilite Durabilité de l'armure
     */
    public Armure (String nom, int prixAchat, int prixVente,int  defense,int durabilite){
        super(nom, prixAchat, prixVente);

        this.defense = defense;
        this.durabilite = durabilite;
    }

    // Getters

    public int getDefense() {
        return defense;
    }

    public int getDurabilite() {
        return durabilite;
    }

    // Setters

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }

    /**
     * Implémentation de l'interaction de la base d'armure pour n'importe quel personnage
     * @param personnage Personnage concerné
     */
    public void interagitAvecUnPersonnage(Personnage personnage) {
        Armure armureDuPersonnage = personnage.getArmure();
        if (armureDuPersonnage != null) {
            System.out.println(personnage.getNom() + " remplace " + armureDuPersonnage + " par " + this.getNom());
        } else {
            System.out.println(personnage.getNom() + " s'équipe de l'armure suivante: " + this.getNom());
        }
        personnage.setArmure(this);
    }
}
