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
        System.out.println("Croisement Pressed");
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
        AireDeJeuView aireDeJeuView;


        public Selection(JButton jButton, Color color, AireDeJeuView aireDeJeuView) {
            this.jButton = jButton;
            this.color = color;
            this.aireDeJeuView = aireDeJeuView;
        }

        public void mouseEntered(MouseEvent evt) {
            // 1. Get croisement number which is the text of the button
            // 2. Loop over all tuilesViews and find a button that has the same value 
            // 3. apply changes to this same button
            JButton other_button = new JButton();
            String croisement = this.jButton.getText();
            for (TuileView tuileView : aireDeJeuView.getTuiles()) {
                if(tuileView.getTopLeft().getText().equals(croisement) && !tuileView.getTopLeft().equals(this.jButton)) {
                    other_button = tuileView.getTopLeft();
                }
                if(tuileView.getTopRight().getText().equals(croisement)&&!tuileView.getTopRight().equals(this.jButton)) {
                    other_button = tuileView.getTopRight();
                }
                if(tuileView.getBottomLeft().getText().equals(croisement)&&!tuileView.getBottomLeft().equals(this.jButton)) {
                    other_button = tuileView.getBottomLeft();

                }
                if(tuileView.getBottomRight().getText().equals(croisement)&&!tuileView.getBottomRight().equals(this.jButton)) {
                    other_button = tuileView.getBottomRight();

                }
                other_button.setForeground(new Color(249, 65, 68));
                other_button.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, 20));
            }

            this.buttonSize = jButton.getFont().getSize();
            this.jButton.setForeground(new Color(249, 65, 68));
            this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, 20));
        }
        public void mouseExited(MouseEvent evt) {
            JButton other_button = new JButton();
            String croisement = this.jButton.getText();
            for (TuileView tuileView : aireDeJeuView.getTuiles()) {
                if(tuileView.getTopLeft().getText().equals(croisement) && !tuileView.getTopLeft().equals(this.jButton)) {
                    other_button = tuileView.getTopLeft();
                }
                if(tuileView.getTopRight().getText().equals(croisement)&&!tuileView.getTopRight().equals(this.jButton)) {
                    other_button = tuileView.getTopRight();
                }
                if(tuileView.getBottomLeft().getText().equals(croisement)&&!tuileView.getBottomLeft().equals(this.jButton)) {
                    other_button = tuileView.getBottomLeft();

                }
                if(tuileView.getBottomRight().getText().equals(croisement)&&!tuileView.getBottomRight().equals(this.jButton)) {
                    other_button = tuileView.getBottomRight();

                }
                other_button.setForeground(this.color);
                other_button.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, this.buttonSize));
            }
            this.jButton.setForeground(this.color);
            this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, this.buttonSize));
        }
    }
    public class Selection2 extends MouseAdapter {
        JButton jButton;
        int buttonSize;
        Color color;
        AireDeJeuView aireDeJeuView;


        public Selection2(JButton jButton, Color color, AireDeJeuView aireDeJeuView) {
            this.jButton = jButton;
            this.color = color;
            this.aireDeJeuView = aireDeJeuView;
        }

        public void mouseEntered(MouseEvent evt) {
            this.buttonSize = jButton.getFont().getSize();
            this.jButton.setForeground(new Color(243, 114, 44));
            this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, 25));
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
