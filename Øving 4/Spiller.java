import java.util.*;

public class Spiller{
    int sumPoeng = 0;
    Random terning = new Random();
    String navn;
    int antallEnere = 0;
 
    public Spiller(String n) {
        navn = n;
    }

    public int getSumPoeng() {
        return sumPoeng;
    } 

    public int kastTerningen() {
        int kast = terning.nextInt(6) + 1;
        if (getSumPoeng() < 100) {sumPoeng += kast;}
        else if (getSumPoeng() > 100) {sumPoeng -= kast;}
        return kast;
    }

    public boolean erFerdig() {
        if (getSumPoeng() == 100) {
            return true;
        } else {
            return false;
        }
    }

}