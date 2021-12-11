package gui.views;
import javax.swing.*;
import java.awt.*;

import gui.controllers.TuileController;
import principal.Tuile;

public class TuileView extends JPanel {

    private Tuile tuileModel;
    private TuileController tuilleController;

    private JLabel jetonLabel = new JLabel();
    private JLabel terrain = new JLabel();

    private JButton topLeftcroisement = new JButton();
    private JButton topRightcroisement = new JButton();
    private JButton bottomLeftcroisement = new JButton();
    private JButton bottomRightcroisement = new JButton();

    private GridLayout tuileLayout = new GridLayout(0, 3);

    private void addComponents() {
        
        add(topLeftcroisement);
        add(terrain);
        add(topRightcroisement);

        add(bottomLeftcroisement);
        add(jetonLabel);
        add(bottomRightcroisement);
    }

    private void setCroisementTextandPosition() {

        topLeftcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(0))); // topLeft Croisement
        topLeftcroisement.setHorizontalAlignment(JLabel.LEFT);
        topLeftcroisement.setVerticalAlignment(JLabel.NORTH);

        topLeftcroisement.addMouseListener(this.tuilleController.new Selection(topLeftcroisement));
       
        topLeftcroisement.setOpaque(false);
        topLeftcroisement.setContentAreaFilled(false);
        topLeftcroisement.setBorderPainted(false);


        topRightcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(1))); // topRight Croisement
        topRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
        topRightcroisement.setVerticalAlignment(JLabel.NORTH);

        topRightcroisement.addMouseListener(this.tuilleController.new Selection(topRightcroisement));

        topRightcroisement.setOpaque(false);
        topRightcroisement.setContentAreaFilled(false);
        topRightcroisement.setBorderPainted(false);


        bottomLeftcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(2)));  // bottomLeft Croisement
        bottomLeftcroisement.setHorizontalAlignment(JLabel.LEFT);
        bottomLeftcroisement.setVerticalAlignment(JLabel.BOTTOM);

        bottomLeftcroisement.addMouseListener(this.tuilleController.new Selection(bottomLeftcroisement));

        bottomLeftcroisement.setOpaque(false);
        bottomLeftcroisement.setContentAreaFilled(false);
        bottomLeftcroisement.setBorderPainted(false);



        bottomRightcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(3))); // bottomRight Croisement
        bottomRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
        bottomRightcroisement.setVerticalAlignment(JLabel.BOTTOM);

        bottomRightcroisement.addMouseListener(this.tuilleController.new Selection(bottomRightcroisement));


        bottomRightcroisement.setOpaque(false);
        bottomRightcroisement.setContentAreaFilled(false);
        bottomRightcroisement.setBorderPainted(false);

    }

    private void setTextAndPosition() {
        /*
          Set Jeton and Terain JLabels attributes
        */

        this.jetonLabel.setText(String.valueOf(this.tuileModel.getJeton()));
        this.jetonLabel.setHorizontalAlignment(JLabel.CENTER);

        this.terrain.setText(String.valueOf(this.tuileModel.getTerrain()));
        this.terrain.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setModel(Tuile tuileModel) {
        this.tuileModel = tuileModel;
        this.setLayout(tuileLayout);
        setTextAndPosition();
        setCroisementTextandPosition();
        addComponents();
    }
    
    public void setControleur(TuileController tuilesController) {
        this.tuilleController = tuilesController;
    }

    public Tuile getModel() {
        return this.tuileModel;
    }
    public TuileController getController() {
        return this.tuilleController;
    }
}
