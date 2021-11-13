package principal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Joueur01UTest {
    
    @Test
    public void creationJoueurSansRien() {
        assertThatThrownBy(() -> new Joueur(null, 0, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creationJoueurAgeNegatif() {
        assertThatThrownBy(() -> new Joueur("Jade", -1, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC)).isInstanceOf(IllegalArgumentException.class);
    }    

    @Test
    public void creationJoueurScoreZero() {
        Joueur jade = new Joueur("Jade", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        assertThat(jade.getPointVictoire()).isEqualTo(0);
    }    



}
