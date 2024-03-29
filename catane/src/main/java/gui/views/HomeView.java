package gui.views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.controllers.HomeController;

import java.awt.event.*;


import java.awt.*;
import java.io.File;


public class HomeView extends JPanel {
    Font customFont;
    HomeController controller;


    
    public void setController(HomeController controller) {
        this.controller = controller;
    }
    public HomeView(Window window) {
        setNewFont();
        this.setLayout(new BorderLayout()); // Panel Layout

        // Game Name and Button
        JPanel nameAndButtonPanel = new JPanel();
        nameAndButtonPanel.setLayout(new BorderLayout());

        JLabel name = new JLabel("Les Colons de Catane");
        name.setFont(customFont);
        name.setForeground(Color.BLACK);

        // JPanel boxButtonPanel = new JPanel();
        JButton play = new JButton(TuileView.createIcon("catane/src/static/start.png", 100, 100));
        play.setPreferredSize(new Dimension(120, 120));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFocusPainted(false); 

        play.addMouseListener(new Selection(play, "catane/src/static/start.png"));
        play.addActionListener((event) -> this.controller.playPressed(window));

        // boxButtonPanel.add(play);

        nameAndButtonPanel.add(name, BorderLayout.WEST);
        nameAndButtonPanel.add(play, BorderLayout.EAST);
        nameAndButtonPanel.setBorder(new EmptyBorder(0, 20, 0, 20));

        // Image Background Panel
        JPanel imageBackgroundPanel = new JPanel();
        JLabel backgroundLabel = new JLabel(TuileView.createIcon("catane/src/static/medieval_background.jpg", window.getBounds().width+300, window.getBounds().height-120));
        imageBackgroundPanel.add(backgroundLabel);

        // Add content to this main Panel
        this.add(nameAndButtonPanel, BorderLayout.NORTH);
        this.add(imageBackgroundPanel);
        
    }

    public void setNewFont() {
        try {

            this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Bold.ttf")).deriveFont(45f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (Exception e) {

            this.customFont = new Font(Font.SERIF, Font.PLAIN,  10);
        }
       
    }
    // FIXME -> Move to controller
    public static class Selection extends MouseAdapter {
        JButton jButton;
        int iconWidth;
        int iconHeight;
        String iconPath;

        public Selection(JButton jButton, String path) {
            this.jButton = jButton;
            this.iconPath = path;
        }

        public void mouseEntered(MouseEvent evt) {
            this.iconHeight = jButton.getIcon().getIconWidth();
            this.iconWidth = jButton.getIcon().getIconHeight();
            this.jButton.setIcon(TuileView.createIcon(this.iconPath, 120, 120));

        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setIcon(TuileView.createIcon(this.iconPath, this.iconWidth, this.iconHeight));
        }
    }
}
