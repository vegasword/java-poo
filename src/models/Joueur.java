package models;

public class Joueur extends Personnage {
    private int or;

    public Joueur (String nom,int pv,int force,int or, boolean formation){
        super(pv, nom, force,formation);
        this.or = or;

    }
    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public void interraction()
    {
        System.out.print("un personnage interragit avec le joueur");
    }

    @Override
    public void attaque (Personnage cible, Arme armeUtilisee)
    {
        int degat = this.getForce()+armeUtilisee.getDegat();

        if (!cible.getFormation())
        {
            degat = degat/4;
        }

        cible.setPv(cible.getPv() - degat);

        System.out.println("le joueur attaque");
    }
    
  @Override
    public void defense()
    {
        this.setFormation(false);
        System.out.println("le joueur se defend");
    }
}
