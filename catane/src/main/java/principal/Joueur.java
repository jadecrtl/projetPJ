package principal;

import enums.TypeJoueur;
import utils.Dialogue;
import utils.TerminalCouleur;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ActionMap;

import enums.Action;
import enums.Couleur;
import enums.Production;
import enums.TypeCroisement;

public class Joueur {
    
    private String nom;
    private int age;
    private TypeJoueur typeJoueur;
    private Couleur couleur;
    private int pointVictoire;
    private int inventaireBois;
    private int inventaireArgile;
    private int inventaireLaine;
    private int inventaireBle;
    private int inventaireMinerai;
    private Dialogue dialogue = new Dialogue();
    private TerminalCouleur terminal = new TerminalCouleur();
    private List<Integer> listIdActions = new LinkedList<>();
    
    public Joueur(String nom, int age, TypeJoueur typeJoueur, Couleur couleur) {
        if (nom == null || age == 0 || typeJoueur == null || couleur == null || age < 0) {
            throw new IllegalArgumentException("Erreur lors de la creation du joueur.");
        }
        this.setNom(nom);
        this.setAge(age);
        this.setTypeJoueur(typeJoueur);
        this.setCouleur(couleur);
        this.setPointVictoire(0);
        this.setInventaireBois(0);
        this.setInventaireArgile(0);
        this.setInventaireLaine(0);
        this.setInventaireBle(0);
        this.setInventaireMinerai(0);
    }

    public List<Integer> getListIdActions() {
        return calculeActions();
    }

    public int getInventaireMinerai() {
        return inventaireMinerai;
    }

    private void setInventaireMinerai(int inventaireMinerai) {
        if (this.inventaireMinerai < 0) {
            this.inventaireMinerai = 0;
        } 
        else {
            this.inventaireMinerai = inventaireMinerai;
        }
    }

    public int getInventaireBle() {
        return inventaireBle;
    }

    private void setInventaireBle(int inventaireBle) {
        if (this.inventaireBle < 0) {
            this.inventaireBle = 0;
        }
        else {
            this.inventaireBle = inventaireBle;
        }
    }

    public int getInventaireLaine() {
        return inventaireLaine;
    }

    private void setInventaireLaine(int inventaireLaine) {
        if (this.inventaireLaine < 0) {
            this.inventaireLaine = 0;
        }
        else {
            this.inventaireLaine = inventaireLaine;
        }
    }

    public int getInventaireArgile() {
        return inventaireArgile;
    }

    private void setInventaireArgile(int inventaireArgile) {
        if (this.inventaireArgile < 0) {
            this.inventaireArgile = 0;
        }
        else {
            this.inventaireArgile = inventaireArgile;
        }
    }

    public int getInventaireBois() {
        return inventaireBois;
    }

    private void setInventaireBois(int inventaireBois) {
        if (this.inventaireBois < 0) {
            this.inventaireBois = 0;
        }
        else {
            this.inventaireBois = inventaireBois;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeJoueur getTypeJoueur() {
        return typeJoueur;
    }

    public void setTypeJoueur(TypeJoueur typeJoueur) {
        this.typeJoueur = typeJoueur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public int getPointVictoire() {
        return pointVictoire;
    }

    public void setPointVictoire(int pointVictoire) {
        this.pointVictoire = pointVictoire;
    }

    public void ajouterPointVictoire(int i) {
        this.setPointVictoire(pointVictoire + i);
    }

    public void ajouterRessources(int i, Production production) {
        if (i < 0) {
            throw new IllegalArgumentException("On ne peut pas ajouter en négatif!!");
        }
        else { 
            if (production == Production.BOIS) {
                this.setInventaireBois(getInventaireBois()+i);
            }
            if (production == Production.ARGILE) {
                this.setInventaireArgile(getInventaireArgile()+i);
            }
            if (production == Production.BLE) {
                this.setInventaireBle(getInventaireBle()+i);
            }
            if (production == Production.MINERAI) {
                this.setInventaireMinerai(getInventaireMinerai()+i);
            }      
            if (production == Production.LAINE) {
                this.setInventaireLaine(getInventaireLaine()+i);
            }
        }
    }

    public void enleverRessources(int i, Production production) {
        if (production == Production.BOIS) {
            if (this.getInventaireBois() < i) {
                this.setInventaireBois(0);
            }
            else {
                this.setInventaireBois(getInventaireBois()-i);
            }
        }
        if (production == Production.ARGILE) {
            if (this.getInventaireArgile() < i) {
                this.setInventaireArgile(0);
            }
            else {
                this.setInventaireArgile(getInventaireArgile()-i);
            }
        }        
        if (production == Production.MINERAI) {
            if (this.getInventaireMinerai() < i) {
                this.setInventaireMinerai(0);
            }
            else {
                this.setInventaireMinerai(getInventaireMinerai()-i);
            }
        }        
        if (production == Production.BLE) {
            if (this.getInventaireBle() < i) {
                this.setInventaireBle(0);
            }
            else {
                this.setInventaireBle(getInventaireBle()-i);
            }
        }        
        if (production == Production.LAINE) {
            if (this.getInventaireLaine() < i) {
                this.setInventaireLaine(0);
            }
            else {
                this.setInventaireLaine(getInventaireLaine()-i);
            }
        }        
    }

    public boolean peutAcheterRoute() {
        if (getInventaireBois() > 0 && getInventaireArgile() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutAcheterColonie() {
        if (getInventaireArgile() > 0 && getInventaireBle() > 0 && getInventaireBois() > 0 && getInventaireLaine() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutAcheterVille() {
        if (getInventaireBle() > 1 && getInventaireMinerai() > 2) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutAcheterCarteDev() {
        if (getInventaireBle() > 0 && getInventaireLaine() > 0 && getInventaireMinerai() > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean peutCommerceSansPort() {
        if (getInventaireArgile() > 3 || getInventaireBle() > 3 || getInventaireBois() > 3 || getInventaireLaine() > 3 || getInventaireMinerai() > 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutCommerceAvecPort() {
        if (getInventaireArgile() > 2 || getInventaireBle() > 2 || getInventaireBois() > 2 || getInventaireLaine() > 2 || getInventaireMinerai() > 2) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutCommerceAvecPortSpe(Production production) {
        if (production == Production.BOIS) {
            if (getInventaireBois() > 1) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.BLE) {
            if (getInventaireBle() > 1) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.MINERAI) {
            if (getInventaireMinerai() > 1) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.ARGILE) {
            if (getInventaireArgile() > 1) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.LAINE) {
            if (getInventaireLaine() > 1) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean acheteRoute(AireDeJeu aire, Route route) {
        if (peutAcheterRoute() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas assez de ressources");
            return false;
        }
        if (!aire.isRouteValide(route.getIdCroisementA(), route.getIdCroisementB())) {
            terminal.println(Couleur.VERT.getStabilo(), "La route n'est pas valide");            
            return false;
        }
        if (!(aire.getProprietaireRoute(route) == null)) {
            terminal.println(Couleur.VERT.getStabilo(), "La route est deja occupee");
            return false;
        }
        aire.getRoutesOccupees().add(route);
        this.enleverRessources(1, Production.BOIS);
        this.enleverRessources(1, Production.ARGILE);
        route.setProprietaire(this);
        return true;
    }

    public boolean acheteColonie(AireDeJeu aire , int idCroisement) {
        if (peutAcheterColonie() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas assez de ressources");
            return false;
        }
        if (!aire.isCroisementValidePourUnJoueur(idCroisement, this)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement n'est pas valide");            
            return false;
        }
        if (!(aire.getCroisements().get(idCroisement).getProprietaire() == null)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement est deja occupe");
            return false;
        }
        aire.getCroisements().get(idCroisement).setProprietaire(this, TypeCroisement.COLONIE);
        this.enleverRessources(1, Production.BOIS);
        this.enleverRessources(1, Production.BLE);
        this.enleverRessources(1, Production.ARGILE);
        this.enleverRessources(1, Production.LAINE);
        this.ajouterPointVictoire(1);
        return true;
    }

    public void joue(Jeu jeu) {
        int actionChoisie;
        boolean resultatActions;
        do {
            terminal.effaceEcran();
            jeu.getAire().traceAireDeJeu();
            jeu.afficheInventaireJoueur();
            terminal.println(this.getCouleur().getStabilo(), getNom() + " a vous de jouer");                        
            afficheActions();
            actionChoisie = dialogue.demandeIntPrecis(this.getCouleur().getCrayon(), "Choisissez votre action : ", getListIdActions());
            resultatActions = lanceAction(actionChoisie, jeu);
        } while(resultatActions == false);
    }

    public boolean lanceAction(int actionChoisie, Jeu jeu) {
        if (actionChoisie == Action.PASSE.getIdAction()) {
            return true;
        }
        if (actionChoisie == Action.ROUTE.getIdAction()) {
            lanceAcheteRoute(jeu);
        }
        return false;
    }

    public void choisiRouteGratuite(AireDeJeu aire) {
        int idCroisementA;
        int idCroisementB;
        terminal.println(this.getCouleur().getStabilo(), getNom() + " choisissez une route gratuite");                        
        idCroisementA = dialogue.demandeInt(this.getCouleur().getCrayon(), "Point de depart : ");
        idCroisementB = dialogue.demandeInt(this.getCouleur().getCrayon(), "Point d'arrivee : ");
        if (placeRouteGratuite(aire, idCroisementA, idCroisementB) == true) {
            return;
        }
        else {
            choisiRouteGratuite(aire);
        }
    }

    public boolean placeRouteGratuite(AireDeJeu aire, int idCroisementA, int idCroisementB) {
        this.ajouterRessources(1, Production.BOIS);
        this.ajouterRessources(1, Production.ARGILE);
        Route route = new Route(idCroisementA, idCroisementB);
        if (acheteRoute(aire, route)) {
            return true;
        }
        else {
            this.enleverRessources(1, Production.BOIS);
            this.enleverRessources(1, Production.ARGILE);                
            return false;
        }
    }

    public void choisiColonieGratuite(AireDeJeu aire) {
        int idCroisement;
        idCroisement = dialogue.demandeInt(this.getCouleur().getCrayon(), "choisissez une colonie gratuite : ");
        if (placeColonieGratuite(aire, idCroisement) == true) {
            return;
        }
        else {
            choisiColonieGratuite(aire);
        }
    }

    public boolean placeColonieGratuite(AireDeJeu aire, int idCroisement) {
        this.ajouterRessources(1, Production.BOIS);
        this.ajouterRessources(1, Production.BLE);
        this.ajouterRessources(1, Production.ARGILE);
        this.ajouterRessources(1, Production.LAINE);
        if (acheteColonie(aire, idCroisement)) {
            return true;
        }
        else {
            this.enleverRessources(1, Production.BOIS);
            this.enleverRessources(1, Production.BLE);
            this.enleverRessources(1, Production.ARGILE);
            this.enleverRessources(1, Production.LAINE);
            return false;
        }
    }

    public List<Integer> calculeActions() {
        List<Integer> res = new LinkedList<>();
        res.add(Action.PASSE.getIdAction());//Il faut qu'on puisse passer notre tour quoi qu'il arrive
        if (peutAcheterRoute()) {
            res.add(Action.ROUTE.getIdAction());
        }
        return res;
    }

    public void afficheActions() {
        for (int i = 0; i < getListIdActions().size(); i++) {
            terminal.println(this.getCouleur().getCrayon(), Action.getActionParId(getListIdActions().get(i)).getIdAction() + " " + Action.getActionParId(getListIdActions().get(i)).getLabelAction());
        }
    }

    public void lanceAcheteRoute(Jeu jeu) {
        if (peutAcheterRoute() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            dialogue.appuyerSurEntree();
            return;
        }
        int idCroisementA = dialogue.demandeInt(this.getCouleur().getCrayon(), "Point de depart : ");
        int idCroisementB = dialogue.demandeInt(this.getCouleur().getCrayon(), "Point d'arrivee : ");
        if (idCroisementA > idCroisementB) {
            int tmp = idCroisementA;
            idCroisementA = idCroisementB;
            idCroisementB = tmp;
        }
        Route route = new Route(idCroisementA, idCroisementB);
        if (!jeu.getAire().isRouteValide(route.getIdCroisementA(), route.getIdCroisementB())) {
            terminal.println(Couleur.VERT.getStabilo(), "La route n'est pas valide");            
            dialogue.appuyerSurEntree();
            return;
        }
        if (!(jeu.getAire().getProprietaireRoute(route) == null)) {
            terminal.println(Couleur.VERT.getStabilo(), "La route est deja occupee");
            dialogue.appuyerSurEntree();
            return;
        }
        acheteRoute(jeu.getAire(), route);
    }

}
