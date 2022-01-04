package gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import enums.Couleur;
import enums.TypeJoueur;
import gui.views.StartGameFormView;
import gui.views.Window;
import principal.Jeu;
import principal.Joueur;
import utils.De6Faces;

import java.awt.EventQueue;


public class CataneGui {
    Jeu jeuCataneGui;
    List<Joueur> joueurs = new LinkedList<>();

    public Jeu initializeJeu(StartGameFormView form) {
        setPlayers(form);
        int h = getSize(form)[0];
        int v = getSize(form)[1];

        De6Faces de1 = new De6Faces();
        De6Faces de2 = new De6Faces();
        this.jeuCataneGui = new Jeu(joueurs, h, v, de1, de2, null);
        return this.jeuCataneGui;
    }

    private int[] getSize(StartGameFormView form) {
        int[] size = new int[2];
        if(form.sizeOptionOne.isSelected()){
            size[0] = 5;
            size[1] = 3;
        }else {
            size[0] = 5;
            size[1] = 5;
        }
        return size;
    }

    private void setPlayers(StartGameFormView form) {

        joueurs.add(createJoueur(form.playerOneName, form.playerOneAge, form.typeChoiceOneAi, form.typeChoiceOneBlue, form.typeChoiceOneBlanc, form.typeChoiceOneRouge, form.typeChoiceOneJaune)); //Player One
        joueurs.add(createJoueur(form.playerTwoName, form.playerTwoAge, form.typeChoiceTwoAi, form.typeChoiceTwoBlue, form.typeChoiceTwoBlanc, form.typeChoiceTwoRouge, form.typeChoiceTwoJaune)); //Player One
        joueurs.add(createJoueur(form.playerThreeName, form.playerThreeAge, form.typeChoiceThreeAi, form.typeChoiceThreeBlue, form.typeChoiceThreeBlanc, form.typeChoiceThreeRouge, form.typeChoiceThreeJaune)); //Player One
        if(form.fourPlayers.isSelected()) {
            joueurs.add(createJoueur(form.playerFourName, form.playerFourAge, form.typeChoiceFourAi, form.typeChoiceFourBlue, form.typeChoiceFourBlanc, form.typeChoiceFourRouge, form.typeChoiceFourJaune)); //Player One
        }
    }

    private Joueur createJoueur(JTextField playerName, JTextField playerAge, JRadioButton typeChoiceAi,
            JRadioButton typeChoiceBlue, JRadioButton typeChoiceBlanc, JRadioButton typeChoiceRouge,
            JRadioButton typeChoiceFourJaune) {

            TypeJoueur type;
            Couleur couleur;

            if(typeChoiceAi.isSelected()) {
                type = TypeJoueur.IA; 
            }else {
                type = TypeJoueur.HUMAIN;
            }

            if(typeChoiceBlue.isSelected()) {
                couleur = Couleur.BLEU;
            } else if (typeChoiceBlanc.isSelected()) {
                couleur = Couleur.BLANC;
            } else if (typeChoiceRouge.isSelected()) {
                couleur = Couleur.ROUGE;
            } else {
                couleur = Couleur.JAUNE;
            }

            Joueur j = new Joueur(playerName.getText(), type, couleur);
            return j;
    }

    public static void main(String[] args) {

        /*
        1. Open home page
        2. User clicks on begin
        3. User fill the form and click on start game
        4. That click initialize a game class
        5. It redirects to a boardview with the game class inside it.
        6. The user see the board with all the players in the header, submenu is connected to a specific first player
        
        7. For the first and second round do a routine where it forces the player to do some stuf (preparePartie)
        8. Let the game run in a loop until there is a winner, once there is a winner, pop a message and redirect to homepage.(LancePartie)
    */
        EventQueue.invokeLater(()-> {
            new Window();
        });
        
    }

}
