package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void colonie1Joueur() {
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j2.ajouterRessources(5, enums.Production.BOIS);
        j2.ajouterRessources(3, enums.Production.ARGILE);
        j2.ajouterRessources(2, enums.Production.BLE);
        j2.ajouterRessources(1, enums.Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isTrue();
        j2.enleverRessources(1, enums.Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isFalse();
    }

    @Test
    public void colonie2Joueur() {
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j2.ajouterRessources(3, enums.Production.ARGILE);
        j2.ajouterRessources(2, enums.Production.BLE);
        j2.ajouterRessources(1, enums.Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isFalse();
        j2.ajouterRessources(1, enums.Production.BOIS);
        assertThat(j2.peutAcheterColonie()).isTrue();
        j2.enleverRessources(1, enums.Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isFalse();
    }

    @Test
    public void villeJoueur() {
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j3.ajouterRessources(1, enums.Production.MINERAI);
        j3.ajouterRessources(2, enums.Production.BLE);
        assertThat(j3.peutAcheterVille()).isFalse();
        j3.ajouterRessources(2, enums.Production.MINERAI);
        assertThat(j3.peutAcheterVille()).isTrue();
        j3.enleverRessources(2, enums.Production.BLE);
        assertThat(j3.peutAcheterVille()).isFalse();
        assertThat(j3.getInventaireBle()).isEqualTo(0);
    }

    @Test
    public void carteDevJoueur() {
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j2.ajouterRessources(2, enums.Production.BLE);
        j2.ajouterRessources(1, enums.Production.LAINE);
        assertThat(j2.peutAcheterCarteDev()).isFalse();
        j2.ajouterRessources(1, enums.Production.MINERAI);
        assertThat(j2.peutAcheterCarteDev()).isTrue();
    }

    @Test
    public void commerceSansPort() {
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        j2.ajouterRessources(2, enums.Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isFalse();
        j2.ajouterRessources(2, enums.Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isTrue();
        j2.enleverRessources(2, enums.Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isFalse();
    }






    
}
