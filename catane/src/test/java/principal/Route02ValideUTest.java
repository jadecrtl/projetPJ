package principal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.assertj.core.api.Assertions.assertThat;

public class Route02ValideUTest {
    
    private static AireDeJeu aire;

    @BeforeAll
    public static void declarations() {
        aire = new AireDeJeu(5,3);
        aire.traceAireDeJeu();        
    }


    @Test
    public void testRouteAffreuse(){
        assertThat(aire.isRouteValide(-1, -2)).isFalse();
        assertThat(aire.isRouteValide(0, -2)).isFalse();
        assertThat(aire.isRouteValide(-1, 2)).isFalse();
        assertThat(aire.isRouteValide(0, 2)).isFalse();
        assertThat(aire.isRouteValide(0, 7)).isFalse();
        assertThat(aire.isRouteValide(7, 12)).isFalse();
        assertThat(aire.isRouteValide(24, 18)).isFalse();
        assertThat(aire.isRouteValide(7, 7)).isFalse();
    }

    @Test
    public void testRouteValideBord() {
        assertThat(aire.isRouteValide(0, 6)).isTrue();
        assertThat(aire.isRouteValide(5, 11)).isTrue();
        assertThat(aire.isRouteValide(6, 12)).isTrue();
        assertThat(aire.isRouteValide(11, 17)).isTrue();
        assertThat(aire.isRouteValide(12, 18)).isTrue();
        assertThat(aire.isRouteValide(17, 23)).isTrue();
    }

    @Test
    public void testRouteValideInterieur() {
        assertThat(aire.isRouteValide(0, 1)).isTrue();
        assertThat(aire.isRouteValide(1, 2)).isTrue();
        assertThat(aire.isRouteValide(2, 3)).isTrue();
        assertThat(aire.isRouteValide(4, 5)).isTrue();
        assertThat(aire.isRouteValide(6, 7)).isTrue();
        assertThat(aire.isRouteValide(7, 8)).isTrue();
        assertThat(aire.isRouteValide(8, 9)).isTrue();
        assertThat(aire.isRouteValide(9, 10)).isTrue();
        assertThat(aire.isRouteValide(10, 11)).isTrue();
        assertThat(aire.isRouteValide(12, 13)).isTrue();
        assertThat(aire.isRouteValide(13, 14)).isTrue();
        assertThat(aire.isRouteValide(14, 15)).isTrue();
        assertThat(aire.isRouteValide(15, 16)).isTrue();
        assertThat(aire.isRouteValide(16, 17)).isTrue();
        assertThat(aire.isRouteValide(18, 19)).isTrue();
        assertThat(aire.isRouteValide(19, 20)).isTrue();
        assertThat(aire.isRouteValide(20, 21)).isTrue();
        assertThat(aire.isRouteValide(21, 22)).isTrue();
        assertThat(aire.isRouteValide(22, 23)).isTrue();
    }

    @Test
    public void testRouteInvalideBord() {
        assertThat(aire.isRouteValide(0, 7)).isFalse();
        assertThat(aire.isRouteValide(0, 12)).isFalse();
        assertThat(aire.isRouteValide(5, 6)).isFalse();
        assertThat(aire.isRouteValide(5, 10)).isFalse();
        assertThat(aire.isRouteValide(5, 17)).isFalse();
        assertThat(aire.isRouteValide(11, 4)).isFalse();
        assertThat(aire.isRouteValide(11, 16)).isFalse();
        assertThat(aire.isRouteValide(11, 23)).isFalse();
        assertThat(aire.isRouteValide(6, 13)).isFalse();
        assertThat(aire.isRouteValide(17, 22)).isFalse();
        assertThat(aire.isRouteValide(12, 19)).isFalse();
        assertThat(aire.isRouteValide(12, 17)).isFalse();
        assertThat(aire.isRouteValide(0, 5)).isFalse();
        assertThat(aire.isRouteValide(18, 23)).isFalse();
    }

    @Test
    public void testRouteInvalideInterieur() {
        assertThat(aire.isRouteValide(0, 2)).isFalse();
        assertThat(aire.isRouteValide(2, 5)).isFalse();
        assertThat(aire.isRouteValide(4, 6)).isFalse();
        assertThat(aire.isRouteValide(6, 8)).isFalse();
        assertThat(aire.isRouteValide(8, 11)).isFalse();
        assertThat(aire.isRouteValide(13, 15)).isFalse();
        assertThat(aire.isRouteValide(21, 23)).isFalse();
        assertThat(aire.isRouteValide(3, 15)).isFalse();
    }



}
