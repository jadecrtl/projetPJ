package principal;

import enums.TypeJoueur;
import enums.Couleur;

public class Joueur {
    
    private String nom;
    private int age;
    private TypeJoueur typeJoueur;
    private Couleur couleur;
    private int pointVictoire;

    public Joueur(String nom, int age, TypeJoueur typeJoueur, Couleur couleur) {
        if (nom == null || age == 0 || typeJoueur == null || couleur == null || age < 0) {
            throw new IllegalArgumentException("Erreur lors de la creation du joueur.");
        }
        this.setNom(nom);
        this.setAge(age);
        this.setTypeJoueur(typeJoueur);
        this.setCouleur(couleur);
        this.setPointVictoire(0);
    }

    public int getPointVictoire() {
        return pointVictoire;
    }

    public void setPointVictoire(int pointVictoire) {
        this.pointVictoire = pointVictoire;
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






}
