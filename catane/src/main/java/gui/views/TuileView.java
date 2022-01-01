package gui.views;
import javax.swing.*;
import javax.swing.border.Border;
// import javax.swing.border.EmptyBorder;
// import javax.swing.border.CompoundBorder;
// import javax.swing.border.MatteBorder;
// import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;
// import java.util.List;

import gui.controllers.TuileController;
import gui.controllers.TuileController.Selection;
import gui.controllers.TuileController.Selection2;
import principal.Joueur;
import principal.Route;
import principal.Tuile;

public class TuileView extends JPanel {

    public AireDeJeuView aireDeJeuView;
    private Tuile tuileModel;
    private TuileController tuilleController;

    private JButton jetonLabel = new JButton();
    private JLabel terrain = new JLabel();

    private JButton topLeftcroisement = new JButton();
    private JButton topRightcroisement = new JButton();
    private JButton bottomLeftcroisement = new JButton();
    private JButton bottomRightcroisement = new JButton();

    private GridLayout tuileLayout = new GridLayout(0, 3);
    private Font customFont;

    private JButton[] croisements = {topLeftcroisement, topRightcroisement, bottomLeftcroisement, bottomRightcroisement};

    private int leftBorder;
    private int rightBorder;
    private int bottomBorder;
    private int topBorder;

    private String topColorBorder = "BLACK";
    private String bottomColorBorder = "BLACK";
    private String leftColorBorder = "BLACK";
    private String rightColorBorder = "BLACK";

    static int BORDER_SIZE = 3;

    public void updateJetonView() {
        // Called by controller 
        // Ask this tuile to check if there is robber
        // update icon on jeton according to model 
        // scenario 1 : nothing changed here
        // scenario 2 : now there is robber -> add jeton with robber icon
        // scenario 3 : now there is no longer robber -> add normal jeton

    }


    public void updateCroisementView(String typeOfAction) {
        // Called by controller 
        // Ask this tuile to check if there is a village / city 
        // update icon on croisment according to model 
        // scenario 1 : nothing changed here
        // scenario 2 : now there is croisement -> add croisement with number icon
        // scenario 3 : now there is no longer croisement? -> add normal croisement?

    }
    
    private void addComponents() {
        add(topLeftcroisement);
        add(terrain);
        add(topRightcroisement);

        add(bottomLeftcroisement);
        add(jetonLabel);
        add(bottomRightcroisement);
    }

    private void setCroisements() {
        setTopLeftCroisement();
        setTopRightCroisement();
        setBottomLeftCroisement();
        setBottomRightCroisement();

    }

