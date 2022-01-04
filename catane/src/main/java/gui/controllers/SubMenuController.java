package gui.controllers;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import enums.Production;
import gui.views.AireDeJeuView;
import gui.views.SubMenuView;
import gui.views.TuileView;
import gui.views.Window;

public class SubMenuController {
    SubMenuView subMenuView;
    int counterClick = 0;
        
    public void subMenuButtonPressed(Window window, JButton button, String type, AireDeJeuView aireDeJeuView, int iconWidth, int iconHeight, String path){
        // System.out.println(counterClick);
        counterClick++;
        if (type.equals("DICE")) {
            // System.out.println("Throw dice....");

            if (this.subMenuView != null) {
                int val = subMenuView.getDe().getValeurDe();
                int val2 = subMenuView.getDe().getValeurDe();
                int res = val + val2; 
                // TODO: hen do something in the game... (ask jade)

                //---------------------------------------------------
                if(res == 7 ) {
                    aireDeJeuView.subMenuView.updateActionsForPlayer(Window.joueurs.get(Window.currentPosInList), true, false, false, false);
                    String numberPath = getNumberIconPath(String.valueOf(res));
                    button.setIcon(TuileView.createIcon(numberPath, iconWidth, iconHeight));
                    SubMenuView.sevenDice = true;
                } 
                //---------------------------------------------------

                if(res != 7) {
                    // System.out.println(res);
                    window.currentJeu.assigneRessourceTirageDes(res);
                    window.updatePlayersHeader();
                    aireDeJeuView.subMenuView.updateActionsForPlayer(Window.joueurs.get(Window.currentPosInList), false, false, true, false);
                    String numberPath = getNumberIconPath(String.valueOf(res));
                    button.setIcon(TuileView.createIcon(numberPath, iconWidth, iconHeight));
                }
                
            }
        } else if (type.equals("CANCEL")) {
            // System.out.println("Next Round....");
            if(Window.gameStatus.equals("PREPARE_PARTIE")) {
                Window.currentPosInList++;
                // System.out.println(Window.currentPosInList);
                int[] playerList = Window.numberOfPlayers == 3 ? Window.preparePartiePlayers3 : Window.preparePartiePlayers4;
                window.nextPlayerTurn(playerList);
            }else if(Window.gameStatus.equals("LANCE_PARTIE")) {
                Window.currentPosInList++;
                int[] playerList = Window.numberOfPlayers == 3 ? Window.threePlayersList : Window.fourPlayersList;
                window.nextPlayerTurn(playerList);
            }
        }
    }

    public void acheterChevalierPressed(Window window, SubMenuView subMenu) {
        /**
         * 1. Pegar a window e mostrar uma mensagem dialog perguntando se quer comprar msm
         * 2. Sim, pegar player e comprar carta
         * 3. Atualizar acoes do jogador
         */
        int answer = JOptionPane.showConfirmDialog(
        window,
        "Voudriez-vous acheter la carte chevalier ?",
        "Une question...",
        JOptionPane.YES_NO_OPTION);

        if(answer == 0) {
            // System.out.println("Yes!");
            subMenu.joueurModel.acheteCarteChevalier();
            subMenuView.updateActionsForPlayer(Window.joueurs.get(Window.currentPosInList), false, false, true, false);
        }else {
            // System.out.println("Okay...");
        }
    }

    public void addCityOrVillagePressed(AireDeJeuView aireDeJeuView, String type) {
        // System.out.println("pressed city / village");
        TuileController.settypeOfActionCroisement(type);
        this.subMenuView.robber.setEnabled(false);
        this.subMenuView.route.setEnabled(false);
        this.subMenuView.village.setEnabled(false);
        this.subMenuView.city.setEnabled(false);
        this.subMenuView.b1.setEnabled(false);
        this.subMenuView.b2.setEnabled(false);

        for (TuileView tuile : aireDeJeuView.getTuiles()) {
            tuile.getTopLeft().setEnabled(true);
            tuile.getTopRight().setEnabled(true);
            tuile.getBottomLeft().setEnabled(true);
            tuile.getBottomRight().setEnabled(true);
        }
    }

    public void addRoutePressed(AireDeJeuView aireDeJeuView, String type) {
        // System.out.println("Route added...");
        TuileController.settypeOfActionCroisement(type);

        this.subMenuView.robber.setEnabled(false);
        this.subMenuView.route.setEnabled(false);
        this.subMenuView.village.setEnabled(false);
        this.subMenuView.city.setEnabled(false);
        this.subMenuView.b1.setEnabled(false);
        this.subMenuView.b2.setEnabled(false);

        for (TuileView tuile : aireDeJeuView.getTuiles()) {
            tuile.getTopLeft().setEnabled(true);
            tuile.getTopRight().setEnabled(true);
            tuile.getBottomLeft().setEnabled(true);
            tuile.getBottomRight().setEnabled(true);
        }

    }

    public void addRobberPressed(AireDeJeuView aireDeJeuView) {
        // System.out.println("Robber added...");
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

    public void commerceSansPortPressed(Window window, SubMenuView subMenuView2) {

        Object[] possibilities = subMenuView2.joueurModel.getListCommerceGui().toArray();
        String s = (String)JOptionPane.showInputDialog(
        window,
        "Que voulez-vous echanger ?\n"
        ,"Commerce Sans Port",
        JOptionPane.PLAIN_MESSAGE,
        TuileView.createIcon("catane/src/static/commerce.png", 10, 10),
        possibilities,
        possibilities[0]);

        
        
        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            String[] possibilities2 = {"Bois", "Argile", "Laine", "Ble", "Minerai"};
            String[] filterPossibilites = new String[4];
            int counter = 0;

            for (String str : possibilities2) {
                if(!str.equals(s)){
                    filterPossibilites[counter] = str;
                    counter++;
                }
            }
            String s2 = (String)JOptionPane.showInputDialog(
            window,
            "Contre quoi ? \n"
            ,"Commerce Sans Port",
            JOptionPane.PLAIN_MESSAGE,
            TuileView.createIcon("catane/src/static/commerce.png", 10, 10),
            filterPossibilites,
            filterPossibilites[0]);

            if ((s2 != null) && (s2.length() > 0)) {
                subMenuView2.joueurModel.faireCommerceSansPort(Production.getProductionParLabel(s),Production.getProductionParLabel(s2));
                subMenuView2.updateActionsForPlayer(Window.joueurs.get(Window.currentPosInList), false, false, true, false);
            }

        }
    }
}

