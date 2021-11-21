package principal;

import java.util.LinkedList;
import java.util.List;

public class Tuile {
    
    private int idTuile;
    private List<Croisement> croisementsVoisins;

    public Tuile(int idTuile) {
        if (idTuile < 0) {
            throw new IllegalArgumentException("On ne crée pas de tuile avec un id négatif.");
        }
        this.idTuile = idTuile;
        croisementsVoisins = new LinkedList<Croisement>();
    }

    public List<Croisement> getCroisementsVoisins() {
        return croisementsVoisins;
    }

    public int getIdTuile() {
        return idTuile;
    }

    


    


}
