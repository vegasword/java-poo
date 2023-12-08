package models;

public interface Interactif
{
    /**
     * Implémentation obligatoire d'une interaction avec un personnage pour les personnages et les objets créés
     * @param personnage Personnage concerné
     */
    public void interagitAvecUnPersonnage(Personnage personnage);
}
