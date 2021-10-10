import java.util.Scanner;
import java.util.HashMap;

public class Oppgave1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Lager eiendomsregister
        Eiendomsregister register = new Eiendomsregister();

        // Git meny helt til klienten avslutter selv
        boolean fortsett = true;
        while (fortsett) {

            // Printer ut menyen
            System.out.println("\nMeny: \n    1. Legg til eiendom \n " +
                                        "   2. Skriv ut all eiendomer \n " +
                                        "   3. Let etter eiendom \n " +
                                        "   4. Regn ut gjennomsnittsareal \n" +
                                        "       Alt annet: Avslutt");

            // Henter menyvalget til klienten
            int menyValg = (int) tryCatchDouble();

            // sjekker hvilken undermeny som er valgt
            switch (menyValg) {
                case 1:

                    // sender eiendom til register hvis og bare hvis eiendommen er gyldig
                    boolean eiendomLaget = false;
                    while (!eiendomLaget) {
                        try {
                            register.addEiendom(lagEiendom());
                            eiendomLaget = true;
                        } catch (NumberFormatException exception) {
                            System.out.println("\nFeil input... En gang til. \n");
                        }
                    }

                    break;
                case 2:
                    // printer ut alle eiendommer i registeret
                    System.out.println(register);
                    break;
                case 3:
                    // tar inn 3 inputs
                    System.out.print("\nKommunenummer:    ");
                    int kommunenummer = (int) tryCatchDouble();
                    System.out.print("Gaardsnummer:     ");
                    int gaardsnummer =  (int) tryCatchDouble();
                    System.out.print("Bruksnummer:      ");
                    int bruksnummer =   (int) tryCatchDouble();

                    // finner spesifikk eiendom med de inputsene
                    Eiendom funnetEiendom = register.finnEiendom(kommunenummer, gaardsnummer, bruksnummer);
                    System.out.println("\nFunnet eiendom " + funnetEiendom);
                    break;
                case 4:
                    // regner gjennomsnittsarealet
                    double areal = register.gjennomsnittsareal();

                    System.out.println("\nGjennomsnittsarealet er " + areal);
                    break;
                default:
                    fortsett = false;
            }

        }
    }

    // metode for å hente gyldig double
    public static double tryCatchDouble() {
        Scanner in = new Scanner(System.in);
        double tall = 0;
        try {
            tall = in.nextDouble();
        } catch (NumberFormatException exception) {
            tall = 0;
        } finally {
            return tall;
        }
    }

    // metide for å hente gyldig eiendom
    public static Eiendom lagEiendom() {
        Scanner in = new Scanner(System.in);

        // definerer spørsmål som også brukes som 'keys' i HashMap
        String[] spoersmaal = {"Kommunenummer", "Kommunenavn", "Gaardsnummer", "Bruksnummer", "Bruksnavn", "Areal", "Eier"};
        HashMap<String, String> inputs = new HashMap<String, String>();
        Eiendom eiendom;

        // Printer ut spørsmål
        for (int i = 0; i < spoersmaal.length; i++) {
            System.out.print(spoersmaal[i] + ":    ");
            inputs.put(spoersmaal[i], in.nextLine());
        }

        // Velger en av to konstruktører
        if (inputs.get("Bruksnavn").length() == 0) {
            eiendom = new Eiendom(Integer.parseInt(inputs.get("Kommunenummer")),
                                                   inputs.get("Kommunenavn"),
                                  Integer.parseInt(inputs.get("Gaardsnummer")),
                                  Integer.parseInt(inputs.get("Bruksnummer")),
                                Double.parseDouble(inputs.get("Areal")),
                                                   inputs.get("Eier"));
        } else {
            eiendom = new Eiendom(Integer.parseInt(inputs.get("Kommunenummer")),
                                                   inputs.get("Kommunenavn"),
                                  Integer.parseInt(inputs.get("Gaardsnummer")),
                                  Integer.parseInt(inputs.get("Bruksnummer")),
                                                   inputs.get("Bruksnavn"),
                                Double.parseDouble(inputs.get("Areal")),
                                                   inputs.get("Eier"));
        }

        return eiendom;

    }
}