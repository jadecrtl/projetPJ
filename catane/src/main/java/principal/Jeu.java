package principal;
import java.util.List;

import utils.De6Faces;

public class Jeu {
    
    private final List<Joueur> joueurs;
    private AireDeJeu aire;
    private De6Faces de1;
    private De6Faces de2;
    public static final int VICTOIRE = 10;
    public static final int JOUEURSMIN = 3;
    public static final int JOUEURSMAX = 4;


    public Jeu(List<Joueur> joueurs, int horizontale, int verticale, De6Faces de1, De6Faces de2){
        if (joueurs == null) {
            throw new IllegalArgumentException("On ne joue pas si pas de joueurs!");            
        }
        if (joueurs.size() < JOUEURSMIN || joueurs.size() > JOUEURSMAX) {
            throw new IllegalArgumentException("Catane se joue a trois ou quatres joueurs!!!");
        }
        if (de1 == null || de2 == null) {
            throw new IllegalArgumentException("Catane se joue avec 2 des!!!");
        }
        this.joueurs = joueurs;
        aire = new AireDeJeu(horizontale, verticale);
    }

    public AireDeJeu getAire() {
        return aire;
    }

    public void setAire(AireDeJeu aire) {
        this.aire = aire;
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
