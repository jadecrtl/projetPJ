package principal;
import java.util.List;
import java.util.OptionalLong;

import utils.De6Faces;
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
            joueurs.get(joueurActif).joue();
            joueurActif++;
            if (joueurActif == joueurs.size()) {
                joueurActif = 0;
            }
        } while(joueurVainqueur() == null);
        return joueurVainqueur();
    }

}
