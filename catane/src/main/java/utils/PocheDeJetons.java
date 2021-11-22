/*

Selon https://ludos.brussels/ludo-cocof/opac_css/doc_num.php?explnum_id=318, j'ai crée la structure
suivante pour la Poche de Jetons. On a

- Total: 18 Jetons
- Distribution (#nbJeton, #nbDisponible): (2, 1); (3, 2); (4, 2); (5, 2); (6, 2); (8, 2); (9, 2); (10, 2); (11, 2); (12, 1)

*/
package utils;
import java.util.HashMap;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class PocheDeJetons {
    private HashMap<String, Integer> jetons = new HashMap<String, Integer>();

    PocheDeJetons() {
        setPocheJetons();
        System.out.println(this.jetons);
    }

    private void setPocheJetons() {
        int quantity = 2;
        IntStream keys = IntStream.range(2, 13);
        PrimitiveIterator.OfInt keyIterator = keys.iterator();
        while(keyIterator.hasNext()) {
            int next = keyIterator.nextInt();
            if (next != 7) {
                if (next != 2 && next != 12) this.jetons.put(Integer.toString(next), quantity);
                else this.jetons.put(Integer.toString(next), 0);
            }
        }
    }

    public String pickJeton() {
        // Todo: Get random jeton (if quantity > 0)
        String jeton = "";
        updateJetonQuantity(jeton);
        return jeton;
    }

    private void updateJetonQuantity(String jeton) {
        // Todo: decrease jeton quantity after picking one. 
    }
}
