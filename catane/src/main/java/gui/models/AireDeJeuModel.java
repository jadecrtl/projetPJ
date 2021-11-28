package gui.models;

import javax.swing.*;
import java.awt.*;
/* 
Aire de Jeu model.
*/
public class AireDeJeuModel extends JPanel{
    private int rows;
    private int cols;
    
    public AireDeJeuModel(int x, int y) {
        setCols(y);
        setRows(x);
        GridLayout gameGrid = new GridLayout(getRows(), getCols());
        this.setLayout(gameGrid);
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
