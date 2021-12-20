package utils;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class TriListeUTest {
    @Test
    public void listeEntiersTriCroissant() {
        List<Integer> aTrier = new ArrayList<>();
        List<Integer> triee = new ArrayList<>();
        aTrier.add(5);
        aTrier.add(3);
        aTrier.add(2);
        aTrier.add(1);
        aTrier.add(4);
        triee = TriListe.triCroissant(aTrier);
        assertThat(triee.get(0)).isEqualTo(1);
        assertThat(triee.get(1)).isEqualTo(2);
        assertThat(triee.get(2)).isEqualTo(3);
        assertThat(triee.get(3)).isEqualTo(4);
        assertThat(triee.get(4)).isEqualTo(5);

    }




}
