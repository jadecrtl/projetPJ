package principal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Route01CreationUTest {

    @Test
    public void routeAvecIdCroisementNegatif() {
        //On a delegue la verification de coordonnees negatives et de coordonnees identiques 
        //a isRouteValide pour eviter d'avoir une exception et donc eviter l'arret du jeu
        AireDeJeu aire = new AireDeJeu(5, 3, null);
        Route r1 = new Route(-2, -1);
        assertThat(r1.getIdCroisementA()).isEqualTo(-2);
        assertThat(r1.getIdCroisementB()).isEqualTo(-1);
        assertThat(aire.isRouteValide(-2, -1)).isFalse();
    }

    @Test
    public void routeAvecIdCroisementIdentique() {
        AireDeJeu aire = new AireDeJeu(5, 3, null);

        Route r1 = new Route(0, 0);
        assertThat(r1.getIdCroisementA()).isEqualTo(0);
        assertThat(r1.getIdCroisementB()).isEqualTo(0);
        assertThat(aire.isRouteValide(0, 0)).isFalse();
        
        Route r2 = new Route(7, 7);
        assertThat(r2.getIdCroisementA()).isEqualTo(7);
        assertThat(r2.getIdCroisementB()).isEqualTo(7);
        assertThat(aire.isRouteValide(7, 7)).isFalse();
    }

    @Test
    public void routeAvecIdCroisementAPlusGrandQueIdCroisementB() {
        Route r1 = new Route(3, 2);
        assertThat(r1.getIdCroisementA()).isEqualTo(2);
        assertThat(r1.getIdCroisementB()).isEqualTo(3);
    }






}
