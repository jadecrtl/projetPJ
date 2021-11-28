package utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TirageJetonUTest {
    
    @Test
    public void TirageJeton() {
        int i = 0;
        while (i<6000) {
            assertThat(new TirageJeton().tirage()).isBetween(2, 12)
                                                  .isNotEqualTo(7);
            i++;
        }
    }


}
