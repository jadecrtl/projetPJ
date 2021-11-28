package principal;

import org.junit.jupiter.api.Test;


public class AireDeJeu04DessineDansConsoleUTest {
    @Test
    public void dessineAireDeJeu() {
        AireDeJeu aire = new AireDeJeu(5, 3);
        aire.traceAireDeJeu();
    }
}
