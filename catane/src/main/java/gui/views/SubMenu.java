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


public class SubMenu extends JPanel{

    private Joueur joueurModel;
    private De6Faces deModel;

    private SubMenuController controller;
    private Font customFont;

    private GridLayout layout;
    private Color backGroundColor = new Color(39, 125, 161);
    private int HORIZONTAL_GAP = 10;
    private String CANCEL_ICON = "catane/src/static/cancel.png";
    private String DICE_ICON = "catane/src/static/dice.png";

    // menu panel
    // dice button
    // cancel button

    public SubMenu() {

        // this.setLayoutSubMenu();
        setNewFont();
        this.add(createMenuPanel());
        this.add(createbButton(DICE_ICON));
        this.add(createbButton(CANCEL_ICON));

        // this.add(createButton("Dice", createIcon("dice"), actionDice));
        // this.add(createButton("Cancel", createIcon("cancel"), actionCancel));
        this.setBackground(this.backGroundColor);
    }
    // TODO: extraire method pour tous classes
    public void setNewFont() {
        try {

            this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Medium.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (Exception e) {

            this.customFont = new Font(Font.SERIF, Font.PLAIN,  10);
        }
       
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
        secondPanel.add(getJoueurNom("Player: Paris"));
        secondPanel.add(getJoueurNom("Test: x x x"));


        panel.add(secondPanel);
        return panel;
    }

    private JLabel getJoueurNom(String description) {
        // TODO: use model to get user name and other data...
        JLabel label = new JLabel();
        label.setText(description);
        label.setFont(this.customFont);
        label.setForeground(Color.WHITE);
        return label;
    }

    public JButton createbButton(String path) {
        JButton button = new JButton(TuileView.createIcon(path, 40, 40));

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);        
        return button;
    }

    public void setJoueurModel(Joueur model) {
        this.joueurModel = model;
    }

    public void setDeModel(De6Faces de) {
        this.deModel = de;
    } 

    public void setController(SubMenuController controller) {
        this.controller = controller;
    }

    

}
