package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu01CreationUTest {

    @Test
    public void creationAireDeJeuAvecCoordonnéesA0() {
        assertThatThrownBy(() -> new AireDeJeu(0, 0)).isInstanceOf(IllegalArgumentException.class);        
    }

    @Test
    public void creationAireDeJeuTropPetit() {
        assertThatThrownBy(() -> new AireDeJeu(4, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creationAireDeJeu() {
        AireDeJeu aireDeJeu = new AireDeJeu(5, 5);
        assertThat(aireDeJeu.getTuiles().size()).isEqualTo(0);
        assertThat(aireDeJeu.getCroisements().size()).isEqualTo(0);
    }


}
