package gui.views;
import javax.swing.JFrame;

import gui.controllers.AireDeJeuController;
import principal.AireDeJeu;

public class BoardView extends JFrame{
    private final String boardName = "Catan Board";
    private final int height;
    private final int width;

    public BoardView(int height, int width, AireDeJeu aireDeJeu) {

        // JFrame config
        this.height = height;
        this.width = width;
        setTitle(this.boardName);
        setSize(this.width, this.height);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set JPanels
        AireDeJeuView aireDeJeuView = new AireDeJeuView(aireDeJeu);
        AireDeJeuController aireDeJeuController = new AireDeJeuController();

        // Set JPanels Dependecies
        // aireDeJeuView.setModel(aireDeJeu);
        aireDeJeuView.setControleur(aireDeJeuController);
        

        // Add content to view
        add(aireDeJeuView);
    }
}
