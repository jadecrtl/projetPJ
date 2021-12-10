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
        this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
        
        openBoard();
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void openBoard() {
        // Models
        AireDeJeu aireDeJeu = new AireDeJeu(7, 7);
        // Views
        BoardView boardView = new BoardView();
        AireDeJeuView aireDeJeuView = new AireDeJeuView(aireDeJeu);
        // Controllers
        AireDeJeuController aireDeJeuController = new AireDeJeuController();
        // Setters
        aireDeJeuView.setControleur(aireDeJeuController);
        // Add content to inside Panels
        boardView.add(aireDeJeuView, BorderLayout.CENTER);
		this.getContentPane().removeAll();
		this.getContentPane().add(boardView, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
