package gui.views;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import gui.controllers.TuilesController;
import principal.Tuile;

public class TuilesView extends JPanel {

    private JLabel jetonLabel = new JLabel();
    private JLabel terrain = new JLabel();
    private Tuile tuile;
    
    private TuilesController tuilleController;
    private GridLayout tuileLayout = new GridLayout(0, 3);

    public TuilesView(Tuile tuile) {
        this.tuile = tuile;
        this.setLayout(tuileLayout);

        this.jetonLabel.setText(String.valueOf(this.tuile.getJeton()));
        this.jetonLabel.setHorizontalAlignment(JLabel.CENTER);

        this.terrain.setText(String.valueOf(this.tuile.getTerrain()));
        this.terrain.setHorizontalAlignment(JLabel.CENTER);

        JLabel one = new JLabel("1");
        one.setHorizontalAlignment(JLabel.LEFT);

        JLabel two = new JLabel("2");
        two.setHorizontalAlignment(JLabel.CENTER);

        JLabel three = new JLabel("3");
        three.setHorizontalAlignment(JLabel.RIGHT);

        JLabel four = new JLabel("4");
        four.setHorizontalAlignment(JLabel.LEFT);

        JLabel five = new JLabel("5");
        five.setHorizontalAlignment(JLabel.CENTER);

        JLabel six = new JLabel("6");
        six.setHorizontalAlignment(JLabel.RIGHT);

        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        
    }
}
