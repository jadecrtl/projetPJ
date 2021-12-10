package gui.views;
import gui.controllers.*;
import principal.*;
import enums.*;
import javax.swing.*;
import java.awt.*;

public class AireDeJeuView extends JPanel{
    private AireDeJeu aireDeJeuModel;
    private AireDeJeuController aireDeJeuController;
    private GridLayout aireDeJeuGrid;

    public AireDeJeuView() {

    }

    public void addTuiles() {
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<(this.aireDeJeuModel.getVerticale()*this.aireDeJeuModel.getHorizontale()); i++){
            Tuile tuileModel = new Tuile(2);            
            tuileModel.setJeton(5);
            tuileModel.setTerrain(Terrain.DESERT);
            
            tuileModel.setCroisementsVoisins(5);
            tuileModel.setCroisementsVoisins(6);
            tuileModel.setCroisementsVoisins(7);
            tuileModel.setCroisementsVoisins(8);

            JPanel tuile = new TuilesView(tuileModel);
            tuile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(tuile);
        }
    }

    public void setControleur(AireDeJeuController aireDeJeuController) {
        this.aireDeJeuController = aireDeJeuController;
    }

    public void setModel(AireDeJeu aireDeJeu) {
        this.aireDeJeuModel = aireDeJeu;
        this.setLayout(aireDeJeu);
        this.addTuiles();
    }

    public AireDeJeuController getControleur() {
        return this.aireDeJeuController;
    }

    public AireDeJeu getAireDeJeuModel() {
        return this.aireDeJeuModel;
    }

    public void setLayout(AireDeJeu aireDeJeu) {
        this.aireDeJeuGrid = new GridLayout(this.aireDeJeuModel.getHorizontale(), this.aireDeJeuModel.getVerticale());
        aireDeJeuGrid.setVgap(10);
        aireDeJeuGrid.setHgap(10);
        this.setLayout(aireDeJeuGrid);
    }


}
