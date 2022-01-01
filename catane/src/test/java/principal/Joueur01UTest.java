package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Joueur01UTest {
    
    @Test
    public void creationJoueurSansRien() {
        assertThatThrownBy(() -> new Joueur(null, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creationJoueurScoreZero() {
        Joueur jade = new Joueur("Jade", enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        assertThat(jade.getPointVictoire()).isEqualTo(0);
    }    

    @Test
    public void modifierPointVictoire() {
        Joueur paris = new Joueur("Paris", enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        assertThat(paris.getPointVictoire()).isEqualTo(0);
        paris.ajouterPointVictoire(7);
        assertThat(paris.getPointVictoire()).isEqualTo(7);
        paris.ajouterPointVictoire(2);
        assertThat(paris.getPointVictoire()).isEqualTo(9);
    }



}
