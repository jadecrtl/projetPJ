package principal;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class Route01CreationUTest {

    @Test
    public void routeAvecIdCroisementNegatif() {
        assertThatThrownBy(() -> new Route(-2, -1, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Route(-19, 4, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void routeAvecIdCroisementIdentique() {
        assertThatThrownBy(() -> new Route(0, 0, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Route(1, 1, null)).isInstanceOf(IllegalArgumentException.class);    }

    @Test
    public void routeAvecIdCroisementAPlusGrandQueIdCroisementB() {
        Joueur j1 = new Joueur("j1", 20, TypeJoueur.HUMAIN, Couleur.ROUGE);
        Route r1 = new Route(3, 2, j1);
        assertThat(r1.getIdCroisementA()).isEqualTo(2);
        assertThat(r1.getIdCroisementB()).isEqualTo(3);
    }






}
