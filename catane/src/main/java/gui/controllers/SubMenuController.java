package gui.controllers;
import java.awt.*;

import java.awt.event.*;
import javax.swing.JButton;

import gui.views.SubMenuView;
import gui.views.TuileView;

public class SubMenuController {
    SubMenuView subMenuView;

    public void subMenuButtonPressed(String type) {
        if (type.equals("DICE")) {
            System.out.println("Throw dice....");
        } else if (type.equals("CANCEL")) {
            System.out.println("Cancel round....");
        }
    }

    public void addCityPressed() {
        System.out.println("City added...");
    }

    public void addVillagePressed() {
        System.out.println("Village added...");
    }

    public void addRoutePressed() {
        System.out.println("Route added...");
    }

    public void addRobberPressed() {
        System.out.println("Robber added...");
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
}