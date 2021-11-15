package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

public class Jeu02FinPartieUTest {

    @Test
    public void creationJeuTroisJoueurs() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        Jeu maPartie = new Jeu(joueurs);
        assertThat(maPartie.isJeuTermine()).isFalse();
        j1.ajouterPointVictoire(5);
        j2.ajouterPointVictoire(8);
        j3.ajouterPointVictoire(2);
        assertThat(maPartie.isJeuTermine()).isFalse();
        j1.ajouterPointVictoire(2);
        j2.ajouterPointVictoire(2);
        assertThat(maPartie.isJeuTermine()).isTrue();
    }




}
