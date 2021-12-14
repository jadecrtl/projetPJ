package principal;

import java.util.Arrays;

import enums.Couleur;
import utils.Dialogue;
import utils.TerminalCouleur;

public class Catane {
    
    public static void main(String[] args) {
        TerminalCouleur terminal = new TerminalCouleur();
        Dialogue dialogue = new Dialogue();
        terminal.println(Couleur.VERT.getCrayon(), "*******************");
        terminal.println(Couleur.VERT.getCrayon(), "*****Bonjour voici Catane!*****");
        terminal.println(Couleur.VERT.getCrayon(), "*******************");
        int nbJoueurs = dialogue.demandeIntPrecis(Couleur.VERT.getCrayon(), "Combien de joueurs pour la partie ? ", Arrays.asList(3,4));


    }
}
