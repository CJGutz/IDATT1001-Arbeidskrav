import java.util.*;

class Oppgave2 {
    public static void main(String[] args) {
 
        Scanner tekstInput = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Skriv tekst:");
        String[] tekst = tekstInput.next().replaceAll("\\s",",").split(",");

        Tekstbehandling tekstbehandler = new Tekstbehandling(tekst);

        Scanner nyInput = new Scanner(System.in);

        boolean fortsett = true;
        while (fortsett) {
            for (String mulighet : tekstbehandler.muligheter) {
                System.out.println("    " + mulighet);
            }

            System.out.println("Velg tjeneste");
            int tjeneste = nyInput.nextInt();
        
            if (tjeneste == 1) {System.out.println(tekstbehandler.antallOrd());}
            else if (tjeneste == 2) {System.out.println(tekstbehandler.gjennomsnittligOrdLengde());}
            else if (tjeneste == 3) {System.out.println(tekstbehandler.gjennomsnittligOrdPerSetning());}
            else if (tjeneste == 4) {
                System.out.println("Ord som skiftes");
                String finn = nyInput.next();
                System.out.println("Erstattelse");
                String erstattelse = nyInput.next();
                tekstbehandler.erstatt(finn, erstattelse);
            }
            else if (tjeneste == 5) {tekstbehandler.skrivUt();}
            else if (tjeneste == 6) {tekstbehandler.skrivUtIStoreBokstaver();}
            else {System.out.println("Avsluttet"); fortsett = false;}
        }


    }
}