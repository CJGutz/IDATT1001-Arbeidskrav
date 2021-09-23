import java.util.ArrayList;
import java.util.Collections;

class ArrangementRegister {

    private ArrayList<Arrangement> arrangementer;
    
    public ArrangementRegister() {
        arrangementer = new ArrayList<Arrangement>();
    }

    public ArrayList<Arrangement> getArran() {
        return arrangementer;
    }

    public void registrerArrangement(int nummer, String navn, String sted, String leder, String type, long tidspunkt) {
        arrangementer.add(new Arrangement(nummer, navn, sted, leder, type, tidspunkt));
    }

    public ArrayList<Arrangement> arranISted(String sted) { // Finn alle arrangementer på et gitt sted
        ArrayList<Arrangement> likeArran = new ArrayList<Arrangement>();

        for (int i = 0; i < arrangementer.size(); i++) {
            if (arrangementer.get(i).getSted().equals(sted)) {
                likeArran.add(arrangementer.get(i));
            }
        }
        return sorterTid(likeArran);
    }

    public ArrayList<Arrangement> arranITid(long dato) { // Finn alle arrangementer på en gitt tid
        ArrayList<Arrangement> likeArran = new ArrayList<Arrangement>();

        for (int i = 0; i < arrangementer.size(); i++) {
            if (arrangementer.get(i).getTidspunkt()/10000 == dato) {
                likeArran.add(arrangementer.get(i));
            }
        }

        return sorterTid(likeArran);
    }

    public ArrayList<Arrangement> arranMellomTid(long dato1, long dato2) { // Finn alle arrangementer mellom 2 ulike tider
        ArrayList<Arrangement> likeArran = new ArrayList<Arrangement>();

        for (int i = 0; i < arrangementer.size(); i++) {
            long dato = arrangementer.get(i).getTidspunkt()/10000;
            if (dato > dato1 && dato < dato2) {
                likeArran.add(arrangementer.get(i));
            }
        }

        return sorterTid(likeArran);
    }

    public ArrayList<Arrangement> sorterTid(ArrayList<Arrangement> liste) { // Sorter en liste etter tid
        Collections.sort(liste, Arrangement.tidSorter);
        return liste;
    }

    public ArrayList<Arrangement> sorterSted(ArrayList<Arrangement> liste) { // Sorter en liste etter sted
        Collections.sort(liste, Arrangement.stedSorter);
        return liste;
    }

    public ArrayList<Arrangement> sorterType(ArrayList<Arrangement> liste) { // Sorter en liste etter type
        Collections.sort(liste, Arrangement.typeSorter);
        return liste;
    }

    public String toString() {
        String returnString = "";

        for (int i = 0; i < arrangementer.size(); i++) {
            returnString += i + 1 + ". " + arrangementer.get(i).toString() + "\n";
        }

        return returnString;
    }


}