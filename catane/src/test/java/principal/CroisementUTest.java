package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CroisementUTest {
    
    @Test
    public void creationTuileIdNegatif() {
        assertThatThrownBy(() -> new Croisement(-1)).isInstanceOf(IllegalArgumentException.class);
    }
    
}
