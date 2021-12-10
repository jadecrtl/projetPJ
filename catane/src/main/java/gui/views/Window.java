package gui.views;

import java.awt.*;
import javax.swing.*;
import gui.controllers.AireDeJeuController;
import principal.AireDeJeu;

public class Window extends JFrame{
    static final String TITLE = "Palette";
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    public Window() {
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        openBoard();
		
		this.setVisible(true); // On affiche la fenetre.

    }

    public void openBoard() {
        // Models
        AireDeJeu aireDeJeu = new AireDeJeu(5, 5);
        // Views
        BoardView boardView = new BoardView();
        AireDeJeuView aireDeJeuView = new AireDeJeuView(aireDeJeu);
        // Controllers
        AireDeJeuController aireDeJeuController = new AireDeJeuController();

        // Setters
        aireDeJeuView.setControleur(aireDeJeuController);

        // Add content to inside Panels
        // boardView.setSize(width, height);
        boardView.add(aireDeJeuView);

		this.getContentPane().removeAll();
		this.getContentPane().add(boardView);
		this.revalidate();
		this.repaint();
	}
}
