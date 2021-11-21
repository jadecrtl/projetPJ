package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu02CroisementsVoisinsUTest {

    @Test
    public void creationAireDeJeuEtCroisementsVoisins() {
        AireDeJeu aire = new AireDeJeu(7, 5);
        assertThat(aire.getTuiles().get(0).getCroisementsVoisins()).containsExactly(0,1,8,9);
        assertThat(aire.getTuiles().get(3).getCroisementsVoisins()).containsExactly(3,4,11,12);
        assertThat(aire.getTuiles().get(6).getCroisementsVoisins()).containsExactly(6,7,14,15);
        assertThat(aire.getTuiles().get(7).getCroisementsVoisins()).containsExactly(8,9,16,17);
        assertThat(aire.getTuiles().get(17).getCroisementsVoisins()).containsExactly(19,20,27,28);
        assertThat(aire.getTuiles().get(28).getCroisementsVoisins()).containsExactly(32,33,40,41);
        assertThat(aire.getTuiles().get(34).getCroisementsVoisins()).containsExactly(38,39,46,47);
    }



}
