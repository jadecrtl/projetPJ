package utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class De6facesUTest {
    
    @Test
    @DisplayName("Teste du de de 6 faces")
    void lanceDe6Faces() {
        De6Faces d1 = new De6Faces();
        int i = 0;

        while (i<6000) {
            d1.lanceDe();
            assertThat(d1.getValeurDe()).isBetween(1, 6);
            i++;
        }
    }

}
