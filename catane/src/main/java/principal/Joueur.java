package principal;

import enums.TypeJoueur;
import utils.Dialogue;
import utils.TerminalCouleur;

import java.util.LinkedList;
import java.util.List;

import enums.Action;
import enums.Couleur;
import enums.Production;
import enums.TypeCroisement;

public class Joueur {
    
    private String nom;
    private TypeJoueur typeJoueur;
    private Couleur couleur;
    private int pointVictoire;
    private int inventaireBois;
    private int inventaireArgile;
    private int inventaireLaine;
    private int inventaireBle;
    private int inventaireMinerai;
    private int inventaireChevalier;
    private Dialogue dialogue = new Dialogue();
    private TerminalCouleur terminal = new TerminalCouleur();

    public Joueur(String nom, TypeJoueur typeJoueur, Couleur couleur) {
        if (nom == null || typeJoueur == null || couleur == null) {
            throw new IllegalArgumentException("Erreur lors de la creation du joueur.");
        }
        this.setNom(nom);
        this.setTypeJoueur(typeJoueur);
        this.setCouleur(couleur);
        this.setPointVictoire(0);
        this.setInventaireBois(0);
        this.setInventaireArgile(0);
        this.setInventaireLaine(0);
        this.setInventaireBle(0);
        this.setInventaireMinerai(0);
        this.setInventaireChevalier(0);
    }

    public int getInventaireChevalier() {
        return inventaireChevalier;
    }

    public void setInventaireChevalier(int inventaireChevalier) {
        if (this.inventaireChevalier < 0) {
            this.inventaireChevalier = 0;
        } 
        else {
            this.inventaireChevalier = inventaireChevalier;
        }
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

 
    public List<Integer> getListIdActions() {
        List<Integer> res = new LinkedList<>();
        res.add(Action.PASSE.getIdAction());//Il faut qu'on puisse passer notre tour quoi qu'il arrive
        if (peutAcheterRoute()) {
            res.add(Action.ROUTE.getIdAction());
        }
        if (peutAcheterColonie()) {
            res.add(Action.COLONIE.getIdAction());
        }
        if (peutAcheterVille()) {
            res.add(Action.VILLE.getIdAction());
        }
        if (peutCommerceSansPort()) {
            res.add(Action.COMMERCESANSPORT.getIdAction());
        }
        if (peutAcheterCarteChevalier()) {
            res.add(Action.CARTECHEVALIER.getIdAction());
        }
        if (peutUtiliserCarteChevalier()) {
            res.add(Action.UTILISERCARTECHEVALIER.getIdAction());
        }
        return res;
    }

    public List<Integer> getListCommerce() {
        List<Integer> res = new LinkedList<>();
        if (getInventaireArgile() >= 4) {
            res.add(Production.ARGILE.getIdProduction());
        }
        if (getInventaireBle() >= 4) {
            res.add(Production.BLE.getIdProduction());
        }
        if (getInventaireBois() >= 4) {
            res.add(Production.BOIS.getIdProduction());
        }
        if (getInventaireLaine() >= 4) {
            res.add(Production.LAINE.getIdProduction());
        }
        if (getInventaireMinerai() >= 4) {
            res.add(Production.MINERAI.getIdProduction());
        }
        res.add(Production.RIEN.getIdProduction());//On peut selectionner rien pour pouvoir annuler la transaction
        return res;
    }

 
    public void ajouterPointVictoire(int i) {
        this.setPointVictoire(pointVictoire + i);
    }

    public void ajouterCarteChevalier(int i) {
        this.setInventaireChevalier(getInventaireChevalier() + i);
    }

    public void enleverCarteChevalier(int i) {
        if (this.getInventaireChevalier() < i) {
            this.setInventaireBois(0);
        }
        else {
            this.setInventaireChevalier(getInventaireChevalier()-i);
        }
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

    public boolean peutAcheterCarteChevalier() {
        if (getInventaireBle() > 0 && getInventaireLaine() > 0 && getInventaireMinerai() > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean peutUtiliserCarteChevalier(){
        if (getInventaireChevalier() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutCommerceSansPort() {
        if (getInventaireArgile() >= 4 || getInventaireBle() >= 4 || getInventaireBois() >= 4 || getInventaireLaine() >= 4 || getInventaireMinerai() >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutCommerceAvecPort() {
        if (getInventaireArgile() >= 3 || getInventaireBle() >= 3 || getInventaireBois() >= 3 || getInventaireLaine() >= 3 || getInventaireMinerai() >= 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutCommerceAvecPortSpe(Production production) {
        if (production == Production.BOIS) {
            if (getInventaireBois() >= 2) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.BLE) {
            if (getInventaireBle() >= 2) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.MINERAI) {
            if (getInventaireMinerai() >= 2) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.ARGILE) {
            if (getInventaireArgile() >= 2) {
                return true;
            }
            else {
                return false;
            }
        }
        if (production == Production.LAINE) {
            if (getInventaireLaine() >= 2) {
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

    public boolean acheteVille(AireDeJeu aire, int idCroisement) {
        if (peutAcheterVille() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas assez de ressources");
            return false;
        }
        if (aire.getCroisements().get(idCroisement).getProprietaire() == null) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas de colonie sur cet emplacement");
            return false;
        }
        if (aire.getCroisements().get(idCroisement).getProprietaire() != this) {
            terminal.println(Couleur.VERT.getStabilo(), "Cet colonie ne vous appartient pas");
        }
        if (aire.getCroisements().get(idCroisement).getTypeCroisement() == TypeCroisement.VILLE) {
            terminal.println(Couleur.VERT.getStabilo(), "Une ville est deja sur cet emplacement");
        }
        aire.getCroisements().get(idCroisement).setTypeCroisement(TypeCroisement.VILLE);
        this.enleverRessources(3, Production.MINERAI);
        this.enleverRessources(2, Production.BLE);
        this.ajouterPointVictoire(1);
        return true;
    }

    public boolean acheteCarteChevalier() {
        if (peutAcheterCarteChevalier() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas assez de ressources");
            return false;
        }
        this.ajouterCarteChevalier(1);
        this.enleverRessources(1, Production.BLE);
        this.enleverRessources(1, Production.LAINE);        
        this.enleverRessources(1, Production.MINERAI);
        return true;
    }

    public boolean utiliserCarteChevalier(Jeu jeu){
        if (peutUtiliserCarteChevalier() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas de carte chevalier");
            return false;
        }
        Integer nouvelleIdTuileVoleur = jeu.getAire().choisiNouvelleTuileVoleur();
        faireCarteChevalier(jeu, nouvelleIdTuileVoleur);
        return true;
    }
    
    public void faireCarteChevalier(Jeu jeu, int idTuile) {        
        jeu.getAire().deplaceVoleur(idTuile);
        this.enleverCarteChevalier(1);
    }

    public boolean utiliserCarteChevalierGui(Integer nouvelleIdTuileVoleur, AireDeJeu air){
        if (peutUtiliserCarteChevalier() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas de carte chevalier");
            return false;
        }
        faireCarteChevalierGui(air, nouvelleIdTuileVoleur);
        return true;
    }
    
    public void faireCarteChevalierGui(AireDeJeu air, int idTuile) {        
        air.deplaceVoleur(idTuile);
        this.enleverCarteChevalier(1);
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
        if (actionChoisie == Action.COLONIE.getIdAction()) {
            lanceAcheteColonie(jeu);
        }
        if (actionChoisie == Action.VILLE.getIdAction()) {
            lanceAcheteVille(jeu);
        }
        if (actionChoisie == Action.COMMERCESANSPORT.getIdAction()) {
            lanceCommerceSansPort(jeu);
        }
        if (actionChoisie == Action.CARTECHEVALIER.getIdAction()) {
            lanceAcheteCarteChevalier(jeu);
        }
        if (actionChoisie == Action.UTILISERCARTECHEVALIER.getIdAction()) {
            lanceUtiliserCarteChevalier(jeu);
        }
        return false;
    }
  
    public void afficheActions() {
        for (int i = 0; i < getListIdActions().size(); i++) {
            terminal.println(this.getCouleur().getCrayon(), Action.getActionParId(getListIdActions().get(i)).getIdAction() + " " + Action.getActionParId(getListIdActions().get(i)).getLabelAction());
        }
    }

    public void afficheProduction(List<Integer> productionsAAfficher) {
        for (int i = 0; i < productionsAAfficher.size(); i++) {
            terminal.println(this.getCouleur().getCrayon(), Production.getProductionParId(productionsAAfficher.get(i)).getIdProduction() + " " + Production.getProductionParId(productionsAAfficher.get(i)).getLabelProduction());
        }
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


    public boolean lanceAcheteRouteGui(AireDeJeu air, int idCroisementA, int idCroisementB) {
        if (peutAcheterRoute() == false) {
            // terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            // dialogue.appuyerSurEntree();
            return false;
        }
        // int idCroisementA = dialogue.demandeInt(this.getCouleur().getCrayon(), "Point de depart : ");
        // int idCroisementB = dialogue.demandeInt(this.getCouleur().getCrayon(), "Point d'arrivee : ");
        if (idCroisementA > idCroisementB) {
            int tmp = idCroisementA;
            idCroisementA = idCroisementB;
            idCroisementB = tmp;
        }
        Route route = new Route(idCroisementA, idCroisementB);
        if (!air.isRouteValide(route.getIdCroisementA(), route.getIdCroisementB())) {
            // terminal.println(Couleur.VERT.getStabilo(), "La route n'est pas valide");            
            // dialogue.appuyerSurEntree();
            return false;
        }
        if (!(air.getProprietaireRoute(route) == null)) {
            // terminal.println(Couleur.VERT.getStabilo(), "La route est deja occupee");
            // dialogue.appuyerSurEntree();
            return false;
        }
        return acheteRoute(air, route);
    }

    public void lanceAcheteColonie(Jeu jeu) {
        if (peutAcheterColonie() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            dialogue.appuyerSurEntree();
            return;
        }
        int idCroisement = dialogue.demandeInt(this.getCouleur().getCrayon(), "Choisissez l'emplacement : ");
        if (!jeu.getAire().isCroisementValidePourUnJoueur(idCroisement, this)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement n'est pas valide");            
            dialogue.appuyerSurEntree();
            return;
        }
        if (!(jeu.getAire().getCroisements().get(idCroisement).getProprietaire() == null)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement est deja occupe");
            dialogue.appuyerSurEntree();
            return;
        }
        acheteColonie(jeu.getAire(), idCroisement);
    }
    public boolean lanceAcheteColonieGui(AireDeJeu air, int idCroisement) {
        if (peutAcheterColonie() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            // dialogue.appuyerSurEntree();
            return false;
        }
        if (!air.isCroisementValidePourUnJoueur(idCroisement, this)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement n'est pas valide");            
            // dialogue.appuyerSurEntree();
            return false;
        }
        if (!(air.getCroisements().get(idCroisement).getProprietaire() == null)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement est deja occupe");
            // dialogue.appuyerSurEntree();
            return false;
        }
        return acheteColonie(air, idCroisement);
    }

    public void lanceAcheteVille(Jeu jeu) {
        if (peutAcheterVille() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            dialogue.appuyerSurEntree();
            return;
        }
        int idCroisement = dialogue.demandeInt(this.getCouleur().getCrayon(), "Selectionner une de vos colonies pour la transformer en ville : ");
        if (!jeu.getAire().isCroisementValidePourUnJoueur(idCroisement, this)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement n'est pas valide");            
            dialogue.appuyerSurEntree();
            return;
        }
        if (!(jeu.getAire().getCroisements().get(idCroisement).getProprietaire() == this)) {
            terminal.println(Couleur.VERT.getStabilo(), "L'emplacement est deja occupe");
            dialogue.appuyerSurEntree();
            return;
        }
        acheteVille(jeu.getAire(), idCroisement);
    }

    public boolean lanceAcheteVilleGui(AireDeJeu air, int idCroisement) {
        if (peutAcheterVille() == false) {
            // terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            // dialogue.appuyerSurEntree();
            return false;
        }
        if (!air.isCroisementValidePourUnJoueur(idCroisement, this)) {
            // terminal.println(Couleur.VERT.getStabilo(), "L'emplacement n'est pas valide");            
            // dialogue.appuyerSurEntree();
            return false;
        }
        if (!(air.getCroisements().get(idCroisement).getProprietaire() == this)) {
            // terminal.println(Couleur.VERT.getStabilo(), "L'emplacement est deja occupe");
            // dialogue.appuyerSurEntree();
            return false;
        }
        return acheteVille(air, idCroisement);
    }

    public void lanceCommerceSansPort(Jeu jeu) {
        if (peutCommerceSansPort() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Il vous faut au moins 4 fois la meme ressource");
            dialogue.appuyerSurEntree();
            return;
        }
        afficheProduction(getListCommerce());
        int ressourceProposee = dialogue.demandeIntPrecis(this.getCouleur().getCrayon(), "Que voulez-vous echanger ? ", getListCommerce());
        List<Integer> touteLesIdProductions = new LinkedList<>();
        touteLesIdProductions.add(0);
        touteLesIdProductions.add(1);
        touteLesIdProductions.add(2);
        touteLesIdProductions.add(3);
        touteLesIdProductions.add(4);
        touteLesIdProductions.add(99);
        afficheProduction(touteLesIdProductions);
        int ressourceEchangee = dialogue.demandeIntPrecis(this.getCouleur().getCrayon(), "Contre quoi ? ", touteLesIdProductions);
        if (ressourceEchangee == ressourceProposee) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous ne pouvez pas echanger avec la meme ressource");
            dialogue.appuyerSurEntree();
            return;
        }
        if (ressourceEchangee == Production.RIEN.getIdProduction() || ressourceProposee == Production.RIEN.getIdProduction()) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous ne pouvez pas echanger avec rien");
            dialogue.appuyerSurEntree();
            return;
        }
        faireCommerceSansPort(Production.getProductionParId(ressourceProposee),Production.getProductionParId(ressourceEchangee));
    }

    public void faireCommerceSansPort(Production ressourceProposee, Production ressourceEchangee) {
        if (ressourceEchangee == ressourceProposee) {
            return;
        }
        if (ressourceEchangee == Production.RIEN || ressourceProposee == Production.RIEN) {
            return;
        }
        this.enleverRessources(4, ressourceProposee);
        this.ajouterRessources(1, ressourceEchangee);

    } 

    public void lanceAcheteCarteChevalier(Jeu jeu) {
        if (peutAcheterCarteChevalier() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            dialogue.appuyerSurEntree();
            return;
        }
        acheteCarteChevalier();
    }

    public void lanceUtiliserCarteChevalier(Jeu jeu) {
        if (peutUtiliserCarteChevalier() == false) {
            terminal.println(Couleur.VERT.getStabilo(), "Vous n'avez pas les ressources necessaires");
            dialogue.appuyerSurEntree();
            return;
        }
        utiliserCarteChevalier(jeu);
    }

}
