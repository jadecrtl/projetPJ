package principal;

import java.util.LinkedList;
import java.util.List;

import enums.Couleur;
import enums.Terrain;

public class Tuile {
    
    private int idTuile;
    private List<Integer> croisementsVoisins;
    private Terrain terrain;

    public Tuile(int idTuile) {
        if (idTuile < 0) {
            throw new IllegalArgumentException("On ne crée pas de tuile avec un id négatif.");
        }
        this.idTuile = idTuile;
        croisementsVoisins = new LinkedList<Integer>();
    }

    public Couleur getCouleurTuile() {
        if (terrain == null) {
            return Couleur.MAUVE;
        }
        if (terrain == Terrain.DESERT) {
            return Couleur.JAUNE;
        }
        else {
            return Couleur.MAUVE;
        }
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public List<Integer> getCroisementsVoisins() {
        return croisementsVoisins;
    }

    public int getIdTuile() {
        return idTuile;
    }

    public void setCroisementsVoisins(int idPoint) {
        this.croisementsVoisins.add(idPoint);
    }

    
    


}
