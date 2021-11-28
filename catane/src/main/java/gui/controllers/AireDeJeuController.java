package gui.controllers;

import javax.swing.*;
import java.awt.*;

import gui.models.AireDeJeuModel;


public class AireDeJeuController {

    public static void fillAireDeJeu(AireDeJeuModel aireDeJeu) {
        aireDeJeu.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<(aireDeJeu.getRows()*aireDeJeu.getCols()); i++){
            JLabel tuile = new JLabel("Tuile: "+i); 
            tuile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            aireDeJeu.add(tuile);
        }
    }
}
