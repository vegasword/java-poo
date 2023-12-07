package models;

public class Joueur extends Personnage {
    private int or;


    public Joueur (String nom, int pv, int force, int or){
        super(pv, nom, force);
        this.or = or;
    }

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public void utiliser()
    {
        System.out.print("un personnage interragit avec le joueur");
    }

    @Override
    public int attaque(Personnage cible, Arme armeUtilisee)
    {
        int degat = this.getForce()+armeUtilisee.getDegat();
        if (!cible.getDefensif())
        {
            degat /= 4;
        }
        cible.setPv(cible.getPv() - degat);
        return degat;
    }
    
  @Override
    public void defense()
    {
        this.setDefensif(true);
    }
}
