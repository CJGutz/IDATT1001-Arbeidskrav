import java.lang.Math;

class Brok{
    private int teller;
    private int nevner;
    
    public Brok(int teller, int nevner) {
        this.teller = teller;
        this.nevner = nevner;
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevner er 0");
        }

    }

    public Brok(int teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    public int getTeller() {
        return teller;
    }

    public int getNevner() {
        return nevner;
    }



    public Brok getSum(Brok brok2) {     

        int nyTeller = (teller * brok2.getNevner()) + (nevner * brok2.getTeller());
        int nyNevner = nevner * brok2.getNevner();

        return new Brok(nyTeller, nyNevner);
    }

    public Brok getSub(Brok brok2) {

        int nyTeller = (teller * brok2.getNevner()) - (nevner * brok2.getTeller());
        int nyNevner = nevner * brok2.getNevner();

        return new Brok(nyTeller, nyNevner);
    }

    public Brok getMult(Brok brok2) {

        int nyTeller = teller * brok2.teller;
        int nyNevner = nevner * brok2.nevner;

        return new Brok(nyTeller, nyNevner);
    }

    public Brok getDiv(Brok brok2) {

        int nyTeller = teller * brok2.nevner;
        int nyNevner = nevner * brok2.teller;

        return new Brok(nyTeller, nyNevner);
    }

    public String forkortOgPrint(Brok brok2) { 
        int nyTeller = brok2.getTeller();
        int nyNevner = brok2.getNevner();

        // finn felles deleilig
        for (int i = nyTeller; i > 0; i--) {
            if (Math.abs(nyTeller) % i == 0 && Math.abs(nyNevner) % i == 0) {
                nyTeller = nyTeller / i;
                nyNevner = nyNevner / i; 
            }
        }

        if (nyNevner < 0) {nyTeller*=-1; nyNevner *= -1;} //Flytt fortegn fra nevner

        // finn antall heltall
        int helTall = 0; 
        while (nyTeller >= nyNevner) {
            nyTeller = nyTeller - nyNevner; 
            helTall++;
        }

        Brok nyBrok = new Brok(nyTeller, nyNevner);

        //print ut brøken
        if (helTall > 0 && nyBrok.getTeller() == 0) {
            return "Broken er omgjort til " + helTall;
        } else if (helTall > 0) {
            return "Broken er " + helTall + " og " + nyBrok.getTeller() + " / " + nyBrok.getNevner();
        } else if (nyBrok.getTeller() == nyBrok.getNevner()) {
            return "Broken er 1";
        } else {
            return "Broken er " + nyBrok.getTeller() + " / " + nyBrok.getNevner();
        }

        
    }
} 