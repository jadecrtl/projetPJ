package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

import enums.Action;
import enums.Production;
import utils.De6Faces;


public class Joueur04AcheterColonieUTest {
    
    @Test
    public void acheterColonie() {
    
        Joueur j1 = new Joueur("j1", enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        De6Faces de1 = new De6Faces();
        De6Faces de2 = new De6Faces();
        Jeu jeu;
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        jeu = new Jeu(joueurs, 5, 3, de1, de2, OptionalLong.of(123)); 
        assertThat(j1.getListIdActions()).containsOnly(Action.PASSE.getIdAction());   
        j1.ajouterRessources(2, Production.ARGILE);
        j1.ajouterRessources(1, Production.LAINE);
        j1.ajouterRessources(2, Production.BOIS);
        j1.ajouterRessources(1, Production.BLE);
        assertThat(j1.getListIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.ROUTE.getIdAction(), Action.COLONIE.getIdAction());           

        assertThat(jeu.getAire().getCroisements().get(2).getProprietaire()).isEqualTo(null);        
        assertThat(j1.getPointVictoire()).isEqualTo(0);
        assertThat(j1.acheteColonie(jeu.getAire(), jeu.getAire().getCroisements().get(2).getIdCroisement())).isFalse();
        assertThat(j1.acheteRoute(jeu.getAire(), new Route(2, 3))).isTrue();
        assertThat(j1.acheteColonie(jeu.getAire(), jeu.getAire().getCroisements().get(2).getIdCroisement())).isTrue();
        assertThat(jeu.getAire().getCroisements().get(2).getProprietaire()).isEqualTo(j1);        
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
        assertThat(j1.getInventaireLaine()).isEqualTo(0);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireBle()).isEqualTo(0);
        assertThat(j1.getPointVictoire()).isEqualTo(1);
    
    }


}
