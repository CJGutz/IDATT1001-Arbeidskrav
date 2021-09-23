// scanner.readLine();
// "1,2,3,4".split(",") -> {1,2,3,4}

class Tekstbehandling {
    // variabler
    String[] ordListe;
    String[] muligheter = {"1. Antall ord", "2. Gjennomsnittlig ordlengde", "3. Gjennomsnittlig ord per setning", "4. Erstatt", "5. Skriv ut", "6. Skriv ut i store bokstaver"};

    public Tekstbehandling(String[] ordListe) {
        // konstruktør
        this.ordListe = ordListe;
    }

    //antall ord i teksten
    public int antallOrd() {
        return this.ordListe.length;
    }

    //gjennomsnittlig ordlengde
    public int gjennomsnittligOrdLengde() {

        int[] gjennomsnitt = new int[2];
        
        for (String ord : this.ordListe) {
            gjennomsnitt[0] += ord.length();
            gjennomsnitt[1] += 1;
        } 

        return gjennomsnitt[0] / gjennomsnitt[1];
    }

    //gjennomsnittlig ord per setning
    public double gjennomsnittligOrdPerSetning() {


        double antallSetninger = 0;

        for (String ord : this.ordListe) {
            if (!Character.isLetter(ord.charAt(ord.length()-1)) && ord.codePointAt(ord.length()-1) != 44) {
                antallSetninger++;
            }
        }

        if (antallSetninger == 0) {return this.ordListe.length;}
        return this.ordListe.length / antallSetninger;
    }

    //erstatte et ord med et annet
    public void erstatt(String finn, String erstattelse) {

        for (int i = 0; i < this.ordListe.length; i++) {
            if (this.ordListe[i].equals(finn)) {
                this.ordListe[i] = erstattelse;
            }
        }
    }

    //printe ut teksten
    public void skrivUt() {

        String tekst = "";

        for (String ord : this.ordListe) {
            tekst += ord + " ";
        }

        System.out.println(tekst);

    }

    //Skrive ut teksten med bare store bokstaver
    public void skrivUtIStoreBokstaver() {

        String tekst = "";

        for (String ord : this.ordListe) {
            tekst += ord.toUpperCase() + " ";
        }

        System.out.println(tekst);

    }
}