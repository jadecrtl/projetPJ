package gui.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

import gui.controllers.AireDeJeuController;
import gui.controllers.HomeController;
import gui.controllers.SubMenuController;
import principal.AireDeJeu;
import principal.Jeu;
import principal.Joueur;
import utils.De6Faces;

public class Window extends JFrame{
    static final String TITLE = "Catane";
    static final int WIDTH = 1100;
    static final int HEIGHT = 700;

    // Models
    Jeu currentJeu;
    AireDeJeu aireDeJeuModel;
    List<Joueur> joueurs;

    // Views
    BoardView boardView;
    AireDeJeuView aireDeJeuView;
    PlayerHeaderView playerHeaderView;
    SubMenuView subMenuView;

    // Controllers
    AireDeJeuController aireDeJeuController;
    SubMenuController subMenuController;


    public Window() {

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(true);
		this.setLocationRelativeTo(null);
        // Initialiaze GUI  
        // openBoard();
        openHomePage();
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

        StartGameFormView form = new StartGameFormView(this);
        this.getContentPane().removeAll();
		this.getContentPane().add(form);
        this.revalidate();
		this.repaint();
    }

    // public void openBoard(Jeu jeu) {

    //     // Models
    //     AireDeJeu aireDeJeuModel = jeu.getAire();    
    //     // Joueur joueur = new Joueur("Paris", 22, TypeJoueur.HUMAIN, Couleur.VERT);
    //     List<Joueur> joueurs = jeu.getJoueurs();
    //     De6Faces de = new De6Faces();

    //     // Views
    //     BoardView boardView = new BoardView();
    //     AireDeJeuView aireDeJeuView = new AireDeJeuView();
    //     SubMenuView subMenuView = new SubMenuView();
    //     PlayerHeaderView playerHeaderView = new PlayerHeaderView(joueurs);
    
    //     // Aux Panels
    //     JPanel widerPanel = new JPanel();
    //     JPanel menuHolderView = new JPanel();


    //     // Controllers
    //     AireDeJeuController aireDeJeuController = new AireDeJeuController();
    //     SubMenuController subMenuController = new SubMenuController();

    //     // SubMenuView Setters
    //     subMenuView.setController(subMenuController);
    //     subMenuView.setSubMenuViewClass(joueurs.get(0));
    //     subMenuView.updateActionsForPlayer(joueurs.get(0), false);
    //     subMenuView.setDeModel(de);
    //     subMenuView.setAireDeJeuView(aireDeJeuView);

    //     // aireDeJeuView Setters
    //     aireDeJeuView.setModel(aireDeJeuModel);
    //     aireDeJeuView.setControleur(aireDeJeuController);
    //     aireDeJeuView.setSubMenu(subMenuView);

    //     // aireDeJeuController Setters
    //     aireDeJeuController.setModel(aireDeJeuModel);
    //     aireDeJeuController.setView(aireDeJeuView);

    //     // subMenuController Setters
    //     subMenuController.setView(subMenuView);

    //     // Add content to widerPanel
    //     widerPanel.setLayout(new BorderLayout());
    //     widerPanel.add(aireDeJeuView, BorderLayout.CENTER);
    //     widerPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
    //     widerPanel.setOpaque(false);

      
    //     // Add content to menuHomderView
    //     menuHolderView.setLayout(new BorderLayout());
    //     menuHolderView.add(subMenuView, BorderLayout.CENTER);

    //     //  Add content to boardView
    //     boardView.add(widerPanel, BorderLayout.CENTER);
    //     boardView.add(playerHeaderView, BorderLayout.NORTH);
    //     boardView.add(menuHolderView, BorderLayout.SOUTH);

    //     // Set Frame (window) padding
    //     int padding = 15;
	// 	((JComponent) this.getContentPane()).setBorder(new EmptyBorder(padding, padding, padding, padding));

