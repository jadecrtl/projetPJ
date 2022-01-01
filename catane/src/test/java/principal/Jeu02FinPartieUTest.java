package principal;

import org.junit.jupiter.api.Test;

import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

public class Jeu02FinPartieUTest {

    De6Faces de1 = new De6Faces();
    De6Faces de2 = new De6Faces();


    @Test
    public void victoireJeuTroisJoueurs() {
        Joueur j1 = new Joueur("j1", enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        Jeu maPartie = new Jeu(joueurs, 5, 3, de1, de2, null);
        assertThat(maPartie.joueurVainqueur()).isNull();
        j1.ajouterPointVictoire(5);
        j2.ajouterPointVictoire(8);
        j3.ajouterPointVictoire(2);
        assertThat(maPartie.joueurVainqueur()).isNull();
        j1.ajouterPointVictoire(2);
        j2.ajouterPointVictoire(2);
        assertThat(maPartie.joueurVainqueur()).isEqualTo(j2);
    }

    @Test
    public void victoireJeuQuatreJoueurs() {
        Joueur j1 = new Joueur("j1", enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        Joueur j4 = new Joueur("j4", enums.TypeJoueur.HUMAIN, enums.Couleur.VERT);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        joueurs.add(j4);        
        Jeu maPartie = new Jeu(joueurs, 5, 3, de1, de2, null);
        assertThat(maPartie.joueurVainqueur()).isNull();
        j1.ajouterPointVictoire(5);
        j2.ajouterPointVictoire(8);
        j3.ajouterPointVictoire(2);
        j4.ajouterPointVictoire(0);
        assertThat(maPartie.joueurVainqueur()).isNull();
        j1.ajouterPointVictoire(6);
        assertThat(maPartie.joueurVainqueur()).isEqualTo(j1);
    }



}
