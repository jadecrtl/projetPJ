package gui.views;

import gui.controllers.SubMenuController;
import gui.views.TuileView;
import principal.Joueur;
import utils.De6Faces;
import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class SubMenuView extends JPanel{

    private Joueur joueurModel;
    private De6Faces deModel;
    private AireDeJeuView aireDeJeuView;

    private SubMenuController controller;
    private Font customFont;

    private Color backGroundColor = new Color(39, 125, 161);
    private String CANCEL_ICON = "catane/src/static/cancel.png";
    private String DICE_ICON = "catane/src/static/dice.png";

    public JButton city = new JButton("City");
    public JButton village = new JButton("Village");
    public JButton route = new JButton("Route");
    public JButton robber = new JButton("Robber");

    public JButton b1 = createbButton(DICE_ICON);
    public JButton b2 = createbButton(CANCEL_ICON);


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

    public JPanel createMenuPanel() {
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
        secondPanel.add(getJoueurNom("Paris"));
        secondPanel.add(getActions());


        panel.add(secondPanel);
        return panel;
    }

    private JPanel getJoueurNom(String description) {
        // TODO: use model to get user name and other data...

        JPanel pan = new JPanel();
        JLabel label = new JLabel();
        JLabel label_name = new JLabel();


        label.setText("Player:");
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

    private JPanel getActions() {
        // Jpanel with 3 buttons;
        // TODO: use model to get user name and other data...
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Add:");

        label.setFont(this.customFont);
        label.setForeground(Color.BLACK);

        panel.add(label);

        

        city.setFont(this.customFont);
        village.setFont(this.customFont);
        route.setFont(this.customFont);
        robber.setFont(this.customFont);

        city.setFocusPainted(false);
        village.setFocusPainted(false);
        route.setFocusPainted(false);
        robber.setFocusPainted(false);

        city.addActionListener((event)-> {this.controller.addCityPressed();});
        village.addActionListener((event)-> {this.controller.addVillagePressed();});
        route.addActionListener((event)-> {this.controller.addRoutePressed();});
        robber.addActionListener((event)-> {this.controller.addRobberPressed(aireDeJeuView);});

        panel.add(city);
        panel.add(village);
        panel.add(route);
        panel.add(robber);

        panel.setOpaque(false);

        return panel;
    }

    public JButton createbButton(String path) {
        JButton button = new JButton(TuileView.createIcon(path, 40, 40));

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setPreferredSize(new Dimension(60, 60));
        button.setFocusPainted(false);        
        return button;
    }

    public void setJoueurModel(Joueur model) {
        this.joueurModel = model;
        setNewFont();
        this.add(createMenuPanel());


        b1.addMouseListener(this.controller.new Selection(b1, DICE_ICON));
        b1.addActionListener((event)-> {this.controller.subMenuButtonPressed("DICE");});


        b2.addMouseListener(this.controller.new Selection(b2, CANCEL_ICON));
        b2.addActionListener((event)-> {this.controller.subMenuButtonPressed("CANCEL");});

        // b1.setEnabled(false);


        this.add(b1);
        this.add(b2);
        this.setBackground(this.backGroundColor);
    }

    public void setDeModel(De6Faces de) {
        this.deModel = de;
    } 

    public void setController(SubMenuController controller) {
        this.controller = controller;
    }

    

}
