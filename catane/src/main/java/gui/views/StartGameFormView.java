package gui.views;

import javax.swing.*;

import gui.controllers.StartGameFormController;

import java.awt.*;
import java.io.File;


public class StartGameFormView extends JPanel{
    JLabel title;
    public JRadioButton threePlayers;
    public JRadioButton fourPlayers;

    public JRadioButton sizeOptionOne;
    public JRadioButton sizeOptionTwo;

    public JRadioButton optionOui;
    public JRadioButton optionNon;

    public JTextField playerOneName;
    public JTextField playerTwoName;
    public JTextField playerThreeName;
    public JTextField playerFourName;
    public JTextField playerOneAge;
    
    public JRadioButton typeChoiceOneAi;
    public JRadioButton typeChoiceOneHuman;
    public JRadioButton typeChoiceOneBlue;
    public JRadioButton typeChoiceOneBlanc;
    public JRadioButton typeChoiceOneRouge;
    public JRadioButton typeChoiceOneJaune;



    public JRadioButton typeChoiceTwoAi;
    public JRadioButton typeChoiceTwoHuman;
    public JTextField playerTwoAge;
    public JRadioButton typeChoiceTwoBlue;
    public JRadioButton typeChoiceTwoBlanc;
    public JRadioButton typeChoiceTwoRouge;
    public JRadioButton typeChoiceTwoJaune;

    StartGameFormController formController = new StartGameFormController();

 

    public JTextField playerThreeAge;
    public JRadioButton typeChoiceThreeHuman;
    public JRadioButton typeChoiceThreeAi;
    public JRadioButton typeChoiceThreeBlue;
    public JRadioButton typeChoiceThreeBlanc;
    public JRadioButton typeChoiceThreeRouge;
    public JRadioButton typeChoiceThreeJaune;

    public JTextField playerFourAge;
    public JRadioButton typeChoiceFourAi;
    public JRadioButton typeChoiceFourHuman;
    public JRadioButton typeChoiceFourBlue;
    public JRadioButton typeChoiceFourBlanc;
    public JRadioButton typeChoiceFourRouge;
    public JRadioButton typeChoiceFourJaune;

    Window window;
 

    public StartGameFormView(Window window) {
        // This panel config
        this.window = window;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlePanel());
        this.add(gameAletoirePanel());
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

    public JPanel gameAletoirePanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Jeu Aléatoire?: ");
        title.setForeground(Color.WHITE);

        title.setFont(getNewFont(25));  
        // Game size
        this.optionOui = new JRadioButton("Oui");
        this.optionOui.setFont(getNewFont(20));
        this.optionOui.setFocusPainted(false); 
        this.optionOui.setOpaque(false);
        this.optionOui.setForeground(Color.BLACK);


        this.optionNon = new JRadioButton("Non");
        this.optionNon.setFont(getNewFont(20));
        this.optionNon.setFocusPainted(false); 
        this.optionNon.setOpaque(false);
        this.optionNon.setForeground(Color.BLACK);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(optionOui);
        gengp.add(optionNon);

        panel.add(title);
        panel.add(optionOui);
        panel.add(optionNon);
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
        GridLayout layout = new GridLayout();
        layout.setHgap(5);
        panel.setLayout(layout);
        JLabel title = new JLabel("Players ");
        title.setFont(getNewFont(25));
        title.setForeground(Color.WHITE);

        JPanel playerOneQuestions = playerOneQuestions();
        JPanel playerTwoQuestions = playerTwoQuestions();
        JPanel playerThreeQuestions = playerThreeQuestions();
        JPanel playerFourQuestions = playerFourQuestions();

        // panel.add(title);
        panel.add(playerOneQuestions);
        panel.add(playerTwoQuestions);
        panel.add(playerThreeQuestions);
        panel.add(playerFourQuestions);
        panel.setOpaque(false);

        return panel;
    }

    private JPanel playerOneQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerOneName = new JTextField(" Player 1 ");
        this.playerOneName.setFont(getNewFont(15));
        this.playerOneName.setOpaque(false);
        this.playerOneName.setForeground(Color.BLACK);

        this.playerOneAge = new JTextField("20");
        this.playerOneAge.setFont(getNewFont(15));
        this.playerOneAge.setOpaque(false);
        this.playerOneAge.setForeground(Color.BLACK);


        this.typeChoiceOneAi = new JRadioButton("AI");
        this.typeChoiceOneAi.setFont(getNewFont(15));
        this.typeChoiceOneAi.setFocusPainted(false); 
        this.typeChoiceOneAi.setOpaque(false);
        this.typeChoiceOneAi.setForeground(Color.BLACK);


        this.typeChoiceOneHuman = new JRadioButton("Human");
        this.typeChoiceOneHuman.setFont(getNewFont(15));
        this.typeChoiceOneHuman.setFocusPainted(false); 
        this.typeChoiceOneHuman.setOpaque(false);
        this.typeChoiceOneHuman.setForeground(Color.BLACK);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(typeChoiceOneAi);
        gengp.add(typeChoiceOneHuman);

        JPanel aiHumanPanel = new JPanel();
        aiHumanPanel.setOpaque(false);
        aiHumanPanel.add(typeChoiceOneAi);
        aiHumanPanel.add(typeChoiceOneHuman);


        this.typeChoiceOneBlue = new JRadioButton("BLEU");
        this.typeChoiceOneBlue.setFont(getNewFont(15));
        this.typeChoiceOneBlue.setFocusPainted(false); 
        this.typeChoiceOneBlue.setOpaque(false);
        this.typeChoiceOneBlue.setForeground(Color.BLACK);

        this.typeChoiceOneBlanc = new JRadioButton("BLANC");
        this.typeChoiceOneBlanc.setFont(getNewFont(15));
        this.typeChoiceOneBlanc.setFocusPainted(false); 
        this.typeChoiceOneBlanc.setOpaque(false);
        this.typeChoiceOneBlanc.setForeground(Color.BLACK);

        this.typeChoiceOneRouge = new JRadioButton("ROUGE");
        this.typeChoiceOneRouge.setFont(getNewFont(15));
        this.typeChoiceOneRouge.setFocusPainted(false); 
        this.typeChoiceOneRouge.setOpaque(false);
        this.typeChoiceOneRouge.setForeground(Color.BLACK);

        this.typeChoiceOneJaune = new JRadioButton("JAUNE");
        this.typeChoiceOneJaune.setFont(getNewFont(15));
        this.typeChoiceOneJaune.setFocusPainted(false); 
        this.typeChoiceOneJaune.setOpaque(false);
        this.typeChoiceOneJaune.setForeground(Color.BLACK);

        ButtonGroup gengp2 = new ButtonGroup();
        gengp2.add(typeChoiceOneBlue);
        gengp2.add(typeChoiceOneBlanc);
        gengp2.add(typeChoiceOneRouge);
        gengp2.add(typeChoiceOneJaune);

        JPanel colorPanel = new JPanel();
        colorPanel.setOpaque(false);
        colorPanel.add(typeChoiceOneBlue);
        colorPanel.add(typeChoiceOneBlanc);
        colorPanel.add(typeChoiceOneRouge);
        colorPanel.add(typeChoiceOneJaune);

        playerQuestions.add(this.playerOneName);
        playerQuestions.add(this.playerOneAge);
        playerQuestions.add(aiHumanPanel);
        playerQuestions.add(colorPanel);

        return playerQuestions;
    }
    private JPanel playerTwoQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerTwoName = new JTextField(" Player 2 ");
        this.playerTwoName.setFont(getNewFont(15));
        this.playerTwoName.setOpaque(false);
        this.playerTwoName.setForeground(Color.BLACK);

        this.playerTwoAge = new JTextField("20");
        this.playerTwoAge.setFont(getNewFont(15));
        this.playerTwoAge.setOpaque(false);
        this.playerTwoAge.setForeground(Color.BLACK);


        this.typeChoiceTwoAi = new JRadioButton("AI");
        this.typeChoiceTwoAi.setFont(getNewFont(15));
        this.typeChoiceTwoAi.setFocusPainted(false); 
        this.typeChoiceTwoAi.setOpaque(false);
        this.typeChoiceTwoAi.setForeground(Color.BLACK);


        this.typeChoiceTwoHuman = new JRadioButton("Human");
        this.typeChoiceTwoHuman.setFont(getNewFont(15));
        this.typeChoiceTwoHuman.setFocusPainted(false); 
        this.typeChoiceTwoHuman.setOpaque(false);
        this.typeChoiceTwoHuman.setForeground(Color.BLACK);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(typeChoiceTwoAi);
        gengp.add(typeChoiceTwoHuman);

        JPanel aiHumanPanel = new JPanel();
        aiHumanPanel.setOpaque(false);
        aiHumanPanel.add(typeChoiceTwoAi);
        aiHumanPanel.add(typeChoiceTwoHuman);


        this.typeChoiceTwoBlue = new JRadioButton("BLEU");
        this.typeChoiceTwoBlue.setFont(getNewFont(15));
        this.typeChoiceTwoBlue.setFocusPainted(false); 
        this.typeChoiceTwoBlue.setOpaque(false);
        this.typeChoiceTwoBlue.setForeground(Color.BLACK);

        this.typeChoiceTwoBlanc = new JRadioButton("BLANC");
        this.typeChoiceTwoBlanc.setFont(getNewFont(15));
        this.typeChoiceTwoBlanc.setFocusPainted(false); 
        this.typeChoiceTwoBlanc.setOpaque(false);
        this.typeChoiceTwoBlanc.setForeground(Color.BLACK);

        this.typeChoiceTwoRouge = new JRadioButton("ROUGE");
        this.typeChoiceTwoRouge.setFont(getNewFont(15));
        this.typeChoiceTwoRouge.setFocusPainted(false); 
        this.typeChoiceTwoRouge.setOpaque(false);
        this.typeChoiceTwoRouge.setForeground(Color.BLACK);

        this.typeChoiceTwoJaune = new JRadioButton("JAUNE");
        this.typeChoiceTwoJaune.setFont(getNewFont(15));
        this.typeChoiceTwoJaune.setFocusPainted(false); 
        this.typeChoiceTwoJaune.setOpaque(false);
        this.typeChoiceTwoJaune.setForeground(Color.BLACK);

        ButtonGroup gengp2 = new ButtonGroup();
        gengp2.add(typeChoiceTwoBlue);
        gengp2.add(typeChoiceTwoBlanc);
        gengp2.add(typeChoiceTwoRouge);
        gengp2.add(typeChoiceTwoJaune);

        JPanel colorPanel = new JPanel();
        colorPanel.setOpaque(false);
        colorPanel.add(typeChoiceTwoBlue);
        colorPanel.add(typeChoiceTwoBlanc);
        colorPanel.add(typeChoiceTwoRouge);
        colorPanel.add(typeChoiceTwoJaune);

        playerQuestions.add(this.playerTwoName);
        playerQuestions.add(this.playerTwoAge);
        playerQuestions.add(aiHumanPanel);
        playerQuestions.add(colorPanel);

        return playerQuestions;
    }

    private JPanel playerThreeQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerThreeName = new JTextField(" Player 3 ");
        this.playerThreeName.setFont(getNewFont(15));
        this.playerThreeName.setOpaque(false);
        this.playerThreeName.setForeground(Color.BLACK);

        this.playerThreeAge = new JTextField("20");
        this.playerThreeAge.setFont(getNewFont(15));
        this.playerThreeAge.setOpaque(false);
        this.playerThreeAge.setForeground(Color.BLACK);


        this.typeChoiceThreeAi = new JRadioButton("AI");
        this.typeChoiceThreeAi.setFont(getNewFont(15));
        this.typeChoiceThreeAi.setFocusPainted(false); 
        this.typeChoiceThreeAi.setOpaque(false);
        this.typeChoiceThreeAi.setForeground(Color.BLACK);


        this.typeChoiceThreeHuman = new JRadioButton("Human");
        this.typeChoiceThreeHuman.setFont(getNewFont(15));
        this.typeChoiceThreeHuman.setFocusPainted(false); 
        this.typeChoiceThreeHuman.setOpaque(false);
        this.typeChoiceThreeHuman.setForeground(Color.BLACK);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(typeChoiceThreeAi);
        gengp.add(typeChoiceThreeHuman);

        JPanel aiHumanPanel = new JPanel();
        aiHumanPanel.setOpaque(false);
        aiHumanPanel.add(typeChoiceThreeAi);
        aiHumanPanel.add(typeChoiceThreeHuman);


        this.typeChoiceThreeBlue = new JRadioButton("BLEU");
        this.typeChoiceThreeBlue.setFont(getNewFont(15));
        this.typeChoiceThreeBlue.setFocusPainted(false); 
        this.typeChoiceThreeBlue.setOpaque(false);
        this.typeChoiceThreeBlue.setForeground(Color.BLACK);

        this.typeChoiceThreeBlanc = new JRadioButton("BLANC");
        this.typeChoiceThreeBlanc.setFont(getNewFont(15));
        this.typeChoiceThreeBlanc.setFocusPainted(false); 
        this.typeChoiceThreeBlanc.setOpaque(false);
        this.typeChoiceThreeBlanc.setForeground(Color.BLACK);

        this.typeChoiceThreeRouge = new JRadioButton("ROUGE");
        this.typeChoiceThreeRouge.setFont(getNewFont(15));
        this.typeChoiceThreeRouge.setFocusPainted(false); 
        this.typeChoiceThreeRouge.setOpaque(false);
        this.typeChoiceThreeRouge.setForeground(Color.BLACK);

        this.typeChoiceThreeJaune = new JRadioButton("JAUNE");
        this.typeChoiceThreeJaune.setFont(getNewFont(15));
        this.typeChoiceThreeJaune.setFocusPainted(false); 
        this.typeChoiceThreeJaune.setOpaque(false);
        this.typeChoiceThreeJaune.setForeground(Color.BLACK);

        ButtonGroup gengp2 = new ButtonGroup();
        gengp2.add(typeChoiceThreeBlue);
        gengp2.add(typeChoiceThreeBlanc);
        gengp2.add(typeChoiceThreeRouge);
        gengp2.add(typeChoiceThreeJaune);

        JPanel colorPanel = new JPanel();
        colorPanel.setOpaque(false);
        colorPanel.add(typeChoiceThreeBlue);
        colorPanel.add(typeChoiceThreeBlanc);
        colorPanel.add(typeChoiceThreeRouge);
        colorPanel.add(typeChoiceThreeJaune);

        playerQuestions.add(this.playerThreeName);
        playerQuestions.add(this.playerThreeAge);
        playerQuestions.add(aiHumanPanel);
        playerQuestions.add(colorPanel);

        return playerQuestions;
    }


    private JPanel playerFourQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerFourName = new JTextField(" Player 4 ");
        this.playerFourName.setFont(getNewFont(15));
        this.playerFourName.setOpaque(false);
        this.playerFourName.setForeground(Color.BLACK);

        this.playerFourAge = new JTextField("20");
        this.playerFourAge.setFont(getNewFont(15));
        this.playerFourAge.setOpaque(false);
        this.playerFourAge.setForeground(Color.BLACK);


        this.typeChoiceFourAi = new JRadioButton("AI");
        this.typeChoiceFourAi.setFont(getNewFont(15));
        this.typeChoiceFourAi.setFocusPainted(false); 
        this.typeChoiceFourAi.setOpaque(false);
        this.typeChoiceFourAi.setForeground(Color.BLACK);


        this.typeChoiceFourHuman = new JRadioButton("Human");
        this.typeChoiceFourHuman.setFont(getNewFont(15));
        this.typeChoiceFourHuman.setFocusPainted(false); 
        this.typeChoiceFourHuman.setOpaque(false);
        this.typeChoiceFourHuman.setForeground(Color.BLACK);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(typeChoiceFourAi);
        gengp.add(typeChoiceFourHuman);

        JPanel aiHumanPanel = new JPanel();
        aiHumanPanel.setOpaque(false);
        aiHumanPanel.add(typeChoiceFourAi);
        aiHumanPanel.add(typeChoiceFourHuman);


        this.typeChoiceFourBlue = new JRadioButton("BLEU");
        this.typeChoiceFourBlue.setFont(getNewFont(15));
        this.typeChoiceFourBlue.setFocusPainted(false); 
        this.typeChoiceFourBlue.setOpaque(false);
        this.typeChoiceFourBlue.setForeground(Color.BLACK);

        this.typeChoiceFourBlanc = new JRadioButton("BLANC");
        this.typeChoiceFourBlanc.setFont(getNewFont(15));
        this.typeChoiceFourBlanc.setFocusPainted(false); 
        this.typeChoiceFourBlanc.setOpaque(false);
        this.typeChoiceFourBlanc.setForeground(Color.BLACK);

        this.typeChoiceFourRouge = new JRadioButton("ROUGE");
        this.typeChoiceFourRouge.setFont(getNewFont(15));
        this.typeChoiceFourRouge.setFocusPainted(false); 
        this.typeChoiceFourRouge.setOpaque(false);
        this.typeChoiceFourRouge.setForeground(Color.BLACK);

        this.typeChoiceFourJaune = new JRadioButton("JAUNE");
        this.typeChoiceFourJaune.setFont(getNewFont(15));
        this.typeChoiceFourJaune.setFocusPainted(false); 
        this.typeChoiceFourJaune.setOpaque(false);
        this.typeChoiceFourJaune.setForeground(Color.BLACK);

        ButtonGroup gengp2 = new ButtonGroup();
        gengp2.add(typeChoiceFourBlue);
        gengp2.add(typeChoiceFourBlanc);
        gengp2.add(typeChoiceFourRouge);
        gengp2.add(typeChoiceFourJaune);

        JPanel colorPanel = new JPanel();
        colorPanel.setOpaque(false);
        colorPanel.add(typeChoiceFourBlue);
        colorPanel.add(typeChoiceFourBlanc);
        colorPanel.add(typeChoiceFourRouge);
        colorPanel.add(typeChoiceFourJaune);

        playerQuestions.add(this.playerFourName);
        playerQuestions.add(this.playerFourAge);
        playerQuestions.add(aiHumanPanel);
        playerQuestions.add(colorPanel);

        return playerQuestions;
    }


    public JPanel startButtonPanel() {
        JButton play = new JButton(TuileView.createIcon("catane/src/static/start.png", 150, 150));
        play.setPreferredSize(new Dimension(155, 155));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFocusPainted(false); 
        play.addMouseListener(formController.new Selection(play, "catane/src/static/start.png"));
        play.addActionListener((event) -> this.formController.playPressed(this, this.window));

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
