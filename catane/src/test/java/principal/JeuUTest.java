package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;

public class JeuUTest {

    @Test
    public void creationJeuSansRien() {
        assertThatThrownBy(() -> new Jeu(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creationJeuDeuxJoueurs() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        assertThatThrownBy(() -> new Jeu(joueurs)).isInstanceOf(IllegalArgumentException.class);
    }

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
        assertThat(maPartie.getJeuTermine()).isFalse();
    }

    @Test
    public void creationJeuQuatreJoueurs() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        Joueur j4 = new Joueur("j4", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.VERT);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        joueurs.add(j4);
        Jeu maPartie = new Jeu(joueurs);
        assertThat(maPartie.getJeuTermine()).isFalse();
    }

    @Test
    public void creationJeuCinqJoueurs() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        Joueur j4 = new Joueur("j4", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.VERT);
        Joueur j5 = new Joueur("j5", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        joueurs.add(j4);
        joueurs.add(j5);
        assertThatThrownBy(() -> new Jeu(joueurs)).isInstanceOf(IllegalArgumentException.class);
    }



}
