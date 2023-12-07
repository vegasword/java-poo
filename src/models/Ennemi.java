package models;

public class  Ennemi extends Personnage {

    public Ennemi (String nom, int pv, int force){
        super(pv, nom, force);
    }

    @Override
    public void attaque (Personnage cible, Arme armeUtilisee)
    {
        cible.setPv(cible.getPv() - (this.getForce())+armeUtilisee.getDegat());

        System.out.println("le joueur attaque");
    }
    @Override
    public void defense()
    {
        this.setDefensif(true);
    }

    public void interraction()
    {
        System.out.print("un enemie interragit avec le joueur");
    }
}
