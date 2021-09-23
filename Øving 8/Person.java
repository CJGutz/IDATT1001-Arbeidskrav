public class Person {
    private final String fornavn;
    private final String etternavn;
    private final int foedselaar;

    public Person(String fornavn, String etternavn, String foedselaar) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.foedselaar = tryCatchInt(foedselaar);
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getFoedselaar() {
        return foedselaar;
    } 

    @Override // Overskriver forrige toString metode
    public String toString() {
        return fornavn + ", " + etternavn + ", " + foedselaar;
    }

    public int tryCatchInt(String n) {
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            System.out.println("Error occured --> returning 0 instead of " + n);
            return 0;
        }
    }
} 