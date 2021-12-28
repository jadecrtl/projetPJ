package gui.controllers;
import java.awt.*;

import javax.swing.JButton;
import java.awt.event.*;

import gui.views.AireDeJeuView;
import gui.views.SubMenuView;
import gui.views.TuileView;
import gui.views.Window;
import principal.Tuile;

public class TuileController {
    Tuile tuileModel;
    TuileView tuileView;
    JButton previousJeton;
    public static String typeOfActionCroisement; // City; Village or Route
    public static int clickCounter = 0;
    public static int firstIdRoute;
    public static int secondIdRoute;
    

    public void croisementPressed(JButton jbutton, AireDeJeuView aireDeJeuView, SubMenuView subMenuView, Selection selection) {
        // TODO: Before doing any insertion, verify with model methods if this spot is allow to be inserted such element
        if (typeOfActionCroisement.equals("CITY") || typeOfActionCroisement.equals("VILLAGE")) {
            //  TODO: Insert City if possible in this Tuile (Call model and insert robber if possible)
            // TODO: Tell tuile to check model if has a city and update the croisement with either a city icon or the number
            System.out.println("A Village pos: "+jbutton.getText());
            subMenuView.joueurModel.placeColonieGratuite(aireDeJeuView.getAireDeJeuModel(), Integer.valueOf(jbutton.getText()));
            System.out.println(subMenuView.joueurModel.getPointVictoire());

            System.out.println("Croisement Pressed");
            if(!Window.gameStatus.equals("PREPARE_PARTIE")) {
                subMenuView.city.setEnabled(true);
                subMenuView.village.setEnabled(true);
                subMenuView.b1.setEnabled(true);
                subMenuView.b2.setEnabled(true);
                subMenuView.robber.setEnabled(true);
                subMenuView.route.setEnabled(true);
            }

            if(Window.gameStatus.equals("PREPARE_PARTIE")) {
                subMenuView.b2.setEnabled(true);
            }

            JButton other_button = new JButton();
            String croisement = jbutton.getText();

            for (TuileView tuileView : aireDeJeuView.getTuiles()) {
                if(tuileView.getTopLeft().getText().equals(croisement) && !tuileView.getTopLeft().equals(jbutton)) {
                    other_button = tuileView.getTopLeft();
                }
                if(tuileView.getTopRight().getText().equals(croisement)&&!tuileView.getTopRight().equals(jbutton)) {
                    other_button = tuileView.getTopRight();
                }
                if(tuileView.getBottomLeft().getText().equals(croisement)&&!tuileView.getBottomLeft().equals(jbutton)) {
                    other_button = tuileView.getBottomLeft();

                }
                if(tuileView.getBottomRight().getText().equals(croisement)&&!tuileView.getBottomRight().equals(jbutton)) {
                    other_button = tuileView.getBottomRight();

                }
                other_button.removeMouseListener(selection);
                jbutton.removeMouseListener(selection);
            }

            for (TuileView tuile : aireDeJeuView.getTuiles()) {
                tuile.getTopLeft().setEnabled(false);
                tuile.getTopRight().setEnabled(false);
                tuile.getBottomLeft().setEnabled(false);
                tuile.getBottomRight().setEnabled(false);

                tuile.updateCroisementView(typeOfActionCroisement); // Ask view to look into model and update the value of the "jeton" with or without robber.
            }
        } else if (typeOfActionCroisement.equals("ROUTE")) {
            // TODO: Before doing any insertion, verify with model methods if this spot is allow to be inserted such element
            // System.out.println("Route....!");
            int value = TuileController.clickCounter;
            if (value == 0) {
                // First time clicking
                TuileController.firstIdRoute = Integer.valueOf(jbutton.getText());
                System.out.println("A: "+ TuileController.firstIdRoute);
                JButton other_button = new JButton();
                String croisement = jbutton.getText();
                for (TuileView tuileView : aireDeJeuView.getTuiles()) {
                    if(tuileView.getTopLeft().getText().equals(croisement) && !tuileView.getTopLeft().equals(jbutton)) {
                        other_button = tuileView.getTopLeft();
                    }
                    if(tuileView.getTopRight().getText().equals(croisement)&&!tuileView.getTopRight().equals(jbutton)) {
                        other_button = tuileView.getTopRight();
                    }
                    if(tuileView.getBottomLeft().getText().equals(croisement)&&!tuileView.getBottomLeft().equals(jbutton)) {
                        other_button = tuileView.getBottomLeft();
                    }
                    if(tuileView.getBottomRight().getText().equals(croisement)&&!tuileView.getBottomRight().equals(jbutton)) {
                        other_button = tuileView.getBottomRight();
                    }
                    other_button.removeMouseListener(selection);
                    jbutton.removeMouseListener(selection);
                    }
                TuileController.increaseClickCounter();
            }
            else if (value == 1) {
                // Clicking for the second time
                TuileController.secondIdRoute = Integer.valueOf(jbutton.getText());
                JButton other_button = new JButton();
                String croisement = jbutton.getText();
                System.out.println("A: "+TuileController.firstIdRoute);
                System.out.println("B: " +TuileController.secondIdRoute);
                boolean succs = subMenuView.joueurModel.placeRouteGratuite(aireDeJeuView.getAireDeJeuModel(), TuileController.firstIdRoute, TuileController.secondIdRoute);
                if (succs) {
                    System.out.println(subMenuView.joueurModel.getPointVictoire());

                    for (TuileView tuileView : aireDeJeuView.getTuiles()) {
                        if(tuileView.getTopLeft().getText().equals(croisement) && !tuileView.getTopLeft().equals(jbutton)) {
                            other_button = tuileView.getTopLeft();
                        }
                        if(tuileView.getTopRight().getText().equals(croisement)&&!tuileView.getTopRight().equals(jbutton)) {
                            other_button = tuileView.getTopRight();
                        }
                        if(tuileView.getBottomLeft().getText().equals(croisement)&&!tuileView.getBottomLeft().equals(jbutton)) {
                            other_button = tuileView.getBottomLeft();
                        }
                        if(tuileView.getBottomRight().getText().equals(croisement)&&!tuileView.getBottomRight().equals(jbutton)) {
                            other_button = tuileView.getBottomRight();
                        }
                        other_button.removeMouseListener(selection);
                        jbutton.removeMouseListener(selection);
                    }
                    
                    TuileController.resetClickCounter();
                    if(!Window.gameStatus.equals("PREPARE_PARTIE")) {
                        subMenuView.city.setEnabled(true);
                        subMenuView.route.setEnabled(true);
                        subMenuView.b1.setEnabled(true);
                        subMenuView.b2.setEnabled(true);
                        subMenuView.robber.setEnabled(true);
                    }
    
                    subMenuView.village.setEnabled(true);
                    for (TuileView tuile : aireDeJeuView.getTuiles()) {
                        tuile.getTopLeft().setEnabled(false);
                        tuile.getTopRight().setEnabled(false);
                        tuile.getBottomLeft().setEnabled(false);
                        tuile.getBottomRight().setEnabled(false);
                        tuile.updateCroisementView(typeOfActionCroisement); // Ask view to look into model and update the value of the "jeton" with or without robber.
                    }
                }else {
                    TuileController.resetClickCounter();
                    System.out.println("Please select a valid coordinate");
                    subMenuView.route.setEnabled(true);
                }

            }
        }
    }

