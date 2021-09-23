import java.util.*;

class Oppgave2 {
    public static void main(String[] args) { 

        boolean fortsett = true;

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Scanner nyScanner = new Scanner(System.in);

        while (fortsett) {
            System.out.println("Skriv inn din tekst:");
            String inputString = scanner.next().replaceAll("\\s+","");
            Tekstanalyse tekst = new Tekstanalyse(inputString);

            System.out.println("Det er " + tekst.antallForskjelligeBokstaver() + " forskjellige bokstaver i teksten.");
            System.out.println("Det er totalt " + tekst.antallBokstaver() + " bokstaver i teksten.");
            System.out.println(tekst.andelIkkeBokstaver() + " % av teksten er ikke bokstaver.");
            System.out.println("Velg bokstav:");
            System.out.println("Bokstaven er i teksten " + tekst.bokstavFrekvens(scanner.next()) + " ganger.");
            System.out.println(tekst.oftestForekomst()[0] + "forekommer i teksten oftest med frekvensen " + tekst.oftestForekomst()[1]);

            System.out.println("Fortsette?: [ja/nei]");
            String valg = nyScanner.next();

            if (valg.equals("ja")) {fortsett = true;} 
            else if (valg.equals("nei")) {fortsett = false;}
            else {System.out.println("Avslutter grunnet feil input"); fortsett = false;}
            System.out.println("\n");
        }
 

    }
}