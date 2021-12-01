package gui.views;

import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import gui.controllers.TuilesController;
import principal.Tuile;

public class TuilesView extends JPanel {
    private JLabel tuileBackground;
    private JLabel jetonLabel = new JLabel();
    // private List<JButton> croisements;
    private Tuile tuile;
    private TuilesController tuilleController;
    private BorderLayout tuileLayout; 

    public TuilesView(Tuile tuile) {
        this.tuile = tuile;
        this.jetonLabel.setText(String.valueOf(this.tuile.getJeton()));
        this.tuileLayout = new BorderLayout();
        try {
            this.tuileBackground = new JLabel(new ImageIcon(ImageIO.read(new File("static/backgroundRock.jpg"))));
            add(tuileBackground);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(this.jetonLabel, BorderLayout.CENTER);
    }

}
