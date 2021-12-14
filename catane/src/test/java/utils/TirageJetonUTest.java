package utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.OptionalLong;

public class TirageJetonUTest {
    
    @Test
    public void TirageJetonSansGraine() {
        int i = 0;
        while (i<6000) {
            assertThat(new TirageJeton(null).getTirage()).isBetween(2, 12)
                                                         .isNotEqualTo(7);
            i++;
        }
    }

    @Test
    public void TirageJetonAvecGraine() {
        assertThat(new TirageJeton(OptionalLong.of(123)).getTirage()).isEqualTo(4);
    }

}
