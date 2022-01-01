package principal;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

public class Jeu06DeplacementDuVoleurUTest {
    Joueur j1 = new Joueur("j1", enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
    Joueur j2 = new Joueur("j2", enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
    Joueur j3 = new Joueur("j3", enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
    List<Joueur> joueurs = new LinkedList<Joueur>();
    De6Faces de1 = new De6Faces();
    De6Faces de2 = new De6Faces();
    Jeu jeu;
    @BeforeEach
    public void initPartie() {
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        jeu = new Jeu(joueurs, 5, 5, de1, de2, OptionalLong.of(123456));
        assertThat(de1.getValeurDe()).isGreaterThan(0);
    }

    @Test
    public void deplacementVoleur() {
        assertThat(jeu.getAire().getIdTuileVoleur()).isEqualTo(12);
        assertThat(jeu.getAire().getTuiles().get(12).isVoleurPresent()).isTrue();
        jeu.getAire().deplaceVoleur(16);
        assertThat(jeu.getAire().getIdTuileVoleur()).isEqualTo(16);
        assertThat(jeu.getAire().getTuiles().get(12).isVoleurPresent()).isFalse();
        assertThat(jeu.getAire().getTuiles().get(16).isVoleurPresent()).isTrue();
    }


}
