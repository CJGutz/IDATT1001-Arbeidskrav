class Tekstanalyse {
    String alfabet = "abcdefghijklmnopqrstuvwxyzæøå";
    int[] antallTegn = new int[30];
    String tekst;

    public Tekstanalyse(String tekst) {
        this.tekst = tekst.toLowerCase();
        for (int i = 0; i < this.tekst.length(); i++) {
            int index = this.alfabet.indexOf(this.tekst.charAt(i));
            if (index == -1) {
                this.antallTegn[29]++;
            } else {
                this.antallTegn[index]++;
            } 
        }
    }

    public int antallForskjelligeBokstaver() {
        int antallForskjellige = 0;
        for (int i = 0; i < this.antallTegn.length; i++) {
            if (this.antallTegn[i] > 0 && i != 29) {
                antallForskjellige++;
            } 
        } 
        return antallForskjellige;
    }

    public double antallBokstaver() {
        return this.tekst.length() - antallTegn[29];
    }

    public double andelIkkeBokstaver() {
        return (this.antallTegn[29] * 100 / this.tekst.length());
    }

    public int bokstavFrekvens(String n) {
        int index = this.alfabet.indexOf(n.charAt(0));
        if (index < 0) {
            return this.antallTegn[28];
        } 
        else {
            return this.antallTegn[index];
        }
    }

    public String[] oftestForekomst() {
        int frekvens = 0;
        String bokstaver = "";
        for (int i = 0; i < this.antallTegn.length; i++) {
            if (frekvens < this.antallTegn[i] && i != 29) {
                frekvens = this.antallTegn[i];
            }
        }
        for (int i = 0; i < this.antallTegn.length; i++) {
            if (frekvens == this.antallTegn[i] && i != 29) {
                bokstaver += this.alfabet.charAt(i) + ", ";
            }
        }

        String[] array = {bokstaver, Integer.toString(frekvens)};
        return array;
    }
}