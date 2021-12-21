package gui.views;

import javax.swing.*;

import gui.controllers.StartGameFormController;

import java.awt.*;
import java.io.File;


public class StartGameFormView extends JPanel{
    JLabel title;
    JRadioButton threePlayers;
    JRadioButton fourPlayers;

    JRadioButton sizeOptionOne;
    JRadioButton sizeOptionTwo;

    JTextField playerOneName;
    JTextField playerTwoName;
    JTextField playerThreeName;
    JTextField playerFourName;

    private StartGameFormController formController = new StartGameFormController();

    // Game Size
    // Number of Players
    // Player Names
    // Start Game
    public StartGameFormView() {
        // This panel config
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlePanel());
        this.add(numberPlayersPanel());
        this.add(gameSizePanel());
        this.add(playerNamesPanel());
        this.add(startButtonPanel());
        this.setBackground(new Color(39, 125, 161));
        // Game Size
    }

    public JPanel titlePanel() {
        JPanel panel = new JPanel();

        this.title = new JLabel("Game Setup");
        this.title.setFont(getNewFont(40));
        this.title.setForeground(Color.WHITE);

        this.title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(this.title, BorderLayout.CENTER);
        panel.setOpaque(false);
        return panel;
    }

    public JPanel numberPlayersPanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Number of Players: ");
        title.setForeground(Color.WHITE);

        title.setFont(getNewFont(25));
        this.threePlayers = new JRadioButton("3 Players");
        this.threePlayers.setFont(getNewFont(20));
        this.threePlayers.setFocusPainted(false); 
        this.threePlayers.setOpaque(false);
        this.threePlayers.setForeground(Color.BLACK);

        this.fourPlayers = new JRadioButton("4 Players");
        this.fourPlayers.setFont(getNewFont(20));
        this.fourPlayers.setFocusPainted(false); 
        this.fourPlayers.setOpaque(false);
        this.fourPlayers.setForeground(Color.BLACK);



        
        ButtonGroup gengp = new ButtonGroup();
        gengp.add(threePlayers);
        gengp.add(fourPlayers);

        panel.add(title);
        panel.add(threePlayers);
        panel.add(fourPlayers);
        panel.setOpaque(false);

        return panel;

    }
    public JPanel gameSizePanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Game Size: ");
        title.setForeground(Color.WHITE);

        title.setFont(getNewFont(25));  
        // Game size
        this.sizeOptionOne = new JRadioButton("5x3 Board");
        this.sizeOptionOne.setFont(getNewFont(20));
        this.sizeOptionOne.setFocusPainted(false); 
        this.sizeOptionOne.setOpaque(false);
        this.sizeOptionOne.setForeground(Color.BLACK);


        this.sizeOptionTwo = new JRadioButton("5x5 Board");
        this.sizeOptionTwo.setFont(getNewFont(20));
        this.sizeOptionTwo.setFocusPainted(false); 
        this.sizeOptionTwo.setOpaque(false);
        this.sizeOptionTwo.setForeground(Color.BLACK);


        
        ButtonGroup gengp = new ButtonGroup();
        gengp.add(sizeOptionOne);
        gengp.add(sizeOptionTwo);

        panel.add(title);
        panel.add(sizeOptionOne);
        panel.add(sizeOptionTwo);
        panel.setOpaque(false);

        return panel;

    }

    public JPanel playerNamesPanel() {
        // Players Name
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Player Names: ");
        title.setFont(getNewFont(25));
        title.setForeground(Color.WHITE);

        this.playerOneName = new JTextField(" Player 1 ");
        this.playerOneName.setFont(getNewFont(20));
        this.playerOneName.setOpaque(false);
        this.playerOneName.setForeground(Color.BLACK);



        this.playerTwoName = new JTextField(" Player 2" );
        this.playerTwoName.setFont(getNewFont(20));
        this.playerTwoName.setOpaque(false);
        this.playerTwoName.setForeground(Color.BLACK);



        this.playerThreeName = new JTextField(" Player 3" );
        this.playerThreeName.setFont(getNewFont(20));
        this.playerThreeName.setOpaque(false);
        this.playerThreeName.setForeground(Color.BLACK);



        this.playerFourName = new JTextField(" Player 4 ");
        this.playerFourName.setFont(getNewFont(20));
        this.playerFourName.setOpaque(false);
        this.playerFourName.setForeground(Color.BLACK);

        panel.add(title);
        panel.add(playerOneName);
        panel.add(playerTwoName);
        panel.add(playerThreeName);
        panel.add(playerFourName);
        panel.setOpaque(false);

        return panel;
    }

    public JPanel startButtonPanel() {
        JButton play = new JButton(TuileView.createIcon("catane/src/static/start.png", 150, 150));
        play.setPreferredSize(new Dimension(155, 155));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFocusPainted(false); 
        play.addMouseListener(formController.new Selection(play, "catane/src/static/start.png"));
        play.addActionListener((event) -> this.formController.playPressed());

        JPanel panel = new JPanel();
        panel.add(play);
        panel.setOpaque(false);

        return panel;
    }
    
    public Font getNewFont(int size) {
        float f = (float)size;
        try {

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Bold.ttf")).deriveFont(f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;

        } catch (Exception e) {

            Font customFont = new Font(Font.SERIF, Font.PLAIN,  10);
            return customFont;
        }
       
    }

}
