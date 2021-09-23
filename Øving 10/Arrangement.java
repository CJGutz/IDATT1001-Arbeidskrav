import java.util.Comparator;

class Arrangement implements Comparable<Arrangement> {

    private final int nummer;
    private final String navn;
    private final String sted;
    private final String leder;
    private final String type;
    private final long tidspunkt;

    public Arrangement(int nummer, String navn, String sted, String leder, String type, long tidspunkt) {
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.leder = leder;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }

    public String getLeder() {
        return leder;
    }

    public String getType() {
        return type;
    }

    public long getTidspunkt() {
        return tidspunkt;
    }

    public String toString() {
        return nummer + ", " + navn + ", " + sted + ", " + leder + ", " + type + ", " + tidspunkt;
    }

    public int compareTo(Arrangement arran) {
        return sted.compareTo(arran.getSted());
    }

    public static Comparator<Arrangement> tidSorter = new Comparator<Arrangement>() {

        public int compare(Arrangement a1, Arrangement a2) {
            return (int)a1.getTidspunkt() - (int)a2.getTidspunkt();
        }
    };

    public static Comparator<Arrangement> stedSorter = new Comparator<Arrangement>() {

        public int compare(Arrangement a1, Arrangement a2) {
            return a1.getSted().compareTo(a2.getSted());
        } 
    };

    public static Comparator<Arrangement> typeSorter = new Comparator<Arrangement>() {

        public int compare(Arrangement a1, Arrangement a2) {
            return a1.getType().compareTo(a2.getType());
        }
    };

}