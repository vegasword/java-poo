import controllers.*;

public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu(3);
        if (jeu.initialiseJeu()) {
            jeu.boucleDeJeu();
        }
    }
}