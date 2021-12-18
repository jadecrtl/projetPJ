package utils;

import java.util.Random;

public class De6Faces {

    private Random rnd;

    public De6Faces() {
        rnd = new Random();
    }

    public Integer getValeurDe() {
        return 1 + rnd.nextInt(6);
    }

}
