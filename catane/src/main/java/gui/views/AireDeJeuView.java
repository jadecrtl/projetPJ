package gui.views;
import gui.controllers.*;
import principal.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;


public class AireDeJeuView extends JPanel{
    private AireDeJeu aireDeJeuModel;
    private AireDeJeuController aireDeJeuController;
    private GridLayout aireDeJeuGrid;
    private final int HORIZONTAL_GAP = 10;
    private final int VERTICAL_GAP = 10;
    private List<JPanel> tuiles = new ArrayList<JPanel>();
    private Color backGroundColor = new Color(144, 190, 109);

    public void setTuiles() {
        setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        for (int i =0; i<this.aireDeJeuModel.getTuiles().size(); i++){

            TuileView tuileView = new TuileView();
            TuileController tuileController = new TuileController();

            tuileView.setControleur(tuileController);
            tuileView.setModel(this.aireDeJeuModel.getTuiles().get(i));

            // Example of possible use of borders : 
            if (this.aireDeJeuModel.getTuiles().get(i).getIdTuile()==13){
                tuileView.setBorder(BorderFactory.createMatteBorder(0, 40, 0, 0, TuileView.createIcon("catane/src/static/house.png", 40, 40)));
            }

            tuileController.setView(tuileView);
            tuileController.setModel(this.aireDeJeuModel.getTuiles().get(i));

            this.tuiles.add(tuileView);
            add(tuileView);
            
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
