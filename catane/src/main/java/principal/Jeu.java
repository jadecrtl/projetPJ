package principal;
import java.util.List;

public class Jeu {
    
    private final List<Joueur> joueurs;
    public static final int VICTOIRE = 10;
    public static final int JOUEURSMIN = 3;
    public static final int JOUEURSMAX = 4;


    public Jeu(List<Joueur> joueurs){
        if (joueurs == null) {
            throw new IllegalArgumentException("On ne joue pas si pas de joueurs!");            
        }
        if (joueurs.size() < JOUEURSMIN || joueurs.size() > JOUEURSMAX) {
            throw new IllegalArgumentException("Catan se joue a trois ou quatres joueurs!!!");
        }
        this.joueurs = joueurs;
    }

    public boolean isJeuTermine() {
        int nbJoueurs = joueurs.size();
        for (int i = 0; i < nbJoueurs ; i++) {
            if (joueurs.get(i).getPointVictoire() >= VICTOIRE) {
                return true;
            }
        }
        return false;
    }

}