    //     // 1. Set background -> 2. Clear Panels -> 3. Add BoardView -> 4. Revalidate and Repaint
    //     this.getContentPane().setBackground(new Color(39, 125, 161));
	// 	this.getContentPane().removeAll();
	// 	this.getContentPane().add(boardView, BorderLayout.CENTER);
	// 	this.revalidate();
	// 	this.repaint();
	// }


    public void setGame(Jeu jeu) {
        /* 
            After Form receive Jeu Object -> Set basic visuals on the GameBoard
            1. Get all players information and add to headers.
            2. Set Board size and configuration.
            3. Pop Up a messsage indicating that the game will start.
        */

        // 1. Clear panel and prepare it for new content
        this.getContentPane().removeAll();
        this.getContentPane().setBackground(new Color(39, 125, 161));

        // 2. Contents
        this.currentJeu = jeu; // Main reference for everthing.

        // 3. Models
        this.aireDeJeuModel = jeu.getAire();    
        this.joueurs = jeu.getJoueurs();
        De6Faces de = new De6Faces(); // FIXME 

        // 4. Views
        this.boardView = new BoardView();
        this.aireDeJeuView = new AireDeJeuView();
        this.playerHeaderView = new PlayerHeaderView(joueurs);
        this.subMenuView = new SubMenuView();
    
        // Aux Panels
        JPanel widerPanel = new JPanel();
        JPanel menuHolderView = new JPanel();

        // Controllers
        this.aireDeJeuController = new AireDeJeuController();
        this.subMenuController = new SubMenuController();

        // SubMenuView setters
        updateSubMenuView(this.joueurs.get(0), de, false, false, false);
        // aireDeJeuView Setters
        updateAireDeJeuView();
        // aireDeJeuController Setters
        updateAireDeJeuController();
        // subMenuController Setters
        updateSubMenuController();

        // SetAuxPanels config
        setAuxPanels(widerPanel, menuHolderView);
        // UpdateBordView
        updateBoardView(widerPanel, menuHolderView);

        // Set Frame (window) padding
        int padding = 15;
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(padding, padding, padding, padding));

        this.getContentPane().add(boardView, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
    }

    public void preparePartie() {

    }

    public void lancePartie() {

    }

    private void updateBoardView(JPanel widerPanel, JPanel menuHolderView) {
        // Add Content to Board
        this.boardView.add(widerPanel, BorderLayout.CENTER);
        this.boardView.add(this.playerHeaderView, BorderLayout.NORTH);
        this.boardView.add(menuHolderView, BorderLayout.SOUTH);
    }

    private void updateSubMenuView(Joueur joueur, De6Faces de, boolean roober, boolean dice, boolean cancel) {

        this.subMenuView.setController(this.subMenuController);
        this.subMenuView.setSubMenuViewClass(joueur);
        this.subMenuView.updateActionsForPlayer(joueur, roober, dice, cancel);
        this.subMenuView.setDeModel(de);
        this.subMenuView.setAireDeJeuView(this.aireDeJeuView); 

    }

    private void updateAireDeJeuView() {
        this.aireDeJeuView.updateAireDeJeuView(this.aireDeJeuModel);
        this.aireDeJeuView.setControleur(this.aireDeJeuController);
        this.aireDeJeuView.setSubMenu(this.subMenuView);
    }

    private void updateAireDeJeuController() {
        this.aireDeJeuController.setModel(this.aireDeJeuModel);
        this.aireDeJeuController.setView(this.aireDeJeuView);
    }

    private void updateSubMenuController() {
        this.subMenuController.setView(this.subMenuView);
    }

    private void setAuxPanels(JPanel widerPanel, JPanel menuHolderView) {
        // Add content to widerPanel

        widerPanel.setLayout(new BorderLayout());
        widerPanel.add(this.aireDeJeuView, BorderLayout.CENTER);
        widerPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
        widerPanel.setOpaque(false);
      
        // Add content to menuHomderView
        menuHolderView.setLayout(new BorderLayout());
        menuHolderView.add(this.subMenuView, BorderLayout.CENTER);

    }
}
