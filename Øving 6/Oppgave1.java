import java.util.*;
import java.text.*;
import java.math.*;
 
class Oppgave1{
    public static void main(String[] args) {
        Random tilfeldig = new Random();
        int ITERASJONER = 10000;
        int MAKS_TALL = 10 ;

        int[] antall = new int[MAKS_TALL];

        // lager tabellen med tilfeldig tall
        for (int i = 0; i < ITERASJONER; i++) {
            int tall = tilfeldig.nextInt(MAKS_TALL);
            antall[tall]++;
        }

        for (int i = 0; i < MAKS_TALL; i++) {

            // kopierer antall uten interference
            int[] kopiAntall = new int[MAKS_TALL];
            System.arraycopy(antall, 0, kopiAntall, 0, MAKS_TALL); 

            // legger til stjerner
            String stjerner = "";
            while (kopiAntall[i] >= 5) {
                kopiAntall[i] = kopiAntall[i] - 10;
                stjerner += "*";
            }

            System.out.println(i + " => " + antall[i] + " " + stjerner); // printer ut antallet
        }
    }
} 