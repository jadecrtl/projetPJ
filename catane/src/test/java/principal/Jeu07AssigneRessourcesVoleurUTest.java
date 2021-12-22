package principal;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

public class Jeu07AssigneRessourcesVoleurUTest {
    Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
    Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
    Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
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
    public void lancePartie3JoueursPlacementColonieEtAssigneRessources() {
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 14, 15)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 14)).isTrue();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 20, 21)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 21)).isTrue();
        assertThat(j2.placeRouteGratuite(jeu.getAire(), 9, 10)).isTrue();
        assertThat(j2.placeColonieGratuite(jeu.getAire(), 10)).isTrue();
        assertThat(j2.placeRouteGratuite(jeu.getAire(), 25, 26)).isTrue();
        assertThat(j2.placeColonieGratuite(jeu.getAire(), 25)).isTrue();
        assertThat(j3.placeRouteGratuite(jeu.getAire(), 7, 8)).isTrue();
        assertThat(j3.placeColonieGratuite(jeu.getAire(), 7)).isTrue();
        assertThat(j3.placeRouteGratuite(jeu.getAire(), 27, 28)).isTrue();
        assertThat(j3.placeColonieGratuite(jeu.getAire(), 28)).isTrue();
        assertThat(jeu.getLancementDes()).isBetween(2, 12);
        jeu.getAire().traceAireDeJeu();
        jeu.assigneRessourceTirageDes(11);

        assertThat(j1.getInventaireLaine()).isEqualTo(1);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
        assertThat(j1.getInventaireBle()).isEqualTo(0);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireMinerai()).isEqualTo(0);

        assertThat(j2.getInventaireArgile()).isEqualTo(1);
        assertThat(j2.getInventaireLaine()).isEqualTo(0);
        assertThat(j2.getInventaireBle()).isEqualTo(0);
        assertThat(j2.getInventaireBois()).isEqualTo(0);
        assertThat(j2.getInventaireMinerai()).isEqualTo(0);

        assertThat(j3.getInventaireMinerai()).isEqualTo(1);
        assertThat(j3.getInventaireArgile()).isEqualTo(0);
        assertThat(j3.getInventaireBle()).isEqualTo(0);
        assertThat(j3.getInventaireBois()).isEqualTo(0);
        assertThat(j3.getInventaireLaine()).isEqualTo(0);

        jeu.getAire().deplaceVoleur(16);

        jeu.assigneRessourceTirageDes(8);
        jeu.getAire().traceAireDeJeu();

        assertThat(j1.getInventaireLaine()).isEqualTo(2);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
        assertThat(j1.getInventaireBle()).isEqualTo(0);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireMinerai()).isEqualTo(0);

        assertThat(j2.getInventaireArgile()).isEqualTo(1);
        assertThat(j2.getInventaireLaine()).isEqualTo(0);
        assertThat(j2.getInventaireBle()).isEqualTo(0);
        assertThat(j2.getInventaireBois()).isEqualTo(0);
        assertThat(j2.getInventaireMinerai()).isEqualTo(0);

        assertThat(j3.getInventaireMinerai()).isEqualTo(1);
        assertThat(j3.getInventaireArgile()).isEqualTo(0);
        assertThat(j3.getInventaireBle()).isEqualTo(0);
        assertThat(j3.getInventaireBois()).isEqualTo(0);
        assertThat(j3.getInventaireLaine()).isEqualTo(1);
    }




}
