package principal;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

import org.junit.jupiter.api.Test;

import utils.De6Faces;

public class Jeu03LancePartieUTest {
    
    @Test
    public void lancePartie3Joueurs() {
        Joueur j1 = new Joueur("j1", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.ROUGE);
        Joueur j2 = new Joueur("j2", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLANC);
        Joueur j3 = new Joueur("j3", 19, enums.TypeJoueur.HUMAIN, enums.Couleur.BLEU);
        List<Joueur> joueurs = new LinkedList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2); 
        joueurs.add(j3);
        De6Faces de1 = new De6Faces();
        De6Faces de2 = new De6Faces();
        Jeu jeu = new Jeu(joueurs, 5, 3, de1, de2, OptionalLong.of(123));
        
    }





}
