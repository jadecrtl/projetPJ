package utils;

import java.util.List;
import java.util.Scanner;

public class Dialogue {
    
    private Scanner scanner = new Scanner(System.in);
    private TerminalCouleur terminal = new TerminalCouleur();

    public int demandeInt(String decoration, String question) {
        boolean erreur;
        do {
            terminal.print(decoration, question + " ");
            try {
                erreur = false;
                return scanner.nextInt();
            }
            catch(Exception e) {
                scanner.next();
                erreur = true;
                terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez reessayer a nouveau svp.");

            }
        }
        while (erreur == true);
        return 0;
    }

    public int demandeIntPrecis(String decoration, String question, List<Integer> liste) {
        boolean erreur;
        int saisie;
        do {
            terminal.print(decoration, question + liste + " ");
            try {
                erreur = false;
                saisie = scanner.nextInt();
                if (liste.contains(saisie)) {
                    return saisie;
                }
                else {
                    terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez choisir parmi la liste proposee svp.");
                    erreur = true;
                }
            }
            catch(Exception e) {
                scanner.next();
                erreur = true;
                terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez reessayer a nouveau svp.");
            }
        }
        while (erreur == true);
        return 0;
    }

    public String demandeString(String decoration, String question) {
        boolean erreur;
        do {
            terminal.print(decoration, question + " ");
            try {
                erreur = false;
                return scanner.next();
            }
            catch(Exception e) {
                scanner.next();
                erreur = true;
                terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez reessayer a nouveau svp.");
            }
        }
        while (erreur == true);
        return null;
    }

    public String demandeStringPrecis(String decoration, String question, List<String> liste) {
        boolean erreur;
        String saisie;
        do {
            terminal.print(decoration, question + liste + " ");
            try {
                erreur = false;
                saisie = scanner.next();
                if (liste.contains(saisie)) {
                    return saisie;
                }
                else {
                    terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez choisir parmi la liste proposee svp.");
                    erreur = true;
                }
            }
            catch(Exception e) {
                scanner.next();
                erreur = true;
                terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez reessayer a nouveau svp.");
            }
        }
        while (erreur == true);
        return null;
    }

    public void appuyerSurEntree() {
        //String str1 = this.demandeString(AnsiColors.ANSI_GREEN, "Veuillez appuyer sur entree svp.");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
