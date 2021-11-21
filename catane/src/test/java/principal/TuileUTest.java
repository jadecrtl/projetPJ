package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TuileUTest {
    
    @Test
    public void creationTuileIdNegatif() {
        assertThatThrownBy(() -> new Tuile(-1)).isInstanceOf(IllegalArgumentException.class);
    }




}
