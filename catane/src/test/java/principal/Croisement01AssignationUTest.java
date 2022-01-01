package principal;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeCroisement;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Croisement01AssignationUTest {
    
    @Test
    public void croisementProprietaireNull() {
        Croisement c1 = new Croisement(0);
        assertThatThrownBy(() -> c1.setProprietaire(null,null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void assignationProprioEtColonieSurCroisement() {
        Croisement c2 = new Croisement(0);
        Joueur j2 = new Joueur("j2", TypeJoueur.HUMAIN, Couleur.BLANC);
        c2.setProprietaire(j2, TypeCroisement.COLONIE);
        assertThat(c2.getProprietaire()).isEqualTo(j2);
        assertThat(c2.getTypeCroisement()).isEqualTo(TypeCroisement.COLONIE);
    }











}
