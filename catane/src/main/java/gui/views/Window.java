package gui.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.controllers.AireDeJeuController;
import principal.AireDeJeu;

public class Window extends JFrame{
    static final String TITLE = "Palette";
    static final int WIDTH = 1100;
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
        AireDeJeu aireDeJeuModel = new AireDeJeu(5, 5);
        // Views
        BoardView boardView = new BoardView();
        AireDeJeuView aireDeJeuView = new AireDeJeuView();
        // Controllers
        AireDeJeuController aireDeJeuController = new AireDeJeuController();
        // Setters
        aireDeJeuView.setModel(aireDeJeuModel);
        aireDeJeuView.setControleur(aireDeJeuController);

        aireDeJeuController.setModel(aireDeJeuModel);
        aireDeJeuController.setView(aireDeJeuView);

        // Add content to inside Panels
        boardView.add(aireDeJeuView, BorderLayout.CENTER);

        int padding = 35;
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(padding, padding, padding, padding));
        this.getContentPane().setBackground(new Color(39, 125, 161)); 

		this.getContentPane().removeAll();
		this.getContentPane().add(boardView, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
