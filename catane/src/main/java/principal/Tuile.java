package principal;

public class Tuile {
    
    private int idTuile;

    public Tuile(int idTuile) {
        if (idTuile < 0) {
            throw new IllegalArgumentException("On ne crée pas de tuile avec un id négatif.");
        }
        this.idTuile = idTuile;
    }

    public int getIdTuile() {
        return idTuile;
    }



    


}
