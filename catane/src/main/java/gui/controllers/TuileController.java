package gui.controllers;
import java.awt.*;

import javax.swing.JButton;
import java.awt.event.*;

import gui.views.AireDeJeuView;
import gui.views.SubMenuView;
import gui.views.TuileView;
import principal.Tuile;

public class TuileController {
    Tuile tuileModel;
    TuileView tuileView;
    JButton previousJeton;
    

    public void croisementPressed() {
        // Do something...
    }

    public void jetonPressed(JButton jbutton, AireDeJeuView aireDeJeuView, SubMenuView subMenuView) {
        //  TODO: Insert Robber if possible in this Tuile (Call model and insert robber if possible)
        // TODO: Tell tuile to check model if has a robber and update the jeton with either a robber or the number
        subMenuView.city.setEnabled(true);
        subMenuView.route.setEnabled(true);
        subMenuView.village.setEnabled(true);
        subMenuView.b1.setEnabled(true);
        subMenuView.b2.setEnabled(true);

        for (TuileView tuile : aireDeJeuView.getTuiles()) {
            tuile.getTopLeft().setEnabled(true);
            tuile.getTopRight().setEnabled(true);
            tuile.getBottomLeft().setEnabled(true);
            tuile.getBottomRight().setEnabled(true);
            tuile.getJetonButton().setEnabled(false);

            tuile.updateJetonView(); // Ask view to look into model and update the value of the "jeton" with or without robber.
        }
    }

    public class Selection extends MouseAdapter {
        JButton jButton;
        int buttonSize;
        Color color;


        public Selection(JButton jButton, Color color) {
            this.jButton = jButton;
            this.color = color;
        }

        public void mouseEntered(MouseEvent evt) {
            this.buttonSize = jButton.getFont().getSize();
            this.jButton.setForeground(new Color(249, 65, 68));
            this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, 20));


        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setForeground(this.color);
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
