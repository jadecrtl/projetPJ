package principal;

import java.util.Random;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;

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
    private List<Route> routesOccupees;
    private Couleur fondAireDeJeu;
    private OptionalLong graine;
    private TirageJeton tirageJeton;

    public AireDeJeu(int horizontale, int verticale, OptionalLong graine) {
        if (horizontale < HORIZONTALEMIN && verticale < VERTCALEMIN) {
            throw new IllegalArgumentException("Pas d'aire de jeu trop petite.");
        }
        if ((horizontale % 2 == 1) && (verticale % 2 == 1)) {
            this.horizontale = horizontale;
            this.verticale = verticale;

            tuiles = new LinkedList<Tuile>();
            croisements = new LinkedList<Croisement>();
            routesOccupees = new LinkedList<Route>();
            remplirTuiles();
            remplirCroisements();

            this.graine = graine;

            tirageJeton = new TirageJeton(graine);
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

    public List<Route> getRoutesOccupees() {
        return routesOccupees;
    }

    public Joueur getRoutesOccupeesParCroisements(int idCroisementA, int idCroisementB) {
        if (routesOccupees.size() == 0) {
            return null;
        }
        for (int i = 0; i < routesOccupees.size(); i++) {
            if (routesOccupees.get(i).getIdCroisementA() == idCroisementA && routesOccupees.get(i).getIdCroisementB() == idCroisementB) {
                return routesOccupees.get(i).getProprietaire();
            }
            if (routesOccupees.get(i).getIdCroisementA() == idCroisementB && routesOccupees.get(i).getIdCroisementB() == idCroisementA) {
                return routesOccupees.get(i).getProprietaire();
            }
        }
        return null;
    }

    public void setRoutesOccupees(List<Route> routesOccupees) {
        this.routesOccupees = routesOccupees;
    }

    public Joueur getProprietaireRoute(Route route) {
        if (routesOccupees.isEmpty()) {
            return null;
        }
        else {
            for (int i = 0; i < routesOccupees.size(); i++) {
                if (routesOccupees.get(i).getIdCroisementA() == route.getIdCroisementA() && routesOccupees.get(i).getIdCroisementB() == route.getIdCroisementB()) {
                    return routesOccupees.get(i).getProprietaire();
                }
            }
            return null;
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
        int numeroLigne = 0;
        for (int ligne = 0; ligne < ((this.verticale*2)+1); ligne++) {
            if(ligne % 2 == 0) {
                traceLigneDeCroisementsEtRoutesHorizontales(pointDepartCroisement);
                pointDepartCroisement = pointDepartCroisement + horizontale + 1;
            }
            else {
                traceColonneDeRoutesVerticalesEtTuiles(pointDepartTuile, numeroLigne);
                pointDepartTuile = pointDepartTuile + horizontale;
                numeroLigne++;
            }
        }
    }

    private void traceLigneDeCroisementsEtRoutesHorizontales(int depart) {
        for (int idCroisement = depart; idCroisement < depart + horizontale + 1; idCroisement++) {
            traceCroisement(idCroisement);
            if (idCroisement < depart + horizontale) {
                traceRouteHorizontale(idCroisement, idCroisement + 1);
            }
        }
        terminal.nouvelleLigne();
    }

    private void traceRouteHorizontale(int idCroisementA, int idCroisementB) {
        Joueur proprietaire = getProprietaireRoute(new Route(idCroisementA, idCroisementB));
        if (proprietaire == null) {
            terminal.print(fondAireDeJeu.getCrayon(), " ------- ");
        }
        else {
            terminal.print(fondAireDeJeu.getCrayon(), " ");
            terminal.print(proprietaire.getCouleur().getStabilo(), "-------");
            terminal.print(fondAireDeJeu.getCrayon(), " ");
        }
    }

    private void traceColonneDeRoutesVerticalesEtTuiles(int depart, int numeroLigne) {

        //premiere ligne de l'affichage des colonnes
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            traceRouteVerticale(idTuile + numeroLigne, idTuile + horizontale + 1 + numeroLigne);
            terminal.print(fondAireDeJeu.getCrayon(), "          ");
            if (idTuile == depart + horizontale - 1) {
                traceRouteVerticale(idTuile + 1 + numeroLigne, idTuile + horizontale + 1 + 1 + numeroLigne);
            }
        }
        terminal.nouvelleLigne();

        //affichage ligne des colonnes et des jetons
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            traceRouteVerticale(idTuile + numeroLigne, idTuile + horizontale + 1 + numeroLigne);
            terminal.print(fondAireDeJeu.getCrayon(), "    ");
            terminal.printInt(tuiles.get(idTuile).getCouleurTuile().getCrayon(), tuiles.get(idTuile).getJeton());
            terminal.print(fondAireDeJeu.getCrayon(), "    ");
            if (idTuile == depart + horizontale - 1) {
                traceRouteVerticale(idTuile + 1 + numeroLigne, idTuile + horizontale + 1 + 1 + numeroLigne);
            }
        }
        terminal.nouvelleLigne();

        //affcihage ligne des colonnes et des terrains
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            traceRouteVerticale(idTuile + numeroLigne, idTuile+ horizontale + 1 + numeroLigne);
            terminal.print(fondAireDeJeu.getCrayon(), " ");
            terminal.print(tuiles.get(idTuile).getCouleurTuile().getCrayon(), tuiles.get(idTuile).getTerrain().getNomTerrain());
            terminal.print(fondAireDeJeu.getCrayon(), " ");
            if (idTuile == depart + horizontale - 1) {
                traceRouteVerticale(idTuile + 1 + numeroLigne, idTuile + horizontale + 1 + 1 + numeroLigne);
            }
        }
        terminal.nouvelleLigne();

        //affichage derniere ligne des colonnes
        for (int idTuile = depart; idTuile < depart + horizontale; idTuile++) {
            traceRouteVerticale(idTuile + numeroLigne, idTuile + horizontale + 1 + numeroLigne);
            terminal.print(fondAireDeJeu.getCrayon(), "          ");
            if (idTuile == depart + horizontale - 1) {
                traceRouteVerticale(idTuile + 1 + numeroLigne, idTuile + horizontale + 1 + 1 + numeroLigne);
            }
        }
        terminal.nouvelleLigne();
    }

    public void traceRouteVerticale(int idCroisementA, int idCroisementB) {
        Joueur proprietaire = getProprietaireRoute(new Route(idCroisementA, idCroisementB));
        //terminal.print(fondAireDeJeu.getCrayon(), idCroisementA + "/" + idCroisementB);
        if (proprietaire == null) {
            terminal.print(fondAireDeJeu.getCrayon(), "|");
        }
        else {
            terminal.print(proprietaire.getCouleur().getStabilo(), "|");
        }
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
        Random r;
        if (graine == null) {
            r = new Random();
        }
        else {
            r = new Random(graine.getAsLong());
        }
        for (int i = 0; i < idTuileMilieu; i++) {
            tuiles.get(i).setTerrain(Terrain.getTerrain(r.nextInt(5)));
            tuiles.get(i).setJeton(tirageJeton.getTirage());
        }
        for (int i = idTuileMilieu + 1; i < horizontale * verticale; i++) {
            tuiles.get(i).setTerrain(Terrain.getTerrain(r.nextInt(5)));
            tuiles.get(i).setJeton(tirageJeton.getTirage());
        }
    }

    public boolean isRouteValide(int idCroisementA, int idCroisementB) {
        if (idCroisementA < 0 || idCroisementB > ((this.horizontale + 1) * (this.verticale + 1))) {
            //System.out.println("Cas 1");
            return false;
        }        
        if (idCroisementA > ((this.horizontale + 1) * (this.verticale + 1))|| idCroisementB < 0) {
            //System.out.println("Cas 2");
            return false;
        }
        if (idCroisementA == idCroisementB) {
            //System.out.println("Cas 3");
            return false;
        }
        if (idCroisementA > idCroisementB) {
            //System.out.println("Cas 4");
            return false;
        }
        //cas ou B n'est pas sur le bord gauche dans le cas d'un segment horizontal
        if (idCroisementB == idCroisementA + 1 && idCroisementB % (horizontale + 1) == 0) {
            //System.out.println("Cas 5");
            return false;
        }
        if (idCroisementB == idCroisementA + 1) {
            //System.out.println("Cas 6");
            return true;
        }
        if (idCroisementB == idCroisementA + horizontale + 1) {
            //System.out.println("Cas 7");
            return true;
        }
        //System.out.println("Cas non encore traite");
        return false;
    }

    public boolean isCroisementValidePourUnJoueur(int idCroisement, Joueur joueur) {
        if (idCroisement < 0) {
            return false;
        }
        if (idCroisement >= getCroisements().size()) {
            return false;
        }
        if (idCroisement == 0 || idCroisement == horizontale || idCroisement == (horizontale + 1) * verticale || idCroisement == (horizontale + 1) * (verticale + 1)) {
            terminal.println(Couleur.VERT.getStabilo(), "Il est interdit de poser une colonie sur les coins.");
            return false;
        }
        if (idCroisement - horizontale - 1 > 0) {
            if (getCroisements().get(idCroisement - horizontale - 1).getProprietaire() == joueur) {
                terminal.println(Couleur.VERT.getStabilo(), "Trop proche d'une de vos colonies");
                return false;
            }
        }
        if (idCroisement + horizontale + 1 < getCroisements().size()) {
            if (getCroisements().get(idCroisement + horizontale + 1).getProprietaire() == joueur) {
                terminal.println(Couleur.VERT.getStabilo(), "Trop proche d'une de vos colonies");
                return false;
            }
        }
        if ((idCroisement + 1) % (horizontale + 1) != 0) {
            if (getCroisements().get(idCroisement + 1).getProprietaire() == joueur) {
                terminal.println(Couleur.VERT.getStabilo(), "Trop proche d'une de vos colonies");
                return false;
            }
        }
        if ((idCroisement) % (horizontale + 1) != 0) {
            if (getCroisements().get(idCroisement - 1).getProprietaire() == joueur) {
                terminal.println(Couleur.VERT.getStabilo(), "Trop proche d'une de vos colonies");
                return false;
            }
        }
        
        if (getRoutesOccupeesParCroisements(idCroisement, idCroisement + 1) == joueur) {
            return true;
        }
        if (getRoutesOccupeesParCroisements(idCroisement - 1, idCroisement) == joueur) {
            return true;
        }
        if (getRoutesOccupeesParCroisements(idCroisement, idCroisement + horizontale + 1) == joueur) {
            return true;
        }
        if (getRoutesOccupeesParCroisements(idCroisement, idCroisement - horizontale - 1) == joueur) {
            return true;
        }
        terminal.println(Couleur.VERT.getStabilo(), "Aucune route n'arrive a cet emplacement");
        return false;
    }

    public List<Tuile> getListeTuileParJeton(int jeton) {
        List<Tuile> res = new LinkedList<>();
        for (int i = 0; i < tuiles.size(); i++) {
            if (tuiles.get(i).getJeton() == jeton) {
                res.add(tuiles.get(i));
            }
        }
        return res;
    }

}
