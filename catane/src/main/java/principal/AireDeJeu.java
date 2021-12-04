package principal;

import java.util.Random;
import java.util.LinkedList;
import java.util.List;

import enums.Couleur;
import enums.Terrain;
import enums.TypeCroisement;
import utils.TerminalCouleur;
import utils.TirageJeton;

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
            assigneTerrainsEtJetonsAuxTuiles();
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
            traceCroisement(idCroisement);
            if (idCroisement < depart + horizontale) {
                terminal.print(fondAireDeJeu.getCrayon(), " ------- ");
            }
        }
        terminal.nouvelleLigne();
    }

    private void traceColonneDeRoutesVerticalesEtTuiles(int depart) {
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "|          ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();

        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "|    ");
            terminal.printInt(tuiles.get(idTuile).getCouleurTuile().getCrayon(), tuiles.get(idTuile).getJeton());
            terminal.print(fondAireDeJeu.getCrayon(), "    ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();

        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "| ");
            terminal.print(tuiles.get(idTuile).getCouleurTuile().getCrayon(), tuiles.get(idTuile).getTerrain().getNomTerrain());
            terminal.print(fondAireDeJeu.getCrayon(), " ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();

        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            terminal.print(fondAireDeJeu.getCrayon(), "|          ");
            if (idTuile == depart + horizontale - 1) {
                terminal.print(fondAireDeJeu.getCrayon(), "|");
            }
        }
        terminal.nouvelleLigne();
    }

    public void traceCroisement(int idCroisement) {
        if (croisements.get(idCroisement).getProprietaire() == null) {
            terminal.printInt(fondAireDeJeu.getCrayon(), idCroisement);
        }
        else {
            if (croisements.get(idCroisement).getTypeCroisement() == TypeCroisement.COLONIE) {
                terminal.printInt(croisements.get(idCroisement).getProprietaire().getCouleur().getCrayon(), idCroisement);
            }
            else {
                terminal.printInt(croisements.get(idCroisement).getProprietaire().getCouleur().getStabilo(), idCroisement);
            }
        }
    }

    private void assigneTerrainsEtJetonsAuxTuiles() {

        //assignation du desert au milieu
        int idTuileMilieu = ((horizontale * verticale) - 1) / 2;
        tuiles.get(idTuileMilieu).setTerrain(Terrain.DESERT);

        //assignation des tuiles sans assigner celle du milieu
        Random r = new Random();
        for (int i = 0; i < idTuileMilieu; i++) {
            tuiles.get(i).setTerrain(Terrain.getTerrain(r.nextInt(5)));
            tuiles.get(i).setJeton(new TirageJeton().tirage());
        }
        for (int i = idTuileMilieu + 1; i < horizontale * verticale; i++) {
            tuiles.get(i).setTerrain(Terrain.getTerrain(r.nextInt(5)));
            tuiles.get(i).setJeton(new TirageJeton().tirage());
        }
    }

    public boolean isRouteValide(int idCroisementA, int idCroisementB) {
        if (idCroisementA < 0 || idCroisementB > ((this.horizontale + 1) * (this.verticale + 1))) {
            System.out.println("Cas 1");
            return false;
        }        
        if (idCroisementA > ((this.horizontale + 1) * (this.verticale + 1))|| idCroisementB < 0) {
            System.out.println("Cas 2");
            return false;
        }
        if (idCroisementA == idCroisementB) {
            System.out.println("Cas 3");
            return false;
        }
        if (idCroisementA > idCroisementB) {
            System.out.println("Cas 4");
            return false;
        }
        //cas ou B n'est pas sur le bord gauche dans le cas d'un segment horizontal
        if (idCroisementB == idCroisementA + 1 && idCroisementB % (horizontale + 1) == 0) {
            System.out.println("Cas 5");
            return false;
        }
        if (idCroisementB == idCroisementA + 1) {
            System.out.println("Cas 6");
            return true;
        }
        if (idCroisementB == idCroisementA + horizontale + 1) {
            System.out.println("Cas 7");
            return true;
        }
        System.out.println("Cas non encore traite");
        return false;
    }

}
