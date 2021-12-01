package gui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import gui.views.BoardView;
import principal.AireDeJeu;

public class AireDeJeuUTest {
    private final int HEIGHT = 500;
    private final int WIDTH = 500;
    BoardView boardView;

    AireDeJeuUTest() {
        // Creation model principal
        AireDeJeu aireDeJeu = new AireDeJeu(5, 5);
        // Creation vue principal
        this.boardView = new BoardView(WIDTH, HEIGHT, aireDeJeu);
        // Creation controleur principal (pas nécessaire ici encore);

        // Set Main view visible
        this.boardView.setVisible(true);

    }
    @Test
    @DisplayName("AireDeJeuView Test")
    void aireDeJeuViewTest() {
        new AireDeJeuUTest();
    }

    // To visualize use the method below (run main)
    public static void main(String[] args) {
        new AireDeJeuUTest();
    }
}
