package gui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import gui.views.Window;

public class BoardUTest {
    BoardUTest() {
        new Window();
    }

    @Test
    @DisplayName("BoardView Test")
    void boardViewTest() {
        new BoardUTest();
    }

    // To visualize use the method below (run main)
    public static void main(String[] args) {
        new BoardUTest();
    }
}
