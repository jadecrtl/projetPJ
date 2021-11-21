package principal;

import java.util.List;
import java.util.LinkedList;

public class Croisement {
    private int idCroisement;
    List<Tuile> tuilesVoisines;

    public Croisement(int idCroisement) {
        if (idCroisement < 0) {
            throw new IllegalArgumentException("On ne crée pas de croisement avec un id négatif.");
        }
        this.idCroisement = idCroisement;
        tuilesVoisines = new LinkedList<Tuile>();
    }

    public int getIdCroisement() {
        return idCroisement;
    }

    public List<Tuile> getTuilesVoisines() {
        return tuilesVoisines;
    }

}
