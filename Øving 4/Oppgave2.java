public class Oppgave2{
    public static void main(String[] args) {

        Spiller spillerA = new Spiller("Brage");
        Spiller spillerB = new Spiller("Carl");

        Spiller[] spillere = {spillerA, spillerB};

        boolean spillFerdig = false;

        int rundeNummer = 1;
        
        int vinner = 0;

        while (!spillFerdig) {
            System.out.println("Runde nr. " + rundeNummer);

            for (int i = 0; i < spillere.length; i++) {

                if (spillere[i].kastTerningen() == 1) {
                    spillere[i].sumPoeng = 0;
                    spillere[i].antallEnere++;
                }

                System.out.println(spillere[i].navn + " har " + spillere[i].sumPoeng + " poeng");

                if (spillere[i].erFerdig()) {
                    spillFerdig = true;
                    vinner = i;
                }

            }

            rundeNummer++;
        }

        if (spillFerdig) {
            System.out.println("\n");
            for (int i = 0; i < spillere.length; i++) {
                System.out.println(spillere[i].navn + " kastet enere " + spillere[i].antallEnere + " ganger");
            }
        }

        System.out.println("\n" + spillere[vinner].navn + " vant spillet etter " + rundeNummer + " runder");

    }
}

