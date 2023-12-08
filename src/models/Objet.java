package models;

public abstract class Objet implements Interactif {
    private String nom;
    private int prixAchat;
    private int prixVente;

    /**
     * Constructeur de la base d'un objet de jeu
     * @param nom Nom de l'objet de jeu
     * @param prixAchat Prix d'achat en boutique de l'objet de jeu
     * @param prixVente Prix de vente en boutique de l'objet de jeu
     */
    public Objet(String nom, int prixAchat, int prixVente) {
        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }

    // Getters

    public String getNom() {
        return this.nom;
    }

    public int getPrixAchat() {
        return this.prixAchat;
    }

    public int getPrixVente() {
        return this.prixVente;
    }


    public void interagitAvecUnPersonnage(Personnage personnage) { }
}



