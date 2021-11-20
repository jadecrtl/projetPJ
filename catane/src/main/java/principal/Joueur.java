package principal;

import enums.TypeJoueur;
import enums.Couleur;
import enums.Production;

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
        if (production == Production.BOIS) {
            this.setInventaireBois(getInventaireBois()+i);
        }
        if (production == Production.ARGILE) {
            this.setInventaireArgile(getInventaireArgile()+i);
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
    }

    public boolean peutAcheterRoute() {
        if (getInventaireBois() > 0 && getInventaireArgile() > 0) {
            return true;
        }
        return false;
    }


}
