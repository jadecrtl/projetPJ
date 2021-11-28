package enums;

public enum Terrain {
    FORET(0, " FORET  "),
    COLLINE(1, "COLLINE "),
    PRE(2, "  PRE   "),
    CHAMP(3, " CHAMP  "),
    MONTAGNE(4, "MONTAGNE"),
    DESERT(5, " DESERT ");

    private int rangTerrain;
    private String nomTerrain;

    private Terrain (int rangTerrain, String nomTerrain) {
        this.rangTerrain = rangTerrain;
        this.nomTerrain = nomTerrain;
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public int getRangTerrain() {
        return rangTerrain;
    }

    public static Terrain getTerrain(int rang) {
        if (rang == 0) {
            return FORET;
        }
        if (rang == 1) {
            return COLLINE;
        }
        if (rang == 2) {
            return PRE;
        }
        if (rang == 3) {
            return CHAMP;
        }
        if (rang == 4) {
            return MONTAGNE;
        }
        if (rang == 5) {
            return DESERT;
        }
        return FORET;
    }




}
