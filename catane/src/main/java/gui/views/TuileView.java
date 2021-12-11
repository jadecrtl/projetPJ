package gui.views;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import gui.controllers.TuileController;
import principal.Tuile;

public class TuileView extends JPanel {

    private Tuile tuileModel;
    private TuileController tuilleController;

    private JLabel jetonLabel = new JLabel();
    private JLabel terrain = new JLabel();

    private JButton topLeftcroisement = new JButton();
    private JButton topRightcroisement = new JButton();
    private JButton bottomLeftcroisement = new JButton();
    private JButton bottomRightcroisement = new JButton();

    private GridLayout tuileLayout = new GridLayout(0, 3);

    private Font customFont;

    
    private void addComponents() {
        
        add(topLeftcroisement);
        add(terrain);
        add(topRightcroisement);

        add(bottomLeftcroisement);
        add(jetonLabel);
        add(bottomRightcroisement);
    }

    private void setCroisements() {

        this.topLeftcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(0))); // topLeft Croisement
        this.topLeftcroisement.setHorizontalAlignment(JLabel.LEFT);
        this.topLeftcroisement.setVerticalAlignment(JLabel.NORTH);
        this.topLeftcroisement.setFont(this.customFont);


        this.topLeftcroisement.addMouseListener(this.tuilleController.new Selection(topLeftcroisement));
        this.topLeftcroisement.addActionListener((event)-> {this.tuilleController.croisementPressed(topLeftcroisement);});
       
        this.topLeftcroisement.setOpaque(false);
        this.topLeftcroisement.setContentAreaFilled(false);
        this.topLeftcroisement.setBorderPainted(false);


        this.topRightcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(1))); // topRight Croisement
        this.topRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
        this.topRightcroisement.setVerticalAlignment(JLabel.NORTH);
        this.topRightcroisement.setFont(this.customFont);


        this.topRightcroisement.addMouseListener(this.tuilleController.new Selection(topRightcroisement));

        this.topRightcroisement.setOpaque(false);
        this.topRightcroisement.setContentAreaFilled(false);
        this.topRightcroisement.setBorderPainted(false);


        this.bottomLeftcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(2)));  // bottomLeft Croisement
        this.bottomLeftcroisement.setHorizontalAlignment(JLabel.LEFT);
        this.bottomLeftcroisement.setVerticalAlignment(JLabel.BOTTOM);
        this.bottomLeftcroisement.setFont(this.customFont);

        this.bottomLeftcroisement.addMouseListener(this.tuilleController.new Selection(bottomLeftcroisement));

        this.bottomLeftcroisement.setOpaque(false);
        this.bottomLeftcroisement.setContentAreaFilled(false);
        this.bottomLeftcroisement.setBorderPainted(false);



        this.bottomRightcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(3))); // bottomRight Croisement
        this.bottomRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
        this.bottomRightcroisement.setVerticalAlignment(JLabel.BOTTOM);
        this.bottomRightcroisement.setFont(this.customFont);


        this.bottomRightcroisement.addMouseListener(this.tuilleController.new Selection(bottomRightcroisement));


        this.bottomRightcroisement.setOpaque(false);
        this.bottomRightcroisement.setContentAreaFilled(false);
        this.bottomRightcroisement.setBorderPainted(false);

    }

    private void setNewFont() {
        try {

            this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Medium.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (Exception e) {

            this.customFont = new Font(Font.SERIF, Font.PLAIN,  10);
        }
       
    }

    private void setTextAndPosition() {
        /*
          Set Jeton and Terain JLabels attributes
        */

        this.jetonLabel.setText(String.valueOf(this.tuileModel.getJeton()));
        this.jetonLabel.setHorizontalAlignment(JLabel.CENTER);
        this.jetonLabel.setFont(this.customFont);
        this.jetonLabel.setForeground(new Color(243, 114, 44));

        try {

            String path = getIconPath(String.valueOf(this.tuileModel.getTerrain()));
            this.terrain.setIcon(createIcon(path, 40, 40));
            this.terrain.setOpaque(false);

        } catch(Exception e) {
            this.terrain.setText(String.valueOf(this.tuileModel.getTerrain()));
            this.terrain.setFont(this.customFont);
        }
        this.terrain.setHorizontalAlignment(JLabel.CENTER);
       

    }

    public void setModel(Tuile tuileModel) {

        this.tuileModel = tuileModel;
        this.setLayout(tuileLayout);

        setNewFont();
        setTextAndPosition();
        setCroisements();
        addComponents();
    }
    
    public void setControleur(TuileController tuilesController) {
        this.tuilleController = tuilesController;
    }

    public Tuile getModel() {
        return this.tuileModel;
    }
    public TuileController getController() {
        return this.tuilleController;
    }
    public Font getCustomFont() {
        return this.customFont;
    }

    public static Icon createIcon(String icon_path, int x, int y) {
        Icon icon = new ImageIcon(icon_path);
        Image image = ((ImageIcon) icon).getImage(); // transform it 
        Image newimg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);  // transform it back
        return icon;
    }

    private static String getIconPath(String terrain) {
        String path = "";
        switch (terrain) {
            case ("FORET"):
                path =  "catane/src/static/forest.png";
                break;
            case ("COLLINE"):
                path =  "catane/src/static/colline.png";
                break;
            case ("PRE"):
                path =  "catane/src/static/pre.png";
                break;

            case ("CHAMP"):
                path =  "catane/src/static/champ.png";
                break;
            case ("DESERT"):
                path =  "catane/src/static/desert.png";
                break;
            case ("MONTAGNE"):
                path =  "catane/src/static/montagne.png";
                break;
        }
        return path;
    }
}
