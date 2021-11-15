package principal;
import java.util.List;

public class Jeu {
    
    private boolean jeuTermine = false;

    public Jeu(List<Joueur> joueurs){
        if (joueurs == null) {
            throw new IllegalArgumentException("On ne joue pas si pas de joueurs!");            
        }
        if (!(joueurs.size() == 3 || joueurs.size() == 4)) {
            throw new IllegalArgumentException("Catan se joue a trois ou quatres joueurs!!!");
        }
    }

    public boolean getJeuTermine() {
        return this.jeuTermine;
    }

    public void setJeuTermine(boolean jeuTermine) {
        this.jeuTermine = jeuTermine;
    }


}
