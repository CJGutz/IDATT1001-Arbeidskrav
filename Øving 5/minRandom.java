import java.util.*;

class minRandom{
    Random tilfeldigTall;
    int heltall;
    double desimaltall;

    public minRandom() {
        tilfeldigTall = new Random();
    }

    public int nesteHeltall(int nedre, int ovre){
        if (ovre > nedre) {
            heltall = tilfeldigTall.nextInt(ovre - nedre) + nedre;
            return heltall;
        }
        return 0;
    }

    public double nesteDesimaltall(double nedre, double ovre) {
        if (ovre <= 1 && ovre >= 0 && nedre < 1 && nedre >= 0 && ovre > nedre) { // Heller flere if-setninger for å håndtere feil bedre
            
            desimaltall = tilfeldigTall.nextDouble() * (ovre - nedre) + nedre;
            while (desimaltall >= 1) {
                desimaltall = tilfeldigTall.nextDouble() * (ovre - nedre) + nedre;
            }
            return desimaltall;
        }
        return 0;
    }
} 