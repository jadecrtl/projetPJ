package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class TuileUTest {
    
    @Test
    public void creationTuileIdNegatif() {
        assertThatThrownBy(() -> new Tuile(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creationTuile() {
        Tuile t = new Tuile(1);
        assertThat(t.getCroisementsVoisins().size()).isEqualTo(0);
    }


}
