import java.util.*;
import models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Boutique maBoutique = new Boutique();
        List<Objet> objetsDisponibles = maBoutique.getObjetsDisponibles();

        for (Objet objet : objetsDisponibles) {
            System.out.println(objet.getnom() + ", Prix: " + objet.getPrixVente() + " ecus");
        }


    }
}
