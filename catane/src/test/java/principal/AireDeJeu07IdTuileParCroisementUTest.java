package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AireDeJeu07IdTuileParCroisementUTest {
    @Test
    public void rechercheIdTuileParListeCroisement() {
        AireDeJeu aire = new AireDeJeu(5, 3, OptionalLong.of(123));
        aire.traceAireDeJeu();
        //scenario ordonne qui marche pour la tuile 1
        List<Integer> croisementsVoisins1 = new ArrayList<>();
        croisementsVoisins1.add(1);
        croisementsVoisins1.add(2);
        croisementsVoisins1.add(7);
        croisementsVoisins1.add(8);
        assertThat(aire.getTuiles().get(aire.getIdTuileParCroisementVoisins(croisementsVoisins1)).getIdTuile()).isEqualTo(1);
        
        //scenario desordonne qui marche pour la tuile 1
        List<Integer> croisementsVoisins2 = new ArrayList<>();
        croisementsVoisins2.add(7);
        croisementsVoisins2.add(1);
        croisementsVoisins2.add(2);
        croisementsVoisins2.add(8);
        assertThat(aire.getTuiles().get(aire.getIdTuileParCroisementVoisins(croisementsVoisins2)).getIdTuile()).isEqualTo(1);

        //scenario ordonne qui marche pas
        List<Integer> croisementsVoisins3 = new ArrayList<>();
        croisementsVoisins3.add(1);
        croisementsVoisins3.add(3);
        croisementsVoisins3.add(7);
        croisementsVoisins3.add(8);
        assertThat(aire.getIdTuileParCroisementVoisins(croisementsVoisins3)).isNull();
    
        //scenario ordonne qui marche pour la tuile 0
        List<Integer> croisementsVoisins4 = new ArrayList<>();
        croisementsVoisins4.add(0);
        croisementsVoisins4.add(1);
        croisementsVoisins4.add(6);
        croisementsVoisins4.add(7);
        assertThat(aire.getTuiles().get(aire.getIdTuileParCroisementVoisins(croisementsVoisins4)).getIdTuile()).isEqualTo(0);

        //scenario ordonne qui marche pour la tuile 15
        List<Integer> croisementsVoisins5 = new ArrayList<>();
        croisementsVoisins5.add(16);
        croisementsVoisins5.add(17);
        croisementsVoisins5.add(22);
        croisementsVoisins5.add(23);
        assertThat(aire.getTuiles().get(aire.getIdTuileParCroisementVoisins(croisementsVoisins5)).getIdTuile()).isEqualTo(14);

        //scenario desordonne qui marche pour la tuile 0
        List<Integer> croisementsVoisins6 = new ArrayList<>();
        croisementsVoisins6.add(6);
        croisementsVoisins6.add(1);
        croisementsVoisins6.add(7);
        croisementsVoisins6.add(0);
        assertThat(aire.getTuiles().get(aire.getIdTuileParCroisementVoisins(croisementsVoisins6)).getIdTuile()).isEqualTo(0);
    
        //scenario desordonne qui marche pour la tuile 15
        List<Integer> croisementsVoisins7 = new ArrayList<>();
        croisementsVoisins7.add(22);
        croisementsVoisins7.add(17);
        croisementsVoisins7.add(23);
        croisementsVoisins7.add(16);
        assertThat(aire.getTuiles().get(aire.getIdTuileParCroisementVoisins(croisementsVoisins7)).getIdTuile()).isEqualTo(14);
    }
    
}
