package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;


public class Joueur04AcheterColonieUTest {
    
    @Test
    public void acheterColonie() {
        AireDeJeu aire = new AireDeJeu(5, 3, null);
        Joueur j1 = new Joueur("j1", 21, TypeJoueur.HUMAIN, Couleur.BLEU);
        
        j1.ajouterRessources(1, Production.ARGILE);
        j1.ajouterRessources(1, Production.LAINE);
        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.BLE);
        Croisement c = new Croisement(2);
        assertThat(aire.getCroisements().get(c.getIdCroisement()).getProprietaire()).isEqualTo(null);        
        assertThat(j1.getPointVictoire()).isEqualTo(0);
        assertThat(j1.acheteColonie(aire, c)).isTrue();
        assertThat(aire.getCroisements().get(c.getIdCroisement()).getProprietaire()).isEqualTo(j1);        
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
        assertThat(j1.getInventaireLaine()).isEqualTo(0);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireBle()).isEqualTo(0);
        assertThat(j1.getPointVictoire()).isEqualTo(1);
    
    }


}
