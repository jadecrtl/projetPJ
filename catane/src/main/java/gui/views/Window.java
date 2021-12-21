package gui.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import enums.Couleur;
import enums.TypeJoueur;
import gui.controllers.AireDeJeuController;
import gui.controllers.HomeController;
import gui.controllers.SubMenuController;
import principal.AireDeJeu;
import principal.Joueur;
import utils.De6Faces;

public class Window extends JFrame{
    static final String TITLE = "Catane";
    static final int WIDTH = 1100;
    static final int HEIGHT = 700;

    public Window() {

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(true);
		this.setLocationRelativeTo(null);
        // Initialiaze GUI  
        // openBoard();
        openGameForm();
        Image icon = Toolkit.getDefaultToolkit().getImage("catane/src/static/colline.png");    
        this.setIconImage(icon);
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void openHomePage() {
        // This will quick start as the landing page 
        // User clicks either play or quit
        // If play, this method calls openGameForm
        HomeView homeView = new HomeView(this);
        HomeController controller = new HomeController();
        homeView.setController(controller);

        this.getContentPane().removeAll();

		this.getContentPane().add(homeView);
		
        this.revalidate();
		this.repaint();
    }

    public void openGameForm() {
        // This method renders the form and get all the data from from and intialize the game
        // Send all data inside a class like Game to OpenBoard 
        // e.g. Game game = new Game(form.data);
        // e.g.  openBoard(game)

        StartGameFormView form = new StartGameFormView();
        this.getContentPane().removeAll();
		this.getContentPane().add(form);
        this.revalidate();
		this.repaint();
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
        JPanel widerPanel = new JPanel();
        JPanel menuHolderView = new JPanel();


        // Controllers
        AireDeJeuController aireDeJeuController = new AireDeJeuController();
        SubMenuController subMenuController = new SubMenuController();

        // BoardView Setters
        boardView.setBackground(new Color(39, 125, 161));

        // SubMenuView Setters
        subMenuView.setController(subMenuController);
        subMenuView.setJoueurModel(joueur);
        subMenuView.setDeModel(de);
        subMenuView.setAireDeJeuView(aireDeJeuView);

        // aireDeJeuView Setters
        aireDeJeuView.setModel(aireDeJeuModel);
        aireDeJeuView.setControleur(aireDeJeuController);
        aireDeJeuView.setSubMenu(subMenuView);

        // aireDeJeuController Setters
        aireDeJeuController.setModel(aireDeJeuModel);
        aireDeJeuController.setView(aireDeJeuView);

        // subMenuController Setters
        subMenuController.setView(subMenuView);

        // Add content to widerPanel
        widerPanel.setLayout(new BorderLayout());
        widerPanel.add(aireDeJeuView, BorderLayout.CENTER);
        widerPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
        widerPanel.setOpaque(false);

      
        // Add content to menuHomderView
        menuHolderView.setLayout(new BorderLayout());
        menuHolderView.add(subMenuView, BorderLayout.CENTER);

        //  Add content to boardView
        boardView.add(widerPanel, BorderLayout.CENTER);
        boardView.add(playerHeaderView, BorderLayout.NORTH);
        boardView.add(menuHolderView, BorderLayout.SOUTH);

        // Set Frame (window) padding
        int padding = 15;
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(padding, padding, padding, padding));

        // 1. Set background -> 2. Clear Panels -> 3. Add BoardView -> 4. Revalidate and Repaint
        this.getContentPane().setBackground(new Color(39, 125, 161));
		this.getContentPane().removeAll();
		this.getContentPane().add(boardView, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
