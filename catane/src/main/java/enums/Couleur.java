package enums;

public enum Couleur {
    BLEU("\033[0;34m"),
    BLANC("\033[0;37m"), 
    ROUGE("\033[0;31m"), 
    VERT("\033[0;32m"), 
    JAUNE("\033[0;33m");

    private String crayon;

    private Couleur(String crayon) {
        this.crayon = crayon;
    }

    public String getCrayon() {
        return this.crayon;
    }
}