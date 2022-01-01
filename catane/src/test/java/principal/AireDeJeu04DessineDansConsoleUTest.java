package principal;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeCroisement;
import enums.TypeJoueur;


public class AireDeJeu04DessineDansConsoleUTest {
    @Test
    public void dessineAireDeJeu() {
        AireDeJeu aire = new AireDeJeu(7, 5, null);
        Joueur j1 = new Joueur("j1", TypeJoueur.HUMAIN, Couleur.BLEU);
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.BLANC);
        Joueur j3 = new Joueur("j3", TypeJoueur.HUMAIN, Couleur.ROUGE);
        Joueur j4 = new Joueur("j4", TypeJoueur.HUMAIN, Couleur.VERT);
        aire.getCroisements().get(0).setProprietaire(j1, TypeCroisement.COLONIE);
        aire.getCroisements().get(1).setProprietaire(j2, TypeCroisement.COLONIE);
        aire.getCroisements().get(2).setProprietaire(j3, TypeCroisement.COLONIE);
        aire.getCroisements().get(36).setProprietaire(j1, TypeCroisement.COLONIE);
        aire.getCroisements().get(37).setProprietaire(j2, TypeCroisement.COLONIE);
        aire.getCroisements().get(38).setProprietaire(j3, TypeCroisement.COLONIE);

        aire.getCroisements().get(19).setProprietaire(j4, TypeCroisement.COLONIE);
        aire.getCroisements().get(20).setProprietaire(j4, TypeCroisement.VILLE);
        aire.getCroisements().get(27).setProprietaire(j4, TypeCroisement.VILLE);
        aire.getCroisements().get(28).setProprietaire(j4, TypeCroisement.COLONIE);

        aire.getCroisements().get(9).setProprietaire(j1, TypeCroisement.VILLE);
        aire.getCroisements().get(10).setProprietaire(j2, TypeCroisement.VILLE);
        aire.getCroisements().get(11).setProprietaire(j3, TypeCroisement.VILLE);
        aire.getCroisements().get(45).setProprietaire(j1, TypeCroisement.VILLE);
        aire.getCroisements().get(46).setProprietaire(j2, TypeCroisement.VILLE);
        aire.getCroisements().get(47).setProprietaire(j3, TypeCroisement.VILLE);

        aire.traceAireDeJeu();
        System.out.println("4 drapeaux francais apparaissent en diagonale et le desert est entoure de vert;");

    }
}
