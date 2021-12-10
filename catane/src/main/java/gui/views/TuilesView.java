package gui.views;
import javax.swing.*;
import java.awt.*;

import gui.controllers.TuilesController;
import principal.Tuile;

public class TuilesView extends JPanel {

    private JLabel jetonLabel = new JLabel();
    private JLabel terrain = new JLabel();
    private JLabel topLeftcroisement = new JLabel();
    private JLabel topRightcroisement = new JLabel();
    private JLabel bottomLeftcroisement = new JLabel();
    private JLabel bottomRightcroisement = new JLabel();

    private Tuile tuile;
    private TuilesController tuilleController;
    private GridLayout tuileLayout = new GridLayout(0, 3);

    public TuilesView(Tuile tuile) {
        this.tuile = tuile;
        this.setLayout(tuileLayout);

        setTextAndPosition();
        setCroisementTextandPosition();
        addComponents();   
    }

    private void addComponents() {
        add(topLeftcroisement);
        add(terrain);
        add(topRightcroisement);

        add(bottomLeftcroisement);
        add(jetonLabel);
        add(bottomRightcroisement);
    }

    private void setCroisementTextandPosition() {
        topLeftcroisement.setText(String.valueOf(tuile.getCroisementsVoisins().get(0))); // topLeft Croisement
        topLeftcroisement.setHorizontalAlignment(JLabel.LEFT);

        topRightcroisement.setText(String.valueOf(tuile.getCroisementsVoisins().get(1))); // topRight Croisement
        topRightcroisement.setHorizontalAlignment(JLabel.RIGHT);

        bottomLeftcroisement.setText(String.valueOf(tuile.getCroisementsVoisins().get(2)));  // bottomLeft Croisement
        bottomLeftcroisement.setHorizontalAlignment(JLabel.LEFT);

        bottomRightcroisement.setText(String.valueOf(tuile.getCroisementsVoisins().get(3))); // bottomRight Croisement
        bottomRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
    }

    private void setTextAndPosition() {
        /*
          Set Jeton and Terain JLabels attributes
        */

        this.jetonLabel.setText(String.valueOf(this.tuile.getJeton()));
        this.jetonLabel.setHorizontalAlignment(JLabel.CENTER);

        this.terrain.setText(String.valueOf(this.tuile.getTerrain()));
        this.terrain.setHorizontalAlignment(JLabel.CENTER);
    }
}
