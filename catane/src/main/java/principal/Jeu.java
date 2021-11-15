package principal;
import java.util.List;

public class Jeu {
    
    private final List<Joueur> joueurs;
    

    public Jeu(List<Joueur> joueurs){
        if (joueurs == null) {
            throw new IllegalArgumentException("On ne joue pas si pas de joueurs!");            
        }
        if (!(joueurs.size() == 3 || joueurs.size() == 4)) {
            throw new IllegalArgumentException("Catan se joue a trois ou quatres joueurs!!!");
        }
        this.joueurs = joueurs;
    }

    public boolean isJeuTermine() {
        int nbJoueurs = joueurs.size();
        for (int i = 0; i < nbJoueurs ; i++) {
            if (joueurs.get(i).getPointVictoire() >= 10) {
                return true;
            }
        }
        return false;
    }

}
