package principal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import enums.Couleur;
import enums.TypeJoueur;
import utils.De6Faces;
import utils.Dialogue;
import utils.TerminalCouleur;

public class Catane {
    
    public static void main(String[] args) {
        TerminalCouleur terminal = new TerminalCouleur();
        Dialogue dialogue = new Dialogue();
        List<Joueur> joueurs = new LinkedList<>();
        Jeu jeu;

        terminal.println(Couleur.MAUVE.getCrayon(), "*******************");
        terminal.println(Couleur.MAUVE.getCrayon(), "*****Bonjour voici Catane!*****");
        terminal.println(Couleur.MAUVE.getCrayon(), "*******************");

        int tailleHorizontale = dialogue.demandeInt(Couleur.MAUVE.getCrayon(), "Donner la taille horizontale du plateau ");
        int tailleVerticale = dialogue.demandeInt(Couleur.MAUVE.getCrayon(), "Donner la taille verticale du plateau ");

        De6Faces de1 = new De6Faces();
        De6Faces de2 = new De6Faces();
        
        int nbJoueurs = dialogue.demandeIntPrecis(Couleur.MAUVE.getCrayon(), "Combien de joueurs pour la partie ? ", Arrays.asList(3,4));
        
        for (int i = 1; i <= nbJoueurs; i++) {
            String nom = dialogue.demandeString(Couleur.MAUVE.getCrayon(), "Joueur "+ i +" quel est votre prenom? ");
            int age = dialogue.demandeInt(Couleur.MAUVE.getCrayon(), "Quel est votre age? ");
            TypeJoueur typeJoueur = TypeJoueur.valueOf(dialogue.demandeStringPrecis(Couleur.MAUVE.getCrayon(), "Quel type de joueur etes-vous ? ", Arrays.asList("HUMAIN", "IA")));
            Couleur couleur = Couleur.valueOf(dialogue.demandeStringPrecis(Couleur.MAUVE.getCrayon(), "De quelle couleur etes-vous ? ", Arrays.asList("BLEU", "BLANC", "ROUGE", "JAUNE")));
            joueurs.add(new Joueur(nom, age, typeJoueur, couleur));
            terminal.nouvelleLigne();
        }
        jeu = new Jeu(joueurs, tailleHorizontale, tailleVerticale, de1, de2);
        
    }

}
