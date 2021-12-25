package principal;

import org.junit.jupiter.api.Test;

import enums.Production;
//import utils.De6Faces;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
//import java.util.OptionalLong;

public class Joueur06AcheterCarteChevalierUTest {

    @Test
    public void acheteCarteChevalier() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        //De6Faces de1 = new De6Faces();
        //De6Faces de2 = new De6Faces();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        //Jeu jeu = new Jeu(joueurs, 5, 3, de1, de2, OptionalLong.of(123));    
        assertThat(j1.getInventaireChevalier()).isEqualTo(0);
        j1.ajouterRessources(1, Production.MINERAI);
        j1.ajouterRessources(1, Production.BLE);
        assertThat(j1.peutAcheterCarteChevalier()).isFalse();
        j1.ajouterRessources(1, Production.LAINE);
        assertThat(j1.peutAcheterCarteChevalier()).isTrue();
        j1.acheteCarteChevalier();
        assertThat(j1.getInventaireChevalier()).isEqualTo(1);
        assertThat(j1.getInventaireBle()).isEqualTo(0);
        assertThat(j1.getInventaireLaine()).isEqualTo(0);
        assertThat(j1.getInventaireMinerai()).isEqualTo(0);

    }

    
}
