package models;

public class  Ennemi extends Personnage {

    public Ennemi (String nom, int pv, int force){
        super(pv, nom, force);
    }

    @Override
    public int attaque (Personnage cible, Arme armeUtilisee)
    {
        int degat = this.getForce() + armeUtilisee.getDegat();
        cible.setPv(cible.getPv() - degat);
        return degat;
    }

    @Override
    public void defense()
    {
        this.setDefensif(true);
    }

    public void utiliser()
    {
        System.out.print("un enemie interragit avec le joueur");
    }
}
