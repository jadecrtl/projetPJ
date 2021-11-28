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
        if ((horizontale % 2 == 1) && (verticale % 2 == 1)) {
            this.horizontale = horizontale;
            this.verticale = verticale;
            tuiles = new LinkedList<Tuile>();
            croisements = new LinkedList<Croisement>();
            remplirTuiles();
            remplirCroisements();
            remplirCroisementsVoisins();
            remplirTuilesVoisines();
        }
        else {
            throw new IllegalArgumentException("L'aire de jeu doit etre de taille impair!!");
        }
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

    private void remplirCroisementsVoisins() {
        int ligne = 0;
        int positionSurLigne = -1;
        for (int i = 0; i < this.tuiles.size(); i++) {
            positionSurLigne++;
            this.tuiles.get(i).setCroisementsVoisins(i + ligne);
            this.tuiles.get(i).setCroisementsVoisins(i + ligne + 1);
            this.tuiles.get(i).setCroisementsVoisins(i + ligne + 1 + this.horizontale);
            this.tuiles.get(i).setCroisementsVoisins(i + ligne + 1 + this.horizontale + 1);
            if (positionSurLigne == this.horizontale - 1) {
                ligne++;
                positionSurLigne = -1;
            }
        }
    } 

    private void remplirTuilesVoisines() {
        for (int i = 0; i < this.tuiles.size(); i++) {
            for (int j = 0; j < this.tuiles.get(i).getCroisementsVoisins().size(); j++) {
                //On prend chaques idCroisementVoisins de chaques tuiles et on met chaques tuiles comme voisins de ces croisements
                this.croisements.get(this.tuiles.get(i).getCroisementsVoisins().get(j)).setTuilesVoisines(i);
            }
        }
    }


}
