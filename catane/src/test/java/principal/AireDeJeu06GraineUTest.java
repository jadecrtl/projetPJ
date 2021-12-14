package principal;

import java.util.OptionalLong;

import org.junit.jupiter.api.Test;

import enums.Terrain;

import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu06GraineUTest {
    
    @Test
    public void creationPlateauNonAleatoire() {
        AireDeJeu aire = new AireDeJeu(5, 3, OptionalLong.of(123));
        aire.traceAireDeJeu();
        assertThat(aire.getTuiles().get(0).getJeton()).isEqualTo(4);
        assertThat(aire.getTuiles().get(0).getTerrain()).isEqualTo(Terrain.PRE);
                
    }







}
