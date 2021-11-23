package enums;

import org.junit.jupiter.api.Test;

import principal.Joueur;

public class CouleurUTest {
    @Test
    public void ecritureEnCouleurs() {
        Joueur j1 = new Joueur("j1", 1, TypeJoueur.HUMAIN, Couleur.BLANC);
        Joueur j2 = new Joueur("j2", 1, TypeJoueur.HUMAIN, Couleur.BLEU);
        System.out.println(j1.getCouleur().getCrayon() + "ce texte doit s'ecrire en blanc" + "\033[0m");
        System.out.println(j2.getCouleur().getCrayon() + "ce texte doit s'ecrire en bleu" + "\033[0m");
    }
}
