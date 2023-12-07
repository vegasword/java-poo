package models;

public class  Ennemi extends Personnage {

    public Ennemi (String nom,int pv,int force){

        super(pv, nom, force);

    }


    @Override
    public void attaque(Personnage cible) {

    }

    @Override
    public void defense() {

    }
}
