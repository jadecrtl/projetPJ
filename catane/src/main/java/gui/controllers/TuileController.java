package gui.controllers;
import java.awt.*;

import javax.swing.JButton;
import java.awt.event.*;
import gui.views.TuileView;
import principal.Tuile;

public class TuileController {
    Tuile tuileModel;
    TuileView tuileView;

    public void croisementPressed(JButton button) {
        // Do something...
    }

    public class Selection extends MouseAdapter {
        JButton jButton;
        int buttonSize;


        public Selection(JButton jButton) {
            this.jButton = jButton;
        }

        public void mouseEntered(MouseEvent evt) {
            this.buttonSize = jButton.getFont().getSize();
            this.jButton.setForeground(new Color(249, 65, 68));
            this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, 18));


        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setForeground(Color.BLACK);
            this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, this.buttonSize));
        }
    }

    public void setModel(Tuile tuileModel) {
        this.tuileModel = tuileModel;
    }

    public void setView(TuileView tuileView) {
        this.tuileView = tuileView;
    }


}
