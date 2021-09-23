import static javax.swing.JOptionPane.*;
import java.util.*;

class Oppgave1{
    public static void main(String[] args){

        showMessageDialog(null, "To inputs; gangetabell start og slutt. Ikke skriv annet enn positive heltall");

        int start = 0;
        int slutt = 0;

        do {
            try {
                start = Integer.parseInt(showInputDialog("Start:"));
                slutt = Integer.parseInt(showInputDialog("Slutt:"));
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Bare positive heltall!");
            }

        } while (start <= 0 || slutt <= 0 || slutt < start);

        for (int i = 0; i <= (slutt - start); i++) {
            System.out.println((start + i) + "-gangen");
            for (int j = 0; j < 10; j++) {
                System.out.println((start+i) + " x " + (j+1) + " = " + ((start+i) * (j+1)));
            }
        }
    }
}