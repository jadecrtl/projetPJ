package principal;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

public class ZInteractifJeu05SelectionDesActionsUTest {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        De6Faces de1 = new De6Faces();
        De6Faces de2 = new De6Faces();
        Jeu jeu;
    
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        jeu = new Jeu(joueurs, 5, 5, de1, de2, OptionalLong.of(123456));
        assertThat(de1.getValeurDe()).isGreaterThan(0);
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 14, 15)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 14)).isTrue();
        assertThat(j2.placeRouteGratuite(jeu.getAire(), 25, 26)).isTrue();
        assertThat(j2.placeColonieGratuite(jeu.getAire(), 25)).isTrue();
        assertThat(j3.placeRouteGratuite(jeu.getAire(), 27, 28)).isTrue();
        assertThat(j3.placeColonieGratuite(jeu.getAire(), 28)).isTrue();
        assertThat(j3.placeRouteGratuite(jeu.getAire(), 7, 8)).isTrue();
        assertThat(j3.placeColonieGratuite(jeu.getAire(), 7)).isTrue();
        assertThat(j2.placeRouteGratuite(jeu.getAire(), 9, 10)).isTrue();
        assertThat(j2.placeColonieGratuite(jeu.getAire(), 10)).isTrue();
        assertThat(j1.placeRouteGratuite(jeu.getAire(), 20, 21)).isTrue();
        assertThat(j1.placeColonieGratuite(jeu.getAire(), 21)).isTrue();
        
        jeu.getAire().traceAireDeJeu();
        jeu.lancePartie();
    }


}