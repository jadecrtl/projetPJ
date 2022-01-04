package gui.views;

import gui.controllers.SubMenuController;
import gui.controllers.SubMenuController.Selection;
// import gui.controllers.TuileController;
// import gui.controllers.SubMenuController.Selection;
import principal.Joueur;
import utils.De6Faces;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;


public class SubMenuView extends JPanel{

    public Joueur joueurModel;
    private De6Faces deModel;
    private AireDeJeuView aireDeJeuView;

    private SubMenuController controller;
    private Font customFont;

    private Color backGroundColor = new Color(39, 125, 161);
    private String CANCEL_ICON = "catane/src/static/next.png";
    private String DICE_ICON = "catane/src/static/dice.png";
    private String CHEVALIER_ICON = "catane/src/static/chevalier.png";
    private String COMMERCE_ICON = "catane/src/static/commerce.png";

    public JButton city;
    public JButton village;
    public JButton route;
    public JButton robber;

    public JButton b1; 
    public JButton b2; 
    public JButton chevalierButton;
    public JButton commerceSansPortButton;
    public static boolean sevenDice = false;
    
    List<Joueur> joueurs = new ArrayList<>();


    // TODO: extraire method pour tous classes
    public void setNewFont() {
        try {

            this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Medium.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (Exception e) {

            this.customFont = new Font(Font.SERIF, Font.PLAIN,  10);
        }
       
    }

    public AireDeJeuView getAireDeJeuView() {
        return aireDeJeuView;
    }

    public void setAireDeJeuView(AireDeJeuView aireDeJeuView) {
        this.aireDeJeuView = aireDeJeuView;
    }

    public JPanel createMenuPanel(Joueur joueur) {
        // TODO: Set Background
        // TODO: Set Font
        // TODO: Add padding
        // TODO: use model to get user name and other data...

        JPanel panel = new JPanel()
        {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(144, 190, 109));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            }
        };

        panel.setOpaque(false);
        Border blackline = BorderFactory.createLineBorder(Color.black, 2, true);
        panel.setBorder(blackline);
        
        JPanel secondPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(secondPanel, BoxLayout.Y_AXIS);
        
        secondPanel.setLayout(boxLayout);
        secondPanel.setOpaque(false);
        secondPanel.add(getJoueurNom());
        secondPanel.add(getActions(joueur));


        panel.add(secondPanel);
        return panel;
    }

    private JPanel getJoueurNom() {
        // TODO: use model to get user name and other data...

        JPanel pan = new JPanel();
        JLabel label = new JLabel();
        JLabel label_name = new JLabel();


        label.setText("Joueur:");
        label.setFont(this.customFont);
        label.setForeground(Color.BLACK);

        String playerName;
        if (this.joueurModel != null) {
            playerName = this.joueurModel.getNom();
        } else {
            playerName = "?";
        }

        label_name.setText(playerName);
        label_name.setFont(this.customFont);
        label_name.setForeground(Color.WHITE);

        pan.add(label);
        pan.add(label_name);
        pan.setOpaque(false);

        return pan;
    }

    private JPanel getActions(Joueur joueur) {
        // Jpanel with 3 buttons;
        // TODO: use model to get user name and other data...
        this.route = new JButton("Route");
        this.city = new JButton("Ville");
        this.village = new JButton("Colonie");
        this.robber = new JButton("Voleur");

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Ajouter:");

        label.setFont(this.customFont);
        label.setForeground(Color.BLACK);

        panel.add(label);


        this.city.setFont(this.customFont);
        this.village.setFont(this.customFont);
        this.route.setFont(this.customFont);
        this.robber.setFont(this.customFont);

        this.city.setFocusPainted(false);
        this.village.setFocusPainted(false);
        this.route.setFocusPainted(false);
        this.robber.setFocusPainted(false);

        this.city.addActionListener((event)-> {this.controller.addCityOrVillagePressed(aireDeJeuView, "CITY");});
        this.village.addActionListener((event)-> {this.controller.addCityOrVillagePressed(aireDeJeuView, "VILLAGE");});
        this.route.addActionListener((event)-> {this.controller.addRoutePressed(aireDeJeuView, "ROUTE");});
        this.robber.addActionListener((event)-> {this.controller.addRobberPressed(aireDeJeuView);});

        panel.add(city);
        panel.add(village);
        panel.add(this.route);
        panel.add(robber);

        panel.setOpaque(false);

        return panel;
    }

    public void createButton(String path) {
        this.b1 = new JButton(TuileView.createIcon(path, 40, 40));

        this.b1.setOpaque(false);
        this.b1.setContentAreaFilled(false);
        this.b1.setBorderPainted(false);

        this.b1.setPreferredSize(new Dimension(60, 60));
        this.b1.setFocusPainted(false);        
    }

    public void createChevalierButton(String path) {
        this.chevalierButton= new JButton(TuileView.createIcon(path, 40, 40));

        this.chevalierButton.setOpaque(false);
        this.chevalierButton.setContentAreaFilled(false);
        this.chevalierButton.setBorderPainted(false);

        this.chevalierButton.setPreferredSize(new Dimension(60, 60));
        this.chevalierButton.setFocusPainted(false);        
    }

    public void createCommerceSansPortButton(String path) {
        this.commerceSansPortButton= new JButton(TuileView.createIcon(path, 40, 40));

        this.commerceSansPortButton.setOpaque(false);
        this.commerceSansPortButton.setContentAreaFilled(false);
        this.commerceSansPortButton.setBorderPainted(false);

        this.commerceSansPortButton.setPreferredSize(new Dimension(60, 60));
        this.commerceSansPortButton.setFocusPainted(false);        
    }

    public void createCancelButton(String path) {
        this.b2 = new JButton(TuileView.createIcon(path, 40, 40));

        this.b2.setOpaque(false);
        this.b2.setContentAreaFilled(false);
        this.b2.setBorderPainted(false);

        this.b2.setPreferredSize(new Dimension(60, 60));
        this.b2.setFocusPainted(false);        
    }

    public void setSubMenuViewClass(Joueur joueur, Window window) {
        createCancelButton(CANCEL_ICON);
        createButton(DICE_ICON);
        createChevalierButton(CHEVALIER_ICON);
        createCommerceSansPortButton(COMMERCE_ICON);
        /**
         * 1. Criar butão - OK
         * 2. Adicionar MouseListener - Ok
         * 3. Adicionar ActionListener 
         * 4. Add ao panel principal - Ok
         * 5. Ativar apenas se poder comprar 
         */
        this.joueurModel = joueur;
        setNewFont();

        Selection sel4 =  this.controller.new Selection(this.commerceSansPortButton, COMMERCE_ICON);
        this.commerceSansPortButton.addMouseListener(sel4);
        this.commerceSansPortButton.addActionListener((event)-> {
            this.controller.commerceSansPortPressed(window, this);
        });

        Selection sel3 =  this.controller.new Selection(this.chevalierButton, CHEVALIER_ICON);
        this.chevalierButton.addMouseListener(sel3);
        this.chevalierButton.addActionListener((event)-> {
            this.controller.acheterChevalierPressed(window, this);
        });

        this.add(this.commerceSansPortButton);
        this.add(this.chevalierButton);
        this.add(createMenuPanel(joueur));

        Selection sel =  this.controller.new Selection(b1, DICE_ICON);
        b1.addMouseListener(sel);
        b1.addActionListener((event)-> {
            this.controller.subMenuButtonPressed(window, b1,"DICE", aireDeJeuView, b1.getIcon().getIconWidth(), b1.getIcon().getIconHeight(), DICE_ICON);
        });

        Selection sel2 =  this.controller.new Selection(b2, CANCEL_ICON);
        b2.addMouseListener(sel2);
        b2.addActionListener((event)-> {
            this.controller.subMenuButtonPressed(window, b2, "CANCEL", aireDeJeuView, b2.getIcon().getIconWidth(), b2.getIcon().getIconHeight(), CANCEL_ICON);
        });
        this.add(b1);
        this.add(b2);
        this.setBackground(this.backGroundColor);
    }

    public void setDeModel(De6Faces de) {
        this.deModel = de;
    } 

    public De6Faces getDe() {
        return this.deModel;
    }

    public void setController(SubMenuController controller) {
        this.controller = controller;
    }

    public void updateActionsForPlayer(Joueur player, boolean robber, boolean dice, boolean cancel, boolean addFreeRoute) {
        if(player.peutAcheterRoute() || addFreeRoute) {
            this.route.setEnabled(true);
            // System.out.println("line 211");
        } else {
            // System.out.println("line 212");
            this.route.setEnabled(false);
        }

        if(player.peutAcheterColonie()) {
            this.village.setEnabled(true);
        } else {
            this.village.setEnabled(false);
        }

        if(player.peutAcheterVille()) {
            this.city.setEnabled(true);
        } else {
            this.city.setEnabled(false);
        }

        if(robber || player.peutUtiliserCarteChevalier()) {
            this.robber.setEnabled(true);
        } else {
            this.robber.setEnabled(false);
        }

        if(dice) {
            this.b1.setEnabled(true);
        } else {
            this.b1.setEnabled(false);
        }

        if(cancel) {
            this.b2.setEnabled(true);
        } else {
            this.b2.setEnabled(false);
        }

        if(player.peutAcheterCarteChevalier()) {
            this.chevalierButton.setEnabled(true);
        }else {
            this.chevalierButton.setEnabled(false);
        }

        if(player.peutCommerceSansPort()){
            this.commerceSansPortButton.setEnabled(true);
        }else {
            this.commerceSansPortButton.setEnabled(false);
        }
        
    }
}
