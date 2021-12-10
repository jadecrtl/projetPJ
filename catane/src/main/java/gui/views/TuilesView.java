package gui.views;
import javax.swing.*;
import java.awt.*;

import gui.controllers.TuilesController;
import principal.Tuile;

public class TuilesView extends JPanel {

    private JLabel jetonLabel = new JLabel();
    private JLabel terrain = new JLabel();

    private Tuile tuile;
    
    private TuilesController tuilleController;
    private BorderLayout tuileLayout = new BorderLayout();

    public TuilesView(Tuile tuile) {
        this.tuile = tuile;
        this.setLayout(tuileLayout);

        this.jetonLabel.setText(String.valueOf(this.tuile.getJeton()));
        this.jetonLabel.setHorizontalAlignment(JLabel.CENTER);

        this.terrain.setText(String.valueOf(this.tuile.getTerrain()));
        this.terrain.setHorizontalAlignment(JLabel.CENTER);

        add(this.jetonLabel, BorderLayout.NORTH);
        add(this.terrain, BorderLayout.SOUTH);
    }

}
