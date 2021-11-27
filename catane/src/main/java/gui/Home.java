package gui;
import javax.swing.*;

public class Home {

    public static void main(String[] args) {
        new Home();
    }

    public Home() {
        JFrame frame = new JFrame("Catane");
        JLabel label = new JLabel("Hello World!");
        frame.add(label);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    
}
