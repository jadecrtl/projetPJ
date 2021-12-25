package gui.controllers;

import javax.swing.JButton;
import java.awt.event.*;

import gui.views.TuileView;

public class StartGameFormController {

    public void playPressed() {
        // Handle Form and Start game (call backend Method and initialize board...etc)
        System.out.println("Start Game!");
    }

    public class Selection extends MouseAdapter {
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
            this.jButton.setIcon(TuileView.createIcon(this.iconPath, 155, 155));

        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setIcon(TuileView.createIcon(this.iconPath, this.iconWidth, this.iconHeight));
        }
    }
}
