package gui.views;

import javax.swing.JFrame;
import principal.AireDeJeu;

/* 
Board view.
*/

public class BoardView extends JFrame{
    private AireDeJeuView aireDeJeuView;

    public BoardView() {
        super("Board");

        AireDeJeu aireDeJeu = new AireDeJeu(5, 5);
        AireDeJeuView aireDeJeuView = new AireDeJeuView(aireDeJeu);

        this.setAireDeJeuView(aireDeJeuView);

        add(aireDeJeuView);
        setSize(500, 500);
        setResizable(true);
        setVisible(true);
    }

    public AireDeJeuView getAireDeJeuView() {
        return aireDeJeuView;
    }

    public void setAireDeJeuView(AireDeJeuView aireDeJeuView) {
        this.aireDeJeuView = aireDeJeuView;
    }

}
