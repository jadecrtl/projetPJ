package gui.views;
import gui.controllers.*;
import principal.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AireDeJeuView extends JPanel{
    private AireDeJeu aireDeJeuModel;
    private AireDeJeuController aireDeJeuController;
    private GridLayout aireDeJeuGrid;
    private final int HORIZONTAL_GAP = 10;
    private final int VERTICAL_GAP = 10;
    private Color backGroundColor = new Color(255, 187, 51);

    public void setTuiles() {
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<this.aireDeJeuModel.getTuiles().size(); i++){
            JPanel tuile = new TuilesView(this.aireDeJeuModel.getTuiles().get(i));
            tuile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(tuile);
        }
    }
    public void setControleur(AireDeJeuController aireDeJeuController) {
        this.aireDeJeuController = aireDeJeuController;
    }

    public void setModel(AireDeJeu aireDeJeu) {
        this.aireDeJeuModel = aireDeJeu;
        setTuiles();
        this.setLayout(aireDeJeu);
        this.setBackgroundColor();
    }

    public AireDeJeuController getControleur() {
        return this.aireDeJeuController;
    }

    public AireDeJeu getAireDeJeuModel() {
        return this.aireDeJeuModel;
    }

    public void setLayout(AireDeJeu aireDeJeu) {
        this.aireDeJeuGrid = new GridLayout(this.aireDeJeuModel.getHorizontale(), this.aireDeJeuModel.getVerticale());
        aireDeJeuGrid.setVgap(VERTICAL_GAP);
        aireDeJeuGrid.setHgap(HORIZONTAL_GAP);
        this.setLayout(aireDeJeuGrid);
    }

    public void setBackgroundColor() {
        this.setBackground(this.backGroundColor);
    }

    public void updateTuiles() {
        this.setTuiles();
    }


}
