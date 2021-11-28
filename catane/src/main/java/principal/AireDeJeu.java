package principal;

import java.util.LinkedList;
import java.util.List;

import enums.Couleur;
import utils.TerminalCouleur;

public class AireDeJeu {
    public static final int HORIZONTALEMIN = 5;
    public static final int VERTCALEMIN = 3;

    private TerminalCouleur terminal;
    private int horizontale;
    private int verticale;
    private List<Tuile> tuiles;
    private List<Croisement> croisements;
    private Couleur fondAireDeJeu;

    public AireDeJeu(int horizontale, int verticale) {
        if (horizontale < HORIZONTALEMIN && verticale < VERTCALEMIN) {
            throw new IllegalArgumentException("Pas d'aire de jeu trop petite.");
        }
        if ((horizontale % 2 == 1) && (verticale % 2 == 1)) {
            this.horizontale = horizontale;
            this.verticale = verticale;
            tuiles = new LinkedList<Tuile>();
            croisements = new LinkedList<Croisement>();
            remplirTuiles();
            remplirCroisements();
            remplirCroisementsVoisins();
            remplirTuilesVoisines();
            terminal = new TerminalCouleur();
            fondAireDeJeu = Couleur.MAUVE;
        }
        else {
            throw new IllegalArgumentException("L'aire de jeu doit etre de taille impair!!");
        }
    }

    public List<Croisement> getCroisements() {
        return croisements;
    }

    public List<Tuile> getTuiles() {
        return tuiles;
    }

    public int getVerticale() {
        return verticale;
    }

    public int getHorizontale() {
        return horizontale;
    }
    
    private void remplirTuiles() {
        for (int i = 0; i < (this.horizontale * this.verticale); i++) {
            Tuile t = new Tuile(i);
            tuiles.add(t);
        }
    }

    private void remplirCroisements() {
        for (int i = 0; i < ((this.horizontale + 1) * (this.verticale + 1)); i++) {
            Croisement c = new Croisement(i);
            croisements.add(c);
        }
    }

    private void remplirCroisementsVoisins() {
        int ligne = 0;
        int positionSurLigne = -1;
        for (int i = 0; i < this.tuiles.size(); i++) {
            positionSurLigne++;
            this.tuiles.get(i).setCroisementsVoisins(i + ligne);
            this.tuiles.get(i).setCroisementsVoisins(i + ligne + 1);
            this.tuiles.get(i).setCroisementsVoisins(i + ligne + 1 + this.horizontale);
            this.tuiles.get(i).setCroisementsVoisins(i + ligne + 1 + this.horizontale + 1);
            if (positionSurLigne == this.horizontale - 1) {
                ligne++;
                positionSurLigne = -1;
            }
        }
    } 

    private void remplirTuilesVoisines() {
        for (int i = 0; i < this.tuiles.size(); i++) {
            for (int j = 0; j < this.tuiles.get(i).getCroisementsVoisins().size(); j++) {
                //On prend chaques idCroisementVoisins de chaques tuiles et on met chaques tuiles comme voisins de ces croisements
                this.croisements.get(this.tuiles.get(i).getCroisementsVoisins().get(j)).setTuilesVoisines(i);
            }
        }
    }

    public void traceAireDeJeu() {
        int pointDepartCroisement = 0;
        int pointDepartTuile = 0;
        for (int ligne = 0; ligne < ((this.verticale*2)+1); ligne++) {
            if(ligne % 2 == 0) {
                traceLigneDeCroisementsEtRoutesHorizontales(pointDepartCroisement);
                pointDepartCroisement = pointDepartCroisement + horizontale + 1;
            }
            else {
                traceColonneDeRoutesVerticalesEtTuiles(pointDepartTuile);
                pointDepartTuile = pointDepartTuile + horizontale;
            }
        }
    }

    private void traceLigneDeCroisementsEtRoutesHorizontales(int depart) {
        for (int idCroisement = depart; idCroisement < depart + horizontale + 1; idCroisement++) {
            terminal.printInt(fondAireDeJeu.getCrayon(), idCroisement);
            if (idCroisement < depart + horizontale) {
                terminal.print(fondAireDeJeu.getCrayon(), " ---- ");
            }
        }
        terminal.nouvelleLigne();
    }

    private void traceColonneDeRoutesVerticalesEtTuiles(int depart) {
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "|       ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "|   ");
            terminal.printInt(fondAireDeJeu.getCrayon(), idTuile);
            terminal.print(fondAireDeJeu.getCrayon(), "  ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "|       ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();
    }

}
