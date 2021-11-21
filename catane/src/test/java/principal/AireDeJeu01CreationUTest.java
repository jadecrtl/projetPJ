package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AireDeJeu01CreationUTest {

    @Test
    public void creationPlateauAvecCoordonnéesA0() {
        assertThatThrownBy(() -> new AireDeJeu(0, 0)).isInstanceOf(IllegalArgumentException.class);        
    }

    @Test
    public void creationPlateauTropPetit() {
        assertThatThrownBy(() -> new AireDeJeu(4, 3)).isInstanceOf(IllegalArgumentException.class);
    }




}
