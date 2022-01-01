package principal;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

public class Jeu03LancePartieUTest {
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
        jeu = new Jeu(joueurs, 5, 3, de1, de2, OptionalLong.of(123));
        assertThat(de1.getValeurDe()).isGreaterThan(0);

    }

    @Test
    public void lancePartie3Joueurs() {
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 7, 8)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 8)).isTrue();
        assertThat(j2.placeRouteGratuite(jeu.getAire(), 13, 14)).isTrue();
        assertThat(j2.placeColonieGratuite(jeu.getAire(), 14)).isTrue();       
        assertThat(j3.placeRouteGratuite(jeu.getAire(), 9, 10)).isTrue();
        assertThat(j3.placeColonieGratuite(jeu.getAire(), 10)).isTrue();
        jeu.getAire().traceAireDeJeu();
    }

    @Test
    public void lancePartie3JoueursPlacementColonie8Incorrecte() {
        //Cas colonie 8
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 7, 8)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 8)).isTrue();

        assertThat(j1.placeRouteGratuite(jeu.getAire(), 2, 8)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 2)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 8, 9)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 9)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 8, 14)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 14)).isFalse();
    }        
    @Test
    public void lancePartie3JoueursPlacementColonie1Incorrecte() {
        //Cas colonie 1
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 0, 1)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 1)).isTrue();

        assertThat(j1.placeRouteGratuite(jeu.getAire(), 0, 6)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 0)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 1, 7)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 7)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 1, 2)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 2)).isFalse();
    }
    @Test
    public void lancePartie3JoueursPlacementColonie6Incorrecte() {
        //Cas colonie 6
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 6, 7)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 6)).isTrue();

        assertThat(j1.placeRouteGratuite(jeu.getAire(), 0, 6)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 0)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 6, 12)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 12)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 7, 8)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 7)).isFalse();
    }
    @Test
    public void lancePartie3JoueursPlacementColonie12Incorrecte() {
        //Cas colonie 12
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 12, 13)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 12)).isTrue();

        assertThat(j1.placeRouteGratuite(jeu.getAire(), 6, 12)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 6)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 12, 18)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 18)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 13, 14)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 13)).isFalse();
    }
    @Test
    public void lancePartie3JoueursPlacementColonie11Incorrecte() {
        //Cas colonie 11
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 10, 11)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 11)).isTrue();

        assertThat(j1.placeRouteGratuite(jeu.getAire(), 5, 11)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 5)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 9, 10)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 10)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 11, 17)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 17)).isFalse();
    }
    @Test
    public void lancePartie3JoueursPlacementColonie17Incorrecte() {
        //Cas colonie 17
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 16, 17)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 17)).isTrue();

        assertThat(j1.placeRouteGratuite(jeu.getAire(), 11, 17)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 11)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 17, 23)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 23)).isFalse();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 15, 16)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 16)).isFalse();

        jeu.getAire().traceAireDeJeu();
    }

    @Test 
    public void lancePartieAvecDes() {
        assertThat(de1.getValeurDe() + de2.getValeurDe()).isBetween(2, 12);
        assertThat(jeu.getLancementDes()).isBetween(2, 12);
        jeu.getAire().traceAireDeJeu();
        jeu.assigneRessourceTirageDes(11);
    }



}
