package principal;

public class Route {
    private int idCroisementA;
    private int idCroisementB;
    private Joueur proprietaire;

    public Route(int idCroisementA, int idCroisementB) {//, Joueur proprietaire) {
        if (idCroisementA < 0 || idCroisementB < 0) {
            throw new IllegalArgumentException("Pas d'id croisement négatif!");
        }
        if (idCroisementA == idCroisementB) {
            throw new IllegalArgumentException("Les idCroisement doivent etre different!");
        }
        if (idCroisementA > idCroisementB) {
            this.setIdCroisementA(idCroisementB);
            this.setIdCroisementB(idCroisementA);
        }
        else {
            this.idCroisementA = idCroisementA;
            this.idCroisementB = idCroisementB;
        }
        //this.proprietaire = proprietaire;
    }

    public int getIdCroisementA() {
        return idCroisementA;
    }

    public void setIdCroisementA(int idCroisementA) {
        this.idCroisementA = idCroisementA;
    }

    public int getIdCroisementB() {
        return idCroisementB;
    }

    public void setIdCroisementB(int idCroisementB) {
        this.idCroisementB = idCroisementB;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

}
