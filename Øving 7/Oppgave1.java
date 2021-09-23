import java.util.*;

class Oppgave1{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in).useDelimiter("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn tekst:");
        String[] stringListe = in.next().replaceAll("\\s+",",").split(",");
        NyString nyString = new NyString(stringListe);

        System.out.println("Velg handling");
        System.out.println("    1. Forkort");
        System.out.println("    2. Fjern");

        int menyValg = scanner.nextInt();

        if (menyValg == 1) {
            System.out.println(nyString.forkorting());
        } else if (menyValg == 2) {
            String bokstav = in.next();
            System.out.println(nyString.fjern(bokstav));
        } else {
            System.out.println("Ingen valgt");
        }

        
    }   
}