package gui.views;

import javax.swing.JFrame;
import principal.AireDeJeu;

/* 
Board view for testing. (Temporary)
*/

public class BoardView extends JFrame{
    private final String boardName;
    private final int height;
    private final int width;

    public BoardView(int height, int width) {
        this.boardName = "Board";
        this.height = height;
        this.width = width;

        AireDeJeu aireDeJeu = new AireDeJeu(5, 5);
        AireDeJeuView aireDeJeuView = new AireDeJeuView(aireDeJeu);

        setBoardView(aireDeJeuView);
    }

    private void setBoardView(AireDeJeuView aireDeJeuView) {
        setTitle(this.boardName);
        add(aireDeJeuView);
        setSize(this.width, this.height);

        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