    public void jetonPressed(JButton jbutton, AireDeJeuView aireDeJeuView, SubMenuView subMenuView, Selection2 selection) {
        //  TODO: Insert Robber if possible in this Tuile (Call model and insert robber if possible)
        // TODO: Tell tuile to check model if has a robber and update the jeton with either a robber or the number
        subMenuView.city.setEnabled(true);
        subMenuView.route.setEnabled(true);
        subMenuView.village.setEnabled(true);
        subMenuView.b1.setEnabled(true);
        subMenuView.b2.setEnabled(true);

        jbutton.removeMouseListener(selection);

        for (TuileView tuile : aireDeJeuView.getTuiles()) {
            tuile.getJetonButton().setEnabled(false);
            tuile.updateJetonView(); // Ask view to look into model and update the value of the "jeton" with or without robber.
        }
    }
    public void setModel(Tuile tuileModel) {
        this.tuileModel = tuileModel;
    }

    public void setView(TuileView tuileView) {
        this.tuileView = tuileView;
    }

    public static void settypeOfActionCroisement(String type) {
        typeOfActionCroisement = type;// City; Village or Route
    } 

    public static void increaseClickCounter() {
        TuileController.clickCounter++;
    } 

    public static void resetClickCounter() {
        TuileController.clickCounter = 0;
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
                if(tuileView.getTopRight().getText().equals(croisement) && !tuileView.getTopRight().equals(this.jButton)) {
                    other_button = tuileView.getTopRight();
                }
                if(tuileView.getBottomLeft().getText().equals(croisement) && !tuileView.getBottomLeft().equals(this.jButton)) {
                    other_button = tuileView.getBottomLeft();

                }
                if(tuileView.getBottomRight().getText().equals(croisement) && !tuileView.getBottomRight().equals(this.jButton)) {
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
            // this.buttonSize = jButton.getFont().getSize();
            // this.jButton.setForeground(new Color(243, 114, 44));
            // this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, 25));
        }
        public void mouseExited(MouseEvent evt) {
            // this.jButton.setForeground(this.color);
            // this.jButton.setFont(new Font(TuileController.this.tuileView.getCustomFont().getFontName(), Font.PLAIN, this.buttonSize));
        }
    }
}
