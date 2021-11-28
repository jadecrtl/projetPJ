package utils;

public class TerminalCouleur {

    public void print(String decoration, String chaine) {
        if (decoration == null) {
            System.out.print(chaine);
        }
        else {
            System.out.print(decoration + chaine + AnsiColors.ANSI_RESET);
        }
    }

    public void println(String decoration, String chaine) {
        if (decoration == null) {
            System.out.println(chaine);
        }
        else {
            System.out.println(decoration + chaine + AnsiColors.ANSI_RESET);
        }
    }

    public void printInt(String decoration, int n) {
        if (n < 10) {
            print(decoration, n + " ");
        }
        else {
            print(decoration, n + "");
        }
    }

    public void nouvelleLigne() {
        System.out.println();
    }
}
