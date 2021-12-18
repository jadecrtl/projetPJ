package gui.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import enums.Couleur;
import enums.TypeJoueur;
import gui.controllers.AireDeJeuController;
import gui.controllers.SubMenuController;
import principal.AireDeJeu;
import principal.Joueur;
import utils.De6Faces;

public class Window extends JFrame{
    static final String TITLE = "Palette";
    static final int WIDTH = 1100;
    static final int HEIGHT = 800;

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
        AireDeJeu aireDeJeuModel = new AireDeJeu(5, 5, null);
        Joueur joueur = new Joueur("Paris", 22, TypeJoueur.HUMAIN, Couleur.VERT);
        De6Faces de = new De6Faces();

        // Views
        BoardView boardView = new BoardView();
        AireDeJeuView aireDeJeuView = new AireDeJeuView();
        SubMenuView subMenuView = new SubMenuView();
        PlayerHeaderView playerHeaderView = new PlayerHeaderView();

        // Controllers
        AireDeJeuController aireDeJeuController = new AireDeJeuController();
        SubMenuController subMenuController = new SubMenuController();

        // Setters
        boardView.setBackground(new Color(39, 125, 161));
        
        subMenuView.setController(subMenuController);
        subMenuView.setJoueurModel(joueur);
        subMenuView.setDeModel(de);
        subMenuView.setAireDeJeuView(aireDeJeuView);

        aireDeJeuView.setModel(aireDeJeuModel);
        aireDeJeuView.setControleur(aireDeJeuController);

        aireDeJeuView.setSubMenu(subMenuView);

        aireDeJeuController.setModel(aireDeJeuModel);
        aireDeJeuController.setView(aireDeJeuView);

        subMenuController.setView(subMenuView);

        // Add content to inside Panels
        JPanel testPanel = new JPanel();
        testPanel.setLayout(new BorderLayout());
        testPanel.add(aireDeJeuView, BorderLayout.CENTER);
        testPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
        testPanel.setOpaque(false);

        boardView.add(testPanel, BorderLayout.CENTER);
        boardView.add(playerHeaderView, BorderLayout.NORTH);

        JPanel menuHolderView = new JPanel();// FIXME
        menuHolderView.setLayout(new BorderLayout());
        menuHolderView.add(subMenuView, BorderLayout.CENTER);
        boardView.add(menuHolderView, BorderLayout.SOUTH);

        int padding = 15;
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(padding, padding, padding, padding));
        this.getContentPane().setBackground(new Color(39, 125, 161)); // FIXME

		this.getContentPane().removeAll();
		this.getContentPane().add(boardView, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
