package utils;
import java.util.Random;

public class De6Faces {
    private int valeurDe;
    
    public De6Faces() {
        this.lanceDe();
    }

    public int getValeurDe() {
        return this.valeurDe;
    }

    public void lanceDe() {
        Random r = new Random();
        this.valeurDe = 1 + r.nextInt(6);
    }
}
