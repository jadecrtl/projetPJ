package gui.controllers;
import java.awt.event.*;

import javax.swing.JButton;

import gui.views.AireDeJeuView;
import gui.views.SubMenuView;
import gui.views.TuileView;

public class SubMenuController {
    SubMenuView subMenuView;
        
    public void subMenuButtonPressed(JButton button, String type, AireDeJeuView aireDeJeuView, int iconWidth, int iconHeight, String path){
        if (type.equals("DICE")) {
            System.out.println("Throw dice....");

            if (this.subMenuView != null) {
                int val = subMenuView.getDe().getValeurDe();
                int val2 = subMenuView.getDe().getValeurDe();
                int res = val + val2; 
                // TODO: hen do something in the game... (ask jade)
                String numberPath = getNumberIconPath(String.valueOf(res));
                System.out.println(numberPath);
                button.setIcon(TuileView.createIcon(numberPath, iconWidth, iconHeight));
            }
        } else if (type.equals("CANCEL")) {
            System.out.println("Cancel round....");
        }
    }

    public void addCityOrVillagePressed(AireDeJeuView aireDeJeuView, String type) {
        TuileController.settypeOfActionCroisement(type);

        this.subMenuView.robber.setEnabled(false);
        this.subMenuView.route.setEnabled(false);
        this.subMenuView.village.setEnabled(false);
        this.subMenuView.b1.setEnabled(false);
        this.subMenuView.b2.setEnabled(false);

        for (TuileView tuile : aireDeJeuView.getTuiles()) {
            tuile.getTopLeft().setEnabled(true);
            tuile.getTopRight().setEnabled(true);
            tuile.getBottomLeft().setEnabled(true);
            tuile.getBottomRight().setEnabled(true);
        }
    }

    public void addRoutePressed() {
        System.out.println("Route added...");

    }

    public void addRobberPressed(AireDeJeuView aireDeJeuView) {
        System.out.println("Robber added...");
        this.subMenuView.city.setEnabled(false);
        this.subMenuView.route.setEnabled(false);
        this.subMenuView.village.setEnabled(false);
        this.subMenuView.b1.setEnabled(false);
        this.subMenuView.b2.setEnabled(false);

        for (TuileView tuile : aireDeJeuView.getTuiles()) {
            tuile.getTopLeft().setEnabled(false);
            tuile.getTopRight().setEnabled(false);
            tuile.getBottomLeft().setEnabled(false);
            tuile.getBottomRight().setEnabled(false);
            tuile.getJetonButton().setEnabled(true);
        }
    }

    public class Selection extends MouseAdapter {
        JButton jButton;
        int iconWidth;
        int iconHeight;
        String iconPath;

        public Selection(JButton jButton, String path) {
            this.jButton = jButton;
            this.iconPath = path;
        }

        public void mouseEntered(MouseEvent evt) {
            this.iconHeight = jButton.getIcon().getIconWidth();
            this.iconWidth = jButton.getIcon().getIconHeight();
            this.jButton.setIcon(TuileView.createIcon(this.iconPath, 55, 55));

        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setIcon(TuileView.createIcon(this.iconPath, this.iconWidth, this.iconHeight));
        }
    }

    public void setView(SubMenuView subMenuView) {
        this.subMenuView = subMenuView;
    }

    private static String getNumberIconPath(String terrain) {
        String path = "";
        switch (terrain) {
            case ("1"):
                path =  "catane/src/static/1.png";
                break;
            case ("2"):
                path =  "catane/src/static/2.png";
                break;
            case ("3"):
                path =  "catane/src/static/3.png";
                break;

            case ("4"):
                path =  "catane/src/static/4.png";
                break;
            case ("5"):
                path =  "catane/src/static/5.png";
                break;
            case ("6"):
                path =  "catane/src/static/6.png";
                break;
            case ("7"):
                path =  "catane/src/static/7.png";
                break;
            case ("8"):
                path =  "catane/src/static/8.png";
                break;
            case ("9"):
                path =  "catane/src/static/9.png";
                break;
            case ("10"):
                path =  "catane/src/static/10.png";
                break;
            case ("11"):
                path =  "catane/src/static/11.png";
                break;
            case ("12"):
                path =  "catane/src/static/12.png";
                break;
        }
        return path;
    }
}