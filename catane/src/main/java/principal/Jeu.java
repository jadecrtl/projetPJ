package principal;
import java.util.List;
import java.util.OptionalLong;

import enums.Couleur;
import enums.Production;
import enums.Terrain;
import enums.TypeCroisement;
import utils.AnsiColors;
import utils.De6Faces;
import utils.Dialogue;
import utils.TerminalCouleur;

public class Jeu {
    
    private final List<Joueur> joueurs;
    private AireDeJeu aire;
    private De6Faces de1;
    private De6Faces de2;
    public static final int VICTOIRE = 10;
    public static final int JOUEURSMIN = 3;
    public static final int JOUEURSMAX = 4;
    private TerminalCouleur terminal = new TerminalCouleur();
    private Dialogue dialogue = new Dialogue();

    public Jeu(List<Joueur> joueurs, int horizontale, int verticale, De6Faces de1, De6Faces de2, OptionalLong graine){
        if (joueurs == null) {
            throw new IllegalArgumentException("On ne joue pas si pas de joueurs!");            
        }
        if (joueurs.size() < JOUEURSMIN || joueurs.size() > JOUEURSMAX) {
            throw new IllegalArgumentException("Catane se joue a trois ou quatres joueurs!!!");
        }
        if (de1 == null || de2 == null) {
            throw new IllegalArgumentException("Catane se joue avec 2 des!!!");
        }
        this.joueurs = joueurs;
        aire = new AireDeJeu(horizontale, verticale, graine);
        this.de1 = de1;
        this.de2 = de2;
    }

    public AireDeJeu getAire() {
        return aire;
    }

    public void setAire(AireDeJeu aire) {
        this.aire = aire;
    }

    public int getLancementDes() {
        return de1.getValeurDe() + de2.getValeurDe();
    }

    public Joueur joueurVainqueur() {
        int nbJoueurs = joueurs.size();
        for (int i = 0; i < nbJoueurs ; i++) {
            if (joueurs.get(i).getPointVictoire() >= VICTOIRE) {
                return joueurs.get(i);
            }
        }
        return null;
    }

    public Joueur lancePartie() {
        int joueurActif = 0;
        do {
            terminal.effaceEcran();
            aire.traceAireDeJeu();
            afficheInventaireJoueur();
            int resultatDesDes = getLancementDes();
            terminal.println(joueurs.get(joueurActif).getCouleur().getCrayon(), "Vous avez fait " + resultatDesDes + " aux des");
            dialogue.appuyerSurEntree();
            assigneRessourceTirageDes(resultatDesDes);
            joueurs.get(joueurActif).joue(this);
            joueurActif++;
            if (joueurActif == joueurs.size()) {
                joueurActif = 0;
            }
        } while(joueurVainqueur() == null);
        return joueurVainqueur();
    }

    public void preparePartie() {
        for (int i = 0; i < joueurs.size(); i++) {
            terminal.effaceEcran();
            aire.traceAireDeJeu();
            afficheInventaireJoueur();
            joueurs.get(i).choisiRouteGratuite(aire);
            terminal.effaceEcran();
            aire.traceAireDeJeu();
            afficheInventaireJoueur();
            joueurs.get(i).choisiColonieGratuite(aire);
        }
        for (int i = joueurs.size() - 1; i >= 0; i--) {
            terminal.effaceEcran();
            aire.traceAireDeJeu();
            afficheInventaireJoueur();
            joueurs.get(i).choisiRouteGratuite(aire);
            terminal.effaceEcran();
            aire.traceAireDeJeu();
            afficheInventaireJoueur();
            joueurs.get(i).choisiColonieGratuite(aire);
        }
    }

    public void afficheInventaireJoueur() {
        for (int i = 0; i < joueurs.size(); i++) {
            Joueur j = joueurs.get(i);
            terminal.print(j.getCouleur().getStabilo(), j.getNom() + " " + j.getPointVictoire() + " pts ");
            terminal.print(j.getCouleur().getCrayon(), "/ Bois : " + j.getInventaireBois());
            terminal.print(j.getCouleur().getCrayon(), "/ Argile : " + j.getInventaireArgile());
            terminal.print(j.getCouleur().getCrayon(), "/ Laine : " + j.getInventaireLaine());
            terminal.print(j.getCouleur().getCrayon(), "/ Ble : " + j.getInventaireBle());
            terminal.print(j.getCouleur().getCrayon(), "/ Minerai : " + j.getInventaireMinerai());
            terminal.nouvelleLigne();
        }
    }

    public void assigneRessourceTirageDes(int tirageDe) {
        if (tirageDe == 7) {
            Integer idTuileVoleur = getAire().choisiNouvelleTuileVoleur();
            getAire().deplaceVoleur(idTuileVoleur);
        }
        List<Tuile> listeTuilesTirage = aire.getListeTuileParJeton(tirageDe);
        if (listeTuilesTirage.size() == 0) {
            return;
        }
        for (int i = 0; i < listeTuilesTirage.size(); i++) {
            if (listeTuilesTirage.get(i).isVoleurPresent() == false){
                for (int j = 0; j < 4; j++) {
                    //System.out.println(listeTuilesTirage.get(i).getCroisementsVoisins().get(j));
                    Croisement croisement = aire.getCroisements().get(listeTuilesTirage.get(i).getCroisementsVoisins().get(j)); 
                    if (!(croisement.getProprietaire() == null)) {
                        int nbrRessourcesGagnees = 0;
                        if (croisement.getTypeCroisement() == TypeCroisement.COLONIE) {
                            nbrRessourcesGagnees = 1;
                        }
                        if (croisement.getTypeCroisement() == TypeCroisement.VILLE) {
                            nbrRessourcesGagnees = 2;
                        }
                        if (listeTuilesTirage.get(i).getTerrain() == Terrain.CHAMP) {
                                croisement.getProprietaire().ajouterRessources(nbrRessourcesGagnees, Production.BLE);
                        }
                        if (listeTuilesTirage.get(i).getTerrain() == Terrain.COLLINE) {
                            croisement.getProprietaire().ajouterRessources(nbrRessourcesGagnees, Production.ARGILE);
                        }
                        if (listeTuilesTirage.get(i).getTerrain() == Terrain.FORET) {
                            croisement.getProprietaire().ajouterRessources(nbrRessourcesGagnees, Production.BOIS);
                        }
                        if (listeTuilesTirage.get(i).getTerrain() == Terrain.MONTAGNE) {
                            croisement.getProprietaire().ajouterRessources(nbrRessourcesGagnees, Production.MINERAI);
                        }
                        if (listeTuilesTirage.get(i).getTerrain() == Terrain.PRE) {
                            croisement.getProprietaire().ajouterRessources(nbrRessourcesGagnees, Production.LAINE);
                        }
                    }
                }
            }
        }
    }


}
