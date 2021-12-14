package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu01CreationUTest {

    @Test
    public void creationAireDeJeuAvecCoordonnéesA0() {
        assertThatThrownBy(() -> new AireDeJeu(0, 0, null)).isInstanceOf(IllegalArgumentException.class);        
    }

    @Test
    public void creationAireDeJeuTropPetit() {
        assertThatThrownBy(() -> new AireDeJeu(4, 3, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creationAireDeJeuDeTaillePair() {
        assertThatThrownBy(() -> new AireDeJeu(6, 5, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new AireDeJeu(5, 8, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new AireDeJeu(6, 8, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new AireDeJeu(10, 10, null)).isInstanceOf(IllegalArgumentException.class);    }

    @Test
    public void creationAireDeJeu() {
        AireDeJeu aireDeJeu = new AireDeJeu(7, 5, null);
        assertThat(aireDeJeu.getTuiles().size()).isEqualTo(7 * 5);
        assertThat(aireDeJeu.getCroisements().size()).isEqualTo(8 * 6);
    }



}
