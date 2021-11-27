package principal;

import java.util.List;

import enums.TypeCroisement;

import java.util.LinkedList;

public class Croisement {
    private int idCroisement;
    List<Integer> tuilesVoisines;
    private TypeCroisement typeCroisement;
    private Joueur proprietaire;

    public Croisement(int idCroisement) {
        if (idCroisement < 0) {
            throw new IllegalArgumentException("On ne crée pas de croisement avec un id négatif.");
        }
        this.idCroisement = idCroisement;
        tuilesVoisines = new LinkedList<Integer>();
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire, TypeCroisement typeCroisement) {
        if (proprietaire == null || typeCroisement == null) {
            throw new IllegalArgumentException("Il faut assigner le proprietaire et le type de croisement.");
        }
        this.proprietaire = proprietaire;
        this.typeCroisement = typeCroisement;
    }

    public TypeCroisement getTypeCroisement() {
        return typeCroisement;
    }

    public void setTypeCroisement(TypeCroisement typeCroisement) {
        this.typeCroisement = typeCroisement;
    }

    public int getIdCroisement() {
        return idCroisement;
    }

    public List<Integer> getTuilesVoisines() {
        return tuilesVoisines;
    }

    public void setTuilesVoisines(int idTuile) {
        this.tuilesVoisines.add(idTuile);
    }

}
