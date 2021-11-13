package principal;

import enums.TypeJoueur;
import enums.Couleur;

public class Joueur {
    
    private String nom;
    private int age;
    private TypeJoueur typeJoueur;
    private Couleur couleur;

    public Joueur(String nom, int age, TypeJoueur typeJoueur, Couleur couleur) {
        if (nom == null || age == 0 || typeJoueur == null || couleur == null || age < 0) {
            throw new IllegalArgumentException("Erreur lors de la creation du joueur.");
        }
        this.nom = nom;
        this.age = age;
        this.typeJoueur = typeJoueur;
        this.couleur = couleur;
    }






}
