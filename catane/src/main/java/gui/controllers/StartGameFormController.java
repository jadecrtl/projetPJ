package gui.controllers;

import javax.swing.JButton;
import java.awt.event.*;

import gui.CataneGui;
import gui.views.StartGameFormView;
import gui.views.TuileView;
import gui.views.Window;
import principal.Jeu;

public class StartGameFormController {
    StartGameFormView form;

    public void setView(StartGameFormView form) {
        this.form = form;
    }

    public void playPressed(StartGameFormView form, Window window) {
        // Handle Form and Start game (call backend Method and initialize board...etc)
        setView(form);
        // System.out.println("Start Game!");
        CataneGui cataneGui = new CataneGui();
        Jeu jeu = cataneGui.initializeJeu(form);
        window.setGame(jeu);
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
