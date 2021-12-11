package gui.controllers;

import gui.views.AireDeJeuView;
import principal.*;


public class AireDeJeuController {
    AireDeJeu aireDeJeuModel;
    AireDeJeuView aireDeJeuView;

    // public void updateTuiles() {
    //     this.aireDeJeuView.updateTuiles();
    // }

    
    // public void updateJetons() {
    //   ...
    // }

    public void setModel(AireDeJeu aireDeJeuModel) {
        this.aireDeJeuModel = aireDeJeuModel;
    }

    public void setView(AireDeJeuView aireDeJeuView) {
        this.aireDeJeuView = aireDeJeuView;
    }
}
