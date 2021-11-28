package enums;

import utils.AnsiColors;

public enum Couleur {
    BLEU(AnsiColors.ANSI_BLUE, AnsiColors.ANSI_BLUE_BACKGROUND + AnsiColors.ANSI_BLACK),
    BLANC(AnsiColors.ANSI_WHITE, AnsiColors.ANSI_WHITE_BACKGROUND + AnsiColors.ANSI_BLACK),
    ROUGE(AnsiColors.ANSI_RED, AnsiColors.ANSI_RED_BACKGROUND + AnsiColors.ANSI_BLACK),
    VERT(AnsiColors.ANSI_GREEN, AnsiColors.ANSI_GREEN_BACKGROUND + AnsiColors.ANSI_BLACK),
    MAUVE(AnsiColors.ANSI_PURPLE, AnsiColors.ANSI_PURPLE_BACKGROUND + AnsiColors.ANSI_BLACK),
    JAUNE(AnsiColors.ANSI_YELLOW, AnsiColors.ANSI_YELLOW_BACKGROUND + AnsiColors.ANSI_BLACK);
    

    private String crayon;
    private String stabilo;

    private Couleur(String crayon, String stabilo) {
        this.crayon = crayon;
        this.stabilo = stabilo;
    }

    public String getStabilo() {
        return stabilo;
    }

    public String getCrayon() {
        return this.crayon;
    }

}