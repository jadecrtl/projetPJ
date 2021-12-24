package principal;

import org.junit.jupiter.api.Test;

import enums.Production;
import enums.Action;
import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

public class Joueur07UtiliserCarteChevalierUTest {

    @Test
    public void utiliserUneCarteChevalier() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        De6Faces de1 = new De6Faces();
        De6Faces de2 = new De6Faces();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        Jeu jeu = new Jeu(joueurs, 5, 5, de1, de2, OptionalLong.of(123456));    

        assertThat(j1.getInventaireChevalier()).isEqualTo(0);
        j1.ajouterRessources(1, Production.MINERAI);
        j1.ajouterRessources(1, Production.BLE);
        assertThat(j1.peutAcheterCarteChevalier()).isFalse();
        j1.ajouterRessources(1, Production.LAINE);
        assertThat(j1.peutAcheterCarteChevalier()).isTrue();
        j1.acheteCarteChevalier();
        assertThat(j1.getInventaireChevalier()).isEqualTo(1);
        assertThat(j1.peutUtiliserCarteChevalier()).isTrue();
        assertThat(j1.getInventaireBle()).isEqualTo(0);
        assertThat(j1.getInventaireLaine()).isEqualTo(0);
        assertThat(j1.getInventaireMinerai()).isEqualTo(0);

        assertThat(j1.getListIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.UTILISERCARTECHEVALIER.getIdAction());        
        
        assertThat(jeu.getAire().getIdTuileVoleur()).isEqualTo(12);
        assertThat(jeu.getAire().getTuiles().get(12).isVoleurPresent()).isTrue();
        j1.faireCarteChevalier(jeu, 16);
        assertThat(jeu.getAire().getTuiles().get(12).isVoleurPresent()).isFalse();
        assertThat(jeu.getAire().getTuiles().get(16).isVoleurPresent()).isTrue();
        assertThat(j1.getInventaireChevalier()).isEqualTo(0);
        

    }
}
