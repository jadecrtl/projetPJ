package gui.views;

import javax.swing.JFrame;

import gui.models.*;
import gui.controllers.*;

/* 
Board view.
It's currently empty. It will have the AireDeJeu, Tuiles and Croisement.
*/

public class BoardView extends JFrame{

    public BoardView() {
        super("Board");
        // Testing only
        int x = 5; 
        int y = 5;
        AireDeJeuModel aireDeJeu = new AireDeJeuModel(x, y);
        AireDeJeuController.fillAireDeJeu(aireDeJeu);
        add(aireDeJeu);
        setSize(500, 500);
        setResizable(true);
        setVisible(true);
    }

}
