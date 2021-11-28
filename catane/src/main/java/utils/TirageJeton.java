package utils;

import java.util.Random;

public class TirageJeton {
    //tirage au sort entre 2 et 12 mais si c'est 7 on recommence

    public int tirage() {
        int resultat = 0;
        Random r = new Random();
        resultat = 2 + r.nextInt(10);
        while (resultat == 7) {
            resultat = 2 + r.nextInt(10);            
        }
        return resultat;
    }
}
