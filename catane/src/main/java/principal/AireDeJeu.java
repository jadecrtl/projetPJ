package principal;

public class AireDeJeu {
    public static final int HORIZONTALEMIN = 5;
    public static final int VERTCALEMIN = 5;

    private int horizontale;
    private int verticale;

    public AireDeJeu(int horizontale, int verticale) {
        if (horizontale < HORIZONTALEMIN && verticale < VERTCALEMIN) {
            throw new IllegalArgumentException("Pas d'aire de jeu trop petite.");
        }
        this.horizontale = horizontale;
        this.verticale = verticale;
    }

    public int getVerticale() {
        return verticale;
    }

    public int getHorizontale() {
        return horizontale;
    }
    


}