    private void setBottomRightCroisement() {
        // BOTTOM RIGHT
        this.bottomRightcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(3))); // bottomRight Croisement
        this.bottomRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
        this.bottomRightcroisement.setVerticalAlignment(JLabel.BOTTOM);
        this.bottomRightcroisement.setFont(this.customFont);
        this.bottomRightcroisement.setFocusPainted(false); 

        Selection sel4 = this.tuilleController.new Selection(bottomRightcroisement, bottomRightcroisement.getForeground(), aireDeJeuView);
        this.bottomRightcroisement.addMouseListener(sel4);
        this.bottomRightcroisement.addActionListener((event)-> {this.tuilleController.croisementPressed(bottomRightcroisement, aireDeJeuView, aireDeJeuView.subMenuView, sel4);});


        this.bottomRightcroisement.setOpaque(false);
        this.bottomRightcroisement.setContentAreaFilled(false);
        this.bottomRightcroisement.setBorderPainted(false);


        this.topRightcroisement.setEnabled(false);
        this.topLeftcroisement.setEnabled(false);
        this.bottomLeftcroisement.setEnabled(false);
        this.bottomRightcroisement.setEnabled(false);

        updateIconOnCroisement(this.bottomRightcroisement);
    }



    private void setBottomLeftCroisement() {
        // BOTTOM LEFT
        this.bottomLeftcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(2)));  // bottomLeft Croisement
        this.bottomLeftcroisement.setHorizontalAlignment(JLabel.LEFT);
        this.bottomLeftcroisement.setVerticalAlignment(JLabel.BOTTOM);
        this.bottomLeftcroisement.setFont(this.customFont);
        this.bottomLeftcroisement.setFocusPainted(false); 


        Selection sel3 = this.tuilleController.new Selection(bottomLeftcroisement, bottomLeftcroisement.getForeground(), aireDeJeuView);
        this.bottomLeftcroisement.addMouseListener(sel3);
        this.bottomLeftcroisement.addActionListener((event)-> {this.tuilleController.croisementPressed(bottomLeftcroisement, aireDeJeuView, aireDeJeuView.subMenuView, sel3);});


        this.bottomLeftcroisement.setOpaque(false);
        this.bottomLeftcroisement.setContentAreaFilled(false);
        this.bottomLeftcroisement.setBorderPainted(false);
        updateIconOnCroisement(this.bottomLeftcroisement);

    }



    private void setTopRightCroisement() {
        // TOP RIGHT
        this.topRightcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(1))); // topRight Croisement
        this.topRightcroisement.setHorizontalAlignment(JLabel.RIGHT);
        this.topRightcroisement.setVerticalAlignment(JLabel.NORTH);
        this.topRightcroisement.setFont(this.customFont);
        this.topRightcroisement.setFocusPainted(false); 

        Selection sel2 = this.tuilleController.new Selection(topRightcroisement, topRightcroisement.getForeground(), aireDeJeuView);
        this.topRightcroisement.addMouseListener(sel2);
        this.topRightcroisement.addActionListener((event)-> {this.tuilleController.croisementPressed(topRightcroisement, aireDeJeuView, aireDeJeuView.subMenuView, sel2);});


        this.topRightcroisement.setOpaque(false);
        this.topRightcroisement.setContentAreaFilled(false);
        this.topRightcroisement.setBorderPainted(false);
        updateIconOnCroisement(this.topRightcroisement);

    }



    private void setTopLeftCroisement() {
        // TOP LEFT
        this.topLeftcroisement.setText(String.valueOf(tuileModel.getCroisementsVoisins().get(0))); // topLeft Croisement
        this.topLeftcroisement.setHorizontalAlignment(JLabel.LEFT);
        this.topLeftcroisement.setVerticalAlignment(JLabel.NORTH);
        this.topLeftcroisement.setFont(this.customFont);
        this.topLeftcroisement.setFocusPainted(false); 

        Selection sel = this.tuilleController.new Selection(topLeftcroisement, topLeftcroisement.getForeground(), aireDeJeuView);
        this.topLeftcroisement.addMouseListener(sel);
        this.topLeftcroisement.addActionListener((event)-> {this.tuilleController.croisementPressed(topLeftcroisement, aireDeJeuView, aireDeJeuView.subMenuView, sel);});


        this.topLeftcroisement.setOpaque(false);
        this.topLeftcroisement.setContentAreaFilled(false);
        this.topLeftcroisement.setBorderPainted(false);
        updateIconOnCroisement(this.topLeftcroisement);

    }

    private void updateIconOnCroisement(JButton button) {
        int id = Integer.valueOf(button.getText());
        String type = String.valueOf(aireDeJeuView.getAireDeJeuModel().getCroisements().get(id).getTypeCroisement());
        if (type.equals("COLONIE")) {
            button.setIcon(TuileView.createIcon("catane/src/static/colonie.png", 10, 10));
        }else if (type.equals("VILLE")) {
            button.setIcon(TuileView.createIcon("catane/src/static/city.png", 10, 10));
        }

        Joueur j = aireDeJeuView.getAireDeJeuModel().getCroisements().get(id).getProprietaire();
        if(j!=null) {
            if(!type.equals("null")) {
                String color = String.valueOf(j.getCouleur());
                if(color.equals("BLEU")) {
                    button.setForeground(Color.BLUE);
                }else if (color.equals("BLANC")) {
                    button.setForeground(Color.WHITE);
                }else if (color.equals("ROUGE")) {
                    button.setForeground(Color.RED);
                }else {
                    button.setForeground(Color.YELLOW);
                }
            }
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


        this.jetonLabel.setOpaque(false);
        this.jetonLabel.setContentAreaFilled(false);
        this.jetonLabel.setBorderPainted(false);
        Selection2 jetonListener = this.tuilleController.new Selection2(jetonLabel, jetonLabel.getForeground(), aireDeJeuView);

        this.jetonLabel.addMouseListener(jetonListener);
        this.jetonLabel.addActionListener((event)-> {this.tuilleController.jetonPressed(jetonLabel, this.aireDeJeuView, this.aireDeJeuView.getSub(), jetonListener);});
        this.jetonLabel.setEnabled(false);
        updateJetonIcon(this.jetonLabel);

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

    public void updateJetonIcon(JButton button) {
        if(this.tuileModel.isVoleurPresent()) {
            button.setIcon(TuileView.createIcon("catane/src/static/robber.png", 10, 10));
        }
    }

    public void setAireDeJeu(AireDeJeuView air) {
        this.aireDeJeuView = air;
    }

    public void setControleur(TuileController tuilesController) {
        this.tuilleController = tuilesController;
    }

    public void setModel(Tuile tuileModel) {

        this.tuileModel = tuileModel;
        this.setLayout(tuileLayout);
        // int padding = 5;
		// this.setBorder(new EmptyBorder(padding, 0, 0, 0));
        // this.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
        setNewFont();
        setTextAndPosition();
        setCroisements();
        addComponents();
        drawRoutes();

        Border borderTop = getBorderTop();
        Border borderBottom = getBorderBottom();
        Border borderLeft = getBorderLeft();
        Border borderRight = getBorderRight();

        Border comp1 = BorderFactory.createCompoundBorder(borderTop, borderBottom);
        Border comp2 = BorderFactory.createCompoundBorder(borderLeft, borderRight);

        Border comp3 = BorderFactory.createCompoundBorder(comp1, comp2);

        this.setBorder(comp3);
        // this.setBorder(BorderFactory.createMatteBorder(this.topBorder, this.leftBorder, this.bottomBorder, this.rightBorder, Color.black));
    }

    private Border getBorderTop() {
        System.out.println(this.topColorBorder);
        Border b = BorderFactory.createMatteBorder(this.topBorder, 0, 0, 0, Color.BLACK);
        switch(this.topColorBorder) {
            case "BLUE":
                b = BorderFactory.createMatteBorder(this.topBorder, 0, 0, 0, Color.BLUE);
                break;
            case "YELLOW":
                b = BorderFactory.createMatteBorder(this.topBorder, 0, 0, 0, Color.YELLOW);
                break;
            case "RED":
                b = BorderFactory.createMatteBorder(this.topBorder, 0, 0, 0, Color.RED);
                break;
            case "WHITE":
                b = BorderFactory.createMatteBorder(this.topBorder, 0, 0, 0, Color.WHITE);
                break;
        }
        return b; 
    }

    private Border getBorderBottom() {
        System.out.println(this.bottomColorBorder);
        Border b = BorderFactory.createMatteBorder(0, 0, this.bottomBorder, 0, Color.BLACK);
        switch(this.bottomColorBorder) {
            case "BLUE":
                b = BorderFactory.createMatteBorder(0, 0, this.bottomBorder, 0, Color.BLUE);
                break;
            case "YELLOW":
                b = BorderFactory.createMatteBorder(0, 0, this.bottomBorder, 0, Color.YELLOW);
                break;
            case "RED":
                b = BorderFactory.createMatteBorder(0, 0, this.bottomBorder, 0, Color.RED);
                break;
            case "WHITE":
                b = BorderFactory.createMatteBorder(0, 0, this.bottomBorder, 0, Color.WHITE);
                break;
        }
        return b; 
    }
    
    private Border getBorderLeft() {
        System.out.println(this.leftColorBorder);
        Border b = BorderFactory.createMatteBorder(0, this.leftBorder, 0, 0, Color.BLACK);
        switch(this.leftColorBorder) {
            case "BLUE":
                b = BorderFactory.createMatteBorder(0, this.leftBorder, 0, 0, Color.BLUE);
                break;
            case "YELLOW":
                b = BorderFactory.createMatteBorder(0, this.leftBorder, 0, 0, Color.YELLOW);
                break;
            case "RED":
                b = BorderFactory.createMatteBorder(0, this.leftBorder, 0, 0, Color.RED);
                break;
            case "WHITE":
                b = BorderFactory.createMatteBorder(0, this.leftBorder, 0, 0, Color.WHITE);
                break;
        }
        return b;
    }

    private Border getBorderRight() {
        System.out.println(this.rightColorBorder);
        Border b = BorderFactory.createMatteBorder(0, 0, 0, this.rightBorder, Color.BLACK);
        switch(this.rightColorBorder) {
            case "BLUE":
                b = BorderFactory.createMatteBorder(0, 0, 0, this.rightBorder, Color.BLUE);
                break;
            case "YELLOW":
                b = BorderFactory.createMatteBorder(0, 0, 0, this.rightBorder, Color.YELLOW);
                break;
            case "RED":
                b = BorderFactory.createMatteBorder(0, 0, 0, this.rightBorder, Color.RED);
                break;
            case "WHITE":
                b = BorderFactory.createMatteBorder(0, 0, 0, this.rightBorder, Color.WHITE);
                break;
        }
        return b;
    }

    public void drawRoutes() {
        for (Route r : this.aireDeJeuView.getAireDeJeuModel().getRoutesOccupees()) {
            String a = String.valueOf(r.getIdCroisementA());
            String b = String.valueOf(r.getIdCroisementB());
            if(isIn(a) && isIn(b)){

                System.out.println("a: "+a);
                System.out.println("b: "+b);
                System.out.print("Croisements-> BL:"+this.bottomLeftcroisement.getText());
                System.out.print(" BR:"+this.bottomRightcroisement.getText());
                System.out.print(" TL:"+this.topLeftcroisement.getText());
                System.out.println(" TR:"+this.topRightcroisement.getText());

                checkCase1Route(a, b);
                checkCase2Route(a, b);
                checkCase3Route(a, b);
                checkCase4Route(a, b);
            }
        }
    }

    private void checkCase4Route(String a, String b) {
        /**
         * bottom left - bottom right
         * Scenario 1: a == bottom left and b == bottom right
         * Scenario 2: a == bottom right and a == bottom left
         */
        if(a.equals(this.bottomLeftcroisement.getText()) && b.equals(this.bottomRightcroisement.getText())) {
            System.out.println("CASE 4");
            this.bottomBorder = BORDER_SIZE;
        }else if(a.equals(this.bottomRightcroisement.getText()) && b.equals(this.bottomLeftcroisement.getText())) {
            System.out.println("CASE 4");
            this.bottomBorder = BORDER_SIZE;
        }

        this.bottomColorBorder = setBorderColor(this.bottomLeftcroisement.getText(), this.bottomRightcroisement.getText());
    }



    private void checkCase3Route(String a, String b) {
        /**
         * top right - bottom right
         * Scenario 1: a == top right and b == bottom right;
         * Scenario 2: a == bottom right and b == top right;
         */
        if(a.equals(this.topRightcroisement.getText()) && b.equals(this.bottomRightcroisement.getText())) {
            System.out.println("CASE 3");
            this.rightBorder = BORDER_SIZE;
        } else if (a.equals(this.bottomRightcroisement.getText()) && b.equals(this.topRightcroisement.getText())) {
            System.out.println("CASE 3");
            this.rightBorder = BORDER_SIZE;   
        }

        this.rightColorBorder = setBorderColor(this.topRightcroisement.getText(), this.bottomRightcroisement.getText());

    }


    private void checkCase2Route(String a, String b) {
        /**
         * top left - bottom left
         * Scenario 1: a == top left and b == bottom left
         * Scenario 2: a == bottom left and b == top left
         */
        if(a.equals(this.topLeftcroisement.getText()) && b.equals(this.bottomLeftcroisement.getText())){
            System.out.println("CASE 2");
            this.leftBorder = BORDER_SIZE;
        }else if(a.equals(this.bottomLeftcroisement.getText()) && b.equals(this.topLeftcroisement.getText())) {
            System.out.println("CASE 2");
            this.leftBorder = BORDER_SIZE;
        }

        this.leftColorBorder = setBorderColor(this.topLeftcroisement.getText(), this.bottomLeftcroisement.getText());

    }


    private void checkCase1Route(String a, String b) {
        /**
         * top left - top right
         * Scenario 1: a == top left and b == top right
         * Scenario 2: a == top right and b == top left
         */

        if(a.equals(this.topLeftcroisement.getText()) && b.equals(this.topRightcroisement.getText())) {
            System.out.println("CASE 1");
            this.topBorder = BORDER_SIZE;
        }else if(a.equals(this.topRightcroisement.getText()) && b.equals(this.topLeftcroisement.getText())) {
            System.out.println("CASE 1");
            this.topBorder = BORDER_SIZE;
        }

        this.topColorBorder = setBorderColor(this.topLeftcroisement.getText(), this.topRightcroisement.getText());
    }


    private String setBorderColor(String a, String b) {
        Joueur j = this.aireDeJeuView.getAireDeJeuModel().getRoutesOccupeesParCroisements(Integer.valueOf(a), Integer.valueOf(b));
        if(j!=null) { 
            String color = String.valueOf(j.getCouleur());
            if(color.equals("BLEU")) {
                return "BLUE";
            }else if (color.equals("BLANC")) {
                return "WHITE";
            }else if (color.equals("ROUGE")) {
                return "RED";
            }else {
                return "YELLOW";
            }
        }
        return "BLACK";
    }


    private boolean isIn(String id) {
        for (JButton jb : this.croisements) {
            if(id.equals(jb.getText())){
                return true;
            }
        }
        return false;
    }
    

    public void setNewFont() {
        try {

            this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File("catane/src/static/Poppins-Medium.ttf")).deriveFont(13f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (Exception e) {

            this.customFont = new Font(Font.SERIF, Font.PLAIN,  10);
        }
       
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


    public JButton getTopLeft() {
        return this.topLeftcroisement;
    }
    public JButton getTopRight() {
        return this.topRightcroisement;
    }
    public JButton getBottomLeft() {
        return this.bottomLeftcroisement;
    }
    public JButton getBottomRight() {
        return this.bottomRightcroisement;
    }
    public JButton getJetonButton() {
        return this.jetonLabel;
    }
    public AireDeJeuView getAir() {
        return this.aireDeJeuView;
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
    
}
