import controllers.*;

public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        if (jeu.initialiseJeu()) {
            jeu.boucleDeJeu();
        }
    }
}