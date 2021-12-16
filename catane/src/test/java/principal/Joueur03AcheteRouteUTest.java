package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;

public class Joueur03AcheteRouteUTest {
    
    @Test
    public void acheterRouteHorizontale() {
        AireDeJeu aire = new AireDeJeu(5, 3, null);
        Joueur j1 = new Joueur("j1", 21, TypeJoueur.HUMAIN, Couleur.BLEU);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r1 = new Route(0, 1);
        assertThat(aire.getProprietaireRoute(r1)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r1)).isTrue();
        assertThat(aire.getProprietaireRoute(r1)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r2 = new Route(7, 8);
        assertThat(aire.getProprietaireRoute(r2)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r2)).isTrue();
        assertThat(aire.getProprietaireRoute(r2)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r3 = new Route(15, 16);
        assertThat(aire.getProprietaireRoute(r3)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r3)).isTrue();
        assertThat(aire.getProprietaireRoute(r3)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r4 = new Route(22, 23);
        assertThat(aire.getProprietaireRoute(r4)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r4)).isTrue();
        assertThat(aire.getProprietaireRoute(r4)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        aire.traceAireDeJeu();
    }

    @Test
    public void acheterRouteVerticale() {
        AireDeJeu aire = new AireDeJeu(5, 3, null);
        Joueur j1 = new Joueur("j1", 21, TypeJoueur.HUMAIN, Couleur.BLEU);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r1 = new Route(0, 6);
        assertThat(aire.getProprietaireRoute(r1)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r1)).isTrue();
        assertThat(aire.getProprietaireRoute(r1)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r2 = new Route(7, 13);
        assertThat(aire.getProprietaireRoute(r2)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r2)).isTrue();
        assertThat(aire.getProprietaireRoute(r2)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r3 = new Route(10, 16);
        assertThat(aire.getProprietaireRoute(r3)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r3)).isTrue();
        assertThat(aire.getProprietaireRoute(r3)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(1, Production.ARGILE);
        Route r4 = new Route(17, 23);
        assertThat(aire.getProprietaireRoute(r4)).isEqualTo(null);        
        assertThat(j1.acheteRoute(aire, r4)).isTrue();
        assertThat(aire.getProprietaireRoute(r4)).isEqualTo(j1);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);

        aire.traceAireDeJeu();
    }


}
