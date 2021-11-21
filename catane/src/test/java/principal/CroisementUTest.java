package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
public class CroisementUTest {
    
    @Test
    public void creationCroisementIdNegatif() {
        assertThatThrownBy(() -> new Croisement(-1)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void creationCroisement() {
        Croisement c = new Croisement(1);
        assertThat(c.getTuilesVoisines().size()).isEqualTo(0);
    }

}
