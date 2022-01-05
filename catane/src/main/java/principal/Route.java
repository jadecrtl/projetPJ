package principal;

public class Route {
    private int idCroisementA;
    private int idCroisementB;
    private Joueur proprietaire;

    public Route(int idCroisementA, int idCroisementB) {
        if (idCroisementA > idCroisementB) {
            this.setIdCroisementA(idCroisementB);
            this.setIdCroisementB(idCroisementA);
        }
        else {
            this.idCroisementA = idCroisementA;
            this.idCroisementB = idCroisementB;
        }
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
