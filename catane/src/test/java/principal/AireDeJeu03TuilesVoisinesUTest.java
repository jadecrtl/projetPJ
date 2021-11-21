package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu03TuilesVoisinesUTest {
    
    @Test
    public void creationAireDeJeuEtTuilesVoisines() {
        AireDeJeu aire = new AireDeJeu(7, 5);
        assertThat(aire.getCroisements().get(0).getTuilesVoisines()).containsExactly(0);
        assertThat(aire.getCroisements().get(1).getTuilesVoisines()).containsExactly(0,1);
        assertThat(aire.getCroisements().get(7).getTuilesVoisines()).containsExactly(6);
        assertThat(aire.getCroisements().get(8).getTuilesVoisines()).containsExactly(0,7);
        assertThat(aire.getCroisements().get(9).getTuilesVoisines()).containsExactly(0,1,7,8);
        assertThat(aire.getCroisements().get(35).getTuilesVoisines()).containsExactly(23,24,30,31);
        assertThat(aire.getCroisements().get(40).getTuilesVoisines()).containsExactly(28);
        assertThat(aire.getCroisements().get(42).getTuilesVoisines()).containsExactly(29,30);
        assertThat(aire.getCroisements().get(47).getTuilesVoisines()).containsExactly(34);
    }

}
