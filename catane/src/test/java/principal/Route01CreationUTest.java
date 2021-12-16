package principal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class Route01CreationUTest {

    @Test
    public void routeAvecIdCroisementNegatif() {
        assertThatThrownBy(() -> new Route(-2, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Route(-19, 4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void routeAvecIdCroisementIdentique() {
        assertThatThrownBy(() -> new Route(0, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Route(1, 1)).isInstanceOf(IllegalArgumentException.class);    }

    @Test
    public void routeAvecIdCroisementAPlusGrandQueIdCroisementB() {
        Route r1 = new Route(3, 2);
        assertThat(r1.getIdCroisementA()).isEqualTo(2);
        assertThat(r1.getIdCroisementB()).isEqualTo(3);
    }






}
