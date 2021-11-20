package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import enums.Production;

public class Joueur02ActionUTest {

    @Test
    public void route1Joueur() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j1.ajouterRessources(1, enums.Production.BOIS);
        j1.ajouterRessources(2, enums.Production.ARGILE);
        assertThat(j1.peutAcheterRoute()).isTrue();
        j1.enleverRessources(1, enums.Production.BOIS);
        j1.enleverRessources(1, enums.Production.ARGILE);
        assertThat(j1.peutAcheterRoute()).isFalse();
    }

    @Test
    public void route2Joueur() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j1.ajouterRessources(5, enums.Production.BOIS);
        j1.ajouterRessources(4, enums.Production.ARGILE);
        assertThat(j1.peutAcheterRoute()).isTrue();
        j1.enleverRessources(10, enums.Production.BOIS);
        j1.enleverRessources(4, enums.Production.ARGILE);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
    }

/*
    @Test
    public void 
        j2.setInventaireBois(1);
        j2.setInventaireArgile(1);
        j2.setInventaireBle(1);
        j2.setInventaireLaine(1);
        j2.setInventaireMinerai(1);
        assertThat(j1.isAcheterRoute()).isTrue;
        assertThat(j1.isAcheterColonie()).isTrue;
        assertThat(j2.isCommerceSansPort()).isFalse;


    }


*/





    
}
