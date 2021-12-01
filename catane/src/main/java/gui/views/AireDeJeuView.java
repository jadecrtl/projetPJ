package gui.views;

import javax.swing.*;

import gui.controllers.AireDeJeuController;
import principal.AireDeJeu;

import java.awt.*;
/* 
Aire de Jeu view.
*/
public class AireDeJeuView extends JPanel{
    // Model 
    private AireDeJeu aireDeJeu;
    // Controleur
    private AireDeJeuController aireDeJeuController;
    // Layout
    private GridLayout aireDeJeuGrid;

    public AireDeJeuView(AireDeJeu aireDeJeu) {
        // Set View attributes
        this.aireDeJeu = aireDeJeu;
        // Creation du Grid
        this.aireDeJeuGrid = new GridLayout(this.aireDeJeu.getHorizontale(), this.aireDeJeu.getVerticale());
        // Mise en place du Layout
        this.setLayout(aireDeJeuGrid);
        // Ajout des tuilles
        this.addTuiles();
    }

    // Méthodes d'ajout de contenu dans JPanel
    public void addTuiles() {
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<(this.aireDeJeu.getVerticale()*this.aireDeJeu.getHorizontale()); i++){
            JLabel tuile = new JLabel("Tuile: "+i);  // Todo: add tuile component.
            tuile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(tuile);
        }
    }

    // Setters
    public void setControleur(AireDeJeuController aireDeJeuController) {
        this.aireDeJeuController = aireDeJeuController;
    }

    public AireDeJeuController getControleur() {
        return this.aireDeJeuController;
    }

    // public void setModel(AireDeJeu aireDeJeu) {
    //     this.aireDeJeu = aireDeJeu;
    // }
}
