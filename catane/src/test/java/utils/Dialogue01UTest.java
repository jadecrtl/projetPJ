package utils;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Dialogue01UTest {
    
    @Test
    public void repondreQuestionListeEntiers() {
        List<Integer> reponses = new ArrayList<Integer>();
        reponses.add(0);
        reponses.add(1);
        reponses.add(2);
        Dialogue dialogue = mock(Dialogue.class);
        when(dialogue.demandeInt("", "")).thenReturn(1);
        assertThat(reponses).contains(dialogue.demandeInt("", ""));
        when(dialogue.demandeInt("", "")).thenReturn(5);
        assertThat(reponses).doesNotContain(dialogue.demandeInt("", ""));
    }

    @Test
    public void repondreQuestionListeString() {
        List<String> reponses = new ArrayList<String>();
        reponses.add("A");
        reponses.add("B");
        reponses.add("C");
        Dialogue dialogue = mock(Dialogue.class);
        when(dialogue.demandeString("", "")).thenReturn("B");
        assertThat(reponses).contains(dialogue.demandeString("", ""));
        when(dialogue.demandeString("", "")).thenReturn("E");
        assertThat(reponses).doesNotContain(dialogue.demandeString("", ""));
    }

}
