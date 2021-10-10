public final class Eiendom {

    final private int kommunenummer;
    final private String kommunenavn;
    final private int gaardsnummer;
    final private int bruksnummer;
    final private String bruksnavn;
    final private double areal;
    final private String eiernavn;

    public Eiendom(int kommunenummer, String kommunenavn, int gaardsnummer, int bruksnummer, String bruksnavn, double areal, String eiernavn) {
        this.kommunenummer = kommunenummer;
        this.kommunenavn = kommunenavn;
        this.gaardsnummer = gaardsnummer;
        this.bruksnummer = bruksnummer;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eiernavn = eiernavn;
    }

    public Eiendom(int kommunenummer, String kommunenavn, int gaardsnummer, int bruksnummer, double areal, String eiernavn) {
        this.kommunenummer = kommunenummer;
        this.kommunenavn = kommunenavn;
        this.gaardsnummer = gaardsnummer;
        this.bruksnummer = bruksnummer;
        this.bruksnavn = "Ingen-Bruksnavn";
        this.areal = areal;
        this.eiernavn = eiernavn;
    }

    public int getKommunenummer() {
        return kommunenummer;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public int getGaardsnummer() {
        return gaardsnummer;
    }

    public int getBruksnummer() {
        return bruksnummer;
    }

    public String getBruksnavn() {
        return bruksnavn;
    }

    public double getAreal() {
        return areal;
    }

    public String getEiernavn() {
        return eiernavn;
    }

    @Override
    public String toString() {
        return kommunenummer + "-" + gaardsnummer + "/" + bruksnummer;
    }

    public boolean equalTo(Eiendom eiendom) {
        if (gaardsnummer == eiendom.getGaardsnummer()) {
            return true;
        }
        return false;
    }

}