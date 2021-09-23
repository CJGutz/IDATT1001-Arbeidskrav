import java.util.*;



public class Oppgave1{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Legg til valutaer
        Valuta[] valutaer = {};
        boolean leggTilValuta = true;

        while (leggTilValuta) {
            System.out.println("Skriv inn valuta eller skriv ferdig for regning");
            String valutaLagtInn = scanner.next();
            if (valutaLagtInn.toLowerCase().equals("ferdig")) {
                break;
            }
            else {
                System.out.println("Skriv inn kurs");
                double kurs = scanner.nextDouble();
                Valuta valuta = new Valuta(valutaLagtInn, kurs);
                valutaer = addX(valutaer.length,valutaer,valuta);
            }
        }


        // Lag meny
        System.out.println("Meny:");
        System.out.println("    1. Avslutt");
        for (int i = 0; i < valutaer.length; i++){
            System.out.println("    " + (i+2) + ". " + valutaer[i].navn);
        }

        System.out.println("Velg meny:");
        int menyValg =  scanner.nextInt(); // Menyinput fra klient

        if (menyValg == 1) {return;} // Om klienten avslutter programmet

        System.out.println("Til eller fra NOK? [til/fra]");
        String tilEllerFra = scanner.next().toLowerCase(); // klientinput om retningen til konverteringen 

        if (tilEllerFra.equals("til")) {
            System.out.println("Velg belop i " + valutaer[menyValg - 2].navn);
            double belop = scanner.nextDouble(); // beløpinput fra klient
            double svar = valutaer[menyValg - 2].tilNOK(belop);
            System.out.println(belop + " " + valutaer[menyValg-2].navn + " er " + svar + " NOK");
        } else if (tilEllerFra.equals("fra")) {
            System.out.println("Velg belop i NOK");
            double belop = scanner.nextDouble(); // beløpinput fra klient
            double svar = valutaer[menyValg-2].fraNOK(belop);
            System.out.println(belop + " NOK er " + svar + " " + valutaer[menyValg-2].navn);
        } else {
            System.out.println("Svar ikke godtatt. Skriv 'til' eller 'fra'");
        }
    }

    public static Valuta[] addX(int n, Valuta arr[], Valuta x)
    {
        int i;
  
        // create a new array of size n+1
        Valuta newarr[] = new Valuta[n + 1];
  
        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
  
        newarr[n] = x;
  
        return newarr;
    }

}

