package gui.views;

import javax.swing.*;
import principal.AireDeJeu;

import java.awt.*;
/* 
Aire de Jeu view.
*/
public class AireDeJeuView extends JPanel{
    private GridLayout cataneGrid;
    public AireDeJeuView(AireDeJeu aireDeJeu) {
        this.cataneGrid = new GridLayout(aireDeJeu.getHorizontale(), aireDeJeu.getVerticale());
        this.setLayout(cataneGrid);
        this.addTuiles(aireDeJeu);
    }

    public void addTuiles(AireDeJeu aireDeJeu) {
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<(aireDeJeu.getVerticale()*aireDeJeu.getHorizontale()); i++){
            JLabel tuile = new JLabel("Tuile: "+i);  // Todo: add tuile component.
            tuile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(tuile);
        }
    }
}
