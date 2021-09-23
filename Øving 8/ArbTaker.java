import java.util.*; // Agregering og komposisjon

public class ArbTaker { 


    final Person personalia;
    private final int arbtakerNr;
    private final int ansettelsesaar;
    private double maanedsloenn;
    private double skatteprosent;

    GregorianCalendar kalender;

    public ArbTaker(Person person, String arbtakerNr, String ansettelsesaar, String maanedsloenn, String skatteprosent) {
        this.personalia = person;
        this.arbtakerNr = tryCatchInt(arbtakerNr);
        this.ansettelsesaar = tryCatchInt(ansettelsesaar);
        this.maanedsloenn = tryCatchDouble(maanedsloenn);
        this.skatteprosent = tryCatchDouble(skatteprosent);

        kalender = new GregorianCalendar();
    } 

    public int getArbtakerNr() {
        return arbtakerNr;
    }

    public int getAnsettelsesaar() {
        return ansettelsesaar;
    }

    public double getMaanedsloenn() {
        return maanedsloenn;
    }

    public double getSkatteprosent() {
        return skatteprosent;
    }

    public void setMaanedsloenn(int nyMaanedsloenn) {
        maanedsloenn = nyMaanedsloenn;
    }

    public void setSkatteprosent(double nySkatteprosent) {
        skatteprosent = nySkatteprosent;
    }

    public double getSkattIMaaned() {
        return getMaanedsloenn() * getSkatteprosent() / 100;
    }

    public double getBruttoloenn() {
        return getMaanedsloenn() * 12;
    }

    public double getSkattetrekk() {
        return getSkattIMaaned() + getSkattIMaaned() / 2;
    }

    public String getNavn() {
        return personalia.getEtternavn() + ", " + personalia.getFornavn(); // personalia
    }

    public int getAlder() {
        return kalender.get(Calendar.YEAR) - personalia.getFoedselaar(); // personalia
    }

    public int getAarAnsatt() {
        return kalender.get(Calendar.YEAR) - getAnsettelsesaar();
    }

    public boolean omAnsattLengerEnn(int aar) {
        if (getAarAnsatt() > aar) {return true;}
        else {return false;}
    }

    public String toString() {
        return personalia.toString() + ", " + arbtakerNr + ", " + ansettelsesaar + ", " + maanedsloenn + ", " + skatteprosent;
    }

    public int tryCatchInt(String n) {
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            System.out.println("Error occured --> returning 0 instead of " + n);
            return 0;
        }
    }

    public double tryCatchDouble(String n) {
        try {
            return Double.parseDouble(n);
        } catch (NumberFormatException e) {
            System.out.println("Error occured --> returning 0 instead of " + n);
            return 0;
        }
    }
} 