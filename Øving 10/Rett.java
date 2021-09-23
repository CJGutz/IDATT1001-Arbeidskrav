class Rett {

    private final String navn;
    private final double pris;
    private final String type;
    private final String oppskrift;

    public Rett(String navn, double pris, String type, String oppskrift) {
        this.navn = navn;
        this.pris = pris;
        this.type = type;
        this.oppskrift = oppskrift;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public String getType() {
        return type;
    }

    public String getOppskrift() {
        return oppskrift;
    }

    public String toString() {
        return "Navn: " + navn + ".     Pris: " + pris + ".     Type: " + type + ".     Oppskriften er: " + oppskrift;
    }
}