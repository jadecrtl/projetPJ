package gui.controllers;
import java.awt.*;

import javax.swing.JButton;

import gui.views.TuileView;

import java.awt.event.*;
public class StartGameFormController {

    public void playPressed() {
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
