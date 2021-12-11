package gui.controllers;
import java.awt.*;

import javax.swing.JButton;
import java.awt.event.*;
import gui.views.TuileView;
import principal.Tuile;

public class TuileController {
    Tuile tuileModel;
    TuileView tuilesView;

    public class Selection extends MouseAdapter {
        JButton jButton;
        int buttonSize;


        public Selection(JButton jButton) {
            this.jButton = jButton;
        }

        public void mouseEntered(MouseEvent evt) {
            this.buttonSize = jButton.getFont().getSize();
            this.jButton.setForeground(Color.RED);
            this.jButton.setFont(new Font("Arial", Font.PLAIN, 25));


        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setForeground(Color.BLACK);
            this.jButton.setFont(new Font("Arial", Font.PLAIN, this.buttonSize));
        }
    }

    public void setModel(Tuile tuileModel) {
        this.tuileModel = tuileModel;
    }

    public void setView(TuileView tuilesView) {
        this.tuilesView = tuilesView;
    }


}
