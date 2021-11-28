package principal;

import org.junit.jupiter.api.Test;

import enums.Terrain;

import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu05AssignationTerrainTuilesUTest {

    @Test
    public void verifieDesertAuMilieu() {
        AireDeJeu aire = new AireDeJeu(5, 5);
        assertThat(aire.getTuiles().get(12).getTerrain()).isEqualTo(Terrain.DESERT);
    }

}
