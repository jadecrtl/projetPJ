package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Production;
import enums.TypeJoueur;
import enums.Couleur;

public class Joueur02ActionUTest {

    @Test
    public void verifieQueJoueurPeutAcheterUneRoute1() {
        Joueur j1 = new Joueur("j1", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j1.ajouterRessources(1, Production.BOIS);
        j1.ajouterRessources(2, Production.ARGILE);
        assertThat(j1.peutAcheterRoute()).isTrue();
        j1.enleverRessources(1, Production.BOIS);
        j1.enleverRessources(1, Production.ARGILE);
        assertThat(j1.peutAcheterRoute()).isFalse();
    }

    @Test
    public void verifieQueJoueurPeutAcheterUneRoute2() {
        Joueur j1 = new Joueur("j1", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j1.ajouterRessources(5, Production.BOIS);
        j1.ajouterRessources(4, Production.ARGILE);
        assertThat(j1.peutAcheterRoute()).isTrue();
        j1.enleverRessources(10, Production.BOIS);
        j1.enleverRessources(4, Production.ARGILE);
        assertThat(j1.getInventaireBois()).isEqualTo(0);
        assertThat(j1.getInventaireArgile()).isEqualTo(0);
    }

    @Test
    public void verifieQueJoueurPeutAcheterUneColonie1() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(1, Production.BOIS);
        j2.ajouterRessources(1, Production.ARGILE);
        j2.ajouterRessources(1, Production.BLE);
        j2.ajouterRessources(1, Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isTrue();
        j2.enleverRessources(1, Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isFalse();
    }

    @Test
    public void verifieQueJoueurPeutAcheterUneColonie2() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(1, Production.ARGILE);
        j2.ajouterRessources(1, Production.BLE);
        j2.ajouterRessources(1, Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isFalse();
        j2.ajouterRessources(1, Production.BOIS);
        assertThat(j2.peutAcheterColonie()).isTrue();
        j2.enleverRessources(1, Production.LAINE);
        assertThat(j2.peutAcheterColonie()).isFalse();
    }

    @Test
    public void verifieQueJoueurPeutAcheterUneVille1() {
        Joueur j3 = new Joueur("j3", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j3.ajouterRessources(1, Production.MINERAI);
        j3.ajouterRessources(2, Production.BLE);
        assertThat(j3.peutAcheterVille()).isFalse();
        j3.ajouterRessources(2, Production.MINERAI);
        assertThat(j3.peutAcheterVille()).isTrue();
        j3.enleverRessources(2, Production.BLE);
        assertThat(j3.peutAcheterVille()).isFalse();
        assertThat(j3.getInventaireBle()).isEqualTo(0);
    }

    @Test
    public void verifieQueJoueurPeutAcheterUneCarteDeDeveloppement() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(2, Production.BLE);
        j2.ajouterRessources(1, Production.LAINE);
        assertThat(j2.peutAcheterCarteChevalier()).isFalse();
        j2.ajouterRessources(1, Production.MINERAI);
        assertThat(j2.peutAcheterCarteChevalier()).isTrue();
    }

    @Test
    public void verifieQueJoueurPeutFaireDuCommerceSansPort() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(2, Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isFalse();
        j2.ajouterRessources(2, Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isTrue();
        j2.enleverRessources(3, Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isFalse();
        j2.enleverRessources(3, Production.BLE);
        assertThat(j2.peutCommerceSansPort()).isFalse();
    }

    @Test
    public void verifieQueJoueurPeutFaireDuCommerceAvecPort() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(1, Production.BLE);
        assertThat(j2.peutCommerceAvecPort()).isFalse();
        j2.ajouterRessources(2, Production.BLE);
        assertThat(j2.peutCommerceAvecPort()).isTrue();
        j2.enleverRessources(3, Production.BLE);
        assertThat(j2.peutCommerceAvecPort()).isFalse();
        j2.enleverRessources(3, Production.BLE);
        assertThat(j2.peutCommerceAvecPort()).isFalse();
    }

    @Test
    public void verifieQueJoueurPeutFaireDuCommerceAvecPortSpecialise1() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(1, Production.BLE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.BLE)).isFalse();
        j2.ajouterRessources(1, Production.BLE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.BLE)).isTrue();
        j2.enleverRessources(2, Production.BLE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.BLE)).isFalse();
        j2.enleverRessources(2, Production.BLE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.BLE)).isFalse();
    }

    @Test
    public void verifieQueJoueurPeutFaireDuCommerceAvecPortSpecialise2() {
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.ROUGE);
        j2.ajouterRessources(1, Production.ARGILE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.ARGILE)).isFalse();
        j2.ajouterRessources(1, Production.ARGILE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.ARGILE)).isTrue();
        assertThat(j2.peutCommerceAvecPortSpe(Production.BLE)).isFalse();
        j2.enleverRessources(2, Production.ARGILE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.ARGILE)).isFalse();
        j2.enleverRessources(2, Production.ARGILE);
        assertThat(j2.peutCommerceAvecPortSpe(Production.ARGILE)).isFalse();
    }



    
}
