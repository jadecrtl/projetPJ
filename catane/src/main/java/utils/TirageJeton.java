package utils;

import java.util.OptionalLong;
import java.util.Random;

public class TirageJeton {
    //tirage au sort entre 2 et 12 mais si c'est 7 on recommence

    private OptionalLong graine;
    private Random r;

    public TirageJeton(OptionalLong graine) {
        this.graine = graine;
        if (graine == null) {
            r = new Random();
        }
        else {
            r = new Random(graine.getAsLong());
        }
    }

    public int getTirage() {
        return tirage(graine);
    }

    public int tirage(OptionalLong graine) {
        int resultat = 0;
        resultat = 2 + r.nextInt(10);
        while (resultat == 7) {
            resultat = 2 + r.nextInt(10);            
        }
        return resultat;
    }
}
