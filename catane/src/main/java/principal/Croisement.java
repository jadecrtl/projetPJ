package principal;

public class Croisement {
    private int idCroisement;

    public Croisement(int idCroisement) {
        if (idCroisement < 0) {
            throw new IllegalArgumentException("On ne crée pas de croisement avec un id négatif.");
        }
        this.idCroisement = idCroisement;
    }

    public int getIdCroisement() {
        return idCroisement;
    }

}
