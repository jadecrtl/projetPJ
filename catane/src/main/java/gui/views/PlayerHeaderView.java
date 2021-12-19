package gui.views;

import java.awt.*;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayerHeaderView extends JPanel{
    private Font customFont;

    public void setNewFont() {
        try {

            this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Bold.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (Exception e) {

            this.customFont = new Font(Font.SERIF, Font.PLAIN,  10);
        }
       
    }



    public PlayerHeaderView() {

        this.setLayout(new BorderLayout()); // LEVEL 1
        this.setOpaque(false);

        JPanel widerPanel = new JPanel(); // LEVEL 2
        widerPanel.setOpaque(false);

        JPanel header = createHeaderBoxLayout(); // LEVEL 3
        JPanel header2 = createHeaderBoxLayout();
        JPanel header3 = createHeaderBoxLayout();
        JPanel header4 = createHeaderBoxLayout();


        widerPanel.add(header);
        widerPanel.add(header2);
        widerPanel.add(header3);
        widerPanel.add(header4);

        this.add(widerPanel, BorderLayout.WEST);
    }

    public JPanel createHeaderBoxLayout() {
        setNewFont();
        // Larger Panel for margin
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(234, 4, 59));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            }
        };

        panel.setOpaque(false);
        Border blackline = BorderFactory.createLineBorder(Color.black, 2, true);
        panel.setBorder(blackline);

        // Smaller Panel for content;
        JPanel secondPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(secondPanel, BoxLayout.Y_AXIS);
        
        secondPanel.setLayout(boxLayout);
        secondPanel.setOpaque(false);

        // Player Name
        JPanel namePanel = new JPanel();
        namePanel.setOpaque(false);
        namePanel.setLayout(new BorderLayout());

;
        JLabel name = new JLabel("Paris"); // TODO: Method
        name.setForeground(Color.WHITE);
        name.setFont(this.customFont);
        namePanel.add(name, BorderLayout.WEST);

        // Points
        JPanel pointsPanel = new JPanel();
        pointsPanel.setOpaque(false);
        pointsPanel.setLayout(new BorderLayout());

        JLabel points = new JLabel("Points: ");
        points.setFont(this.customFont);
        points.setForeground(Color.BLACK);

        JLabel number = new JLabel("5"); // TODO: Method
        number.setForeground(Color.WHITE);

        number.setFont(this.customFont);

        pointsPanel.add(points, BorderLayout.WEST);
        pointsPanel.add(number);

        // Resources
        JPanel resourcesPanel = new JPanel();
        resourcesPanel.setOpaque(false);
        resourcesPanel.setLayout(new BorderLayout());

        JLabel res = new JLabel("Resources: ");
        res.setFont(this.customFont);
        res.setForeground(Color.BLACK);

        JLabel type = new JLabel("Metal"); // TODO: Method
        type.setForeground(Color.WHITE);
        type.setFont(this.customFont);

        resourcesPanel.add(res, BorderLayout.WEST);
        resourcesPanel.add(type);

        // Color
        JPanel colorPanel = new JPanel();
        colorPanel.setOpaque(false);
        colorPanel.setLayout(new BorderLayout());

        JLabel color = new JLabel("Color: ");
        color.setFont(this.customFont);
        color.setForeground(Color.WHITE);

        JLabel colorType = new JLabel("BLACK"); // TODO: Method
        colorType.setForeground(Color.BLACK);
        colorType.setFont(this.customFont);

        colorPanel.add(color, BorderLayout.WEST);
        colorPanel.add(colorType);

        // Add all to secondPanel (smaller panel)
        secondPanel.add(namePanel);
        secondPanel.add(pointsPanel);
        secondPanel.add(resourcesPanel);
        secondPanel.add(colorPanel);

        panel.add(secondPanel);
        return panel;
    }


    
}
