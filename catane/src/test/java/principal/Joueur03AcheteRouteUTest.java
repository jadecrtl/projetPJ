package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;

public class Joueur03AcheteRouteUTest {
    
    @Test
    public void acheterRoute() {
        AireDeJeu aire = new AireDeJeu(5, 3);
        Joueur j1 = new Joueur("j1", 21, TypeJoueur.HUMAIN, Couleur.BLANC);
        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r1 = new Route(7, 8, j1);
        assertThat(aire.getProprietaireRoute(r1)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r1)).isTrue();
        assertThat(aire.getProprietaireRoute(r1)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
        aire.traceAireDeJeu();
    }



}
