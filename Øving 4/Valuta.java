public class Valuta {
    String navn;
    double kurs;
    double belop;
    boolean nokForst;

    public Valuta(String navn, double kurs) {
        this.navn = navn;
        this.kurs = kurs;
    }

    public double fraNOK(double belop) {
        this.belop = belop;
        return (this.belop / this.kurs);    
    }

    public double tilNOK(double belop) {
        this.belop = belop;
        return (this.belop * this.kurs);
    }
}