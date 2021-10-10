import java.util.ArrayList;
import java.util.HashMap;

public class Eiendomsregister {

    private HashMap<ArrayList<Integer>, Eiendom> eiendomer;

    public Eiendomsregister() {
        this.eiendomer = new HashMap<ArrayList<Integer>, Eiendom>();
    }

    public HashMap<ArrayList<Integer>, Eiendom> getEiendomer() {
        return eiendomer;
    }

    public void addEiendom(Eiendom eiendom) {

        ArrayList<Integer> nummer = new ArrayList<Integer>();

        nummer.add(eiendom.getKommunenummer());
        nummer.add(eiendom.getGaardsnummer());
        nummer.add(eiendom.getBruksnummer());

        eiendomer.put(nummer, eiendom);

    }

    public Eiendom finnEiendom(int kommunenummer,int gaardsnummer, int bruksnummer) {

        ArrayList<Integer> nummer = new ArrayList<Integer>();

        nummer.add(kommunenummer);
        nummer.add(gaardsnummer);
        nummer.add(bruksnummer);

        return eiendomer.get(nummer);

    }

    public double gjennomsnittsareal() {

        double areal = 0;

        for (Eiendom eiendom : eiendomer.values()) {
            areal += eiendom.getAreal();
        }

        return areal;

    }

    @Override
    public String toString() {
        String returnString = "";

        for (Eiendom eiendom : eiendomer.values()) {
            returnString += eiendom.toString() + "\n";
        }

        return returnString;
    }
}