package utils;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;
import principal.Joueur;

public class TerminalCouleurUTest {
    @Test
    public void ecritureEnCouleurs() {
        TerminalCouleur t = new TerminalCouleur();
        Joueur j1 = new Joueur("j1", 1, TypeJoueur.HUMAIN, Couleur.BLANC);
        Joueur j2 = new Joueur("j2", 1, TypeJoueur.HUMAIN, Couleur.BLEU);
        t.print(j1.getCouleur().getCrayon(), "Le joueur j1 ecrit en blanc");
        t.nouvelleLigne();
        t.print(j2.getCouleur().getCrayon(), "Le joueur j2 ecrit en bleu");
        t.println(j1.getCouleur().getStabilo(), "Le joueur j1 ecrit en noir sur fond blanc");
        t.println(j2.getCouleur().getStabilo(), "Le joueur j2 ecrit en noir sur fond bleu");
        t.print(null, "texte avec couleur par defaut");
    }
}
