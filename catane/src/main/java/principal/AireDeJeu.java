package principal;

import java.util.LinkedList;
import java.util.List;

public class AireDeJeu {
    public static final int HORIZONTALEMIN = 5;
    public static final int VERTCALEMIN = 5;

    private int horizontale;
    private int verticale;
    private List<Tuile> tuiles;
    private List<Croisement> croisements;

    public AireDeJeu(int horizontale, int verticale) {
        if (horizontale < HORIZONTALEMIN && verticale < VERTCALEMIN) {
            throw new IllegalArgumentException("Pas d'aire de jeu trop petite.");
        }
        this.horizontale = horizontale;
        this.verticale = verticale;
        tuiles = new LinkedList<Tuile>();
        croisements = new LinkedList<Croisement>();
        remplirTuiles();
        remplirCroisements();
    }

    public List<Croisement> getCroisements() {
        return croisements;
    }

    public List<Tuile> getTuiles() {
        return tuiles;
    }

    public int getVerticale() {
        return verticale;
    }

    public int getHorizontale() {
        return horizontale;
    }
    
    private void remplirTuiles() {
        for (int i = 0; i < (this.horizontale * this.verticale); i++) {
            Tuile t = new Tuile(i);
            tuiles.add(t);
        }
    }

    private void remplirCroisements() {
        for (int i = 0; i < ((this.horizontale + 1) * (this.verticale + 1)); i++) {
            Croisement c = new Croisement(i);
            croisements.add(c);
        }
    }


}
