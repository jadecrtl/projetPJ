package gui.views;
import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel{
    private BorderLayout layout = new BorderLayout();

    public BoardView() {
        layout.setVgap(10);
        this.setBackground(new Color(39, 125, 161));
        this.setLayout(layout);
    }
}
