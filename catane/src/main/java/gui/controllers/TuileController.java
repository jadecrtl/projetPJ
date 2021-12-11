package gui.controllers;
import gui.views.TuileView;
import principal.Tuile;

public class TuileController {
    Tuile tuileModel;
    TuileView tuilesView;


    public void setModel(Tuile tuileModel) {
        this.tuileModel = tuileModel;
    }

    public void setView(TuileView tuilesView) {
        this.tuilesView = tuilesView;
    }


}
