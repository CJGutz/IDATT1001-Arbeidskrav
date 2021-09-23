import static javax.swing.JOptionPane.*;

class Oppgave2{
    public static void main(String[] args) {
        boolean nyttSpill = true;

        do {
            int prim = 0;
            do {
                try {
                    prim = Integer.parseInt(showInputDialog("Sjekk om heltallet er et primtall."));
                    System.out.println(prim);
                } catch (NumberFormatException e) {
                    showMessageDialog(null, "Er tallet et positivt heltall?");
                }
            } while (prim <= 0);

            boolean primFunnet = true;

            for (int i = 2; i < prim; i++) {
                if (prim == 1) {
                    showMessageDialog(null, "Tallet er ikke et primtall.");
                    primFunnet = false;
                } 
                else if (prim % i == 0 && primFunnet) {
                    showMessageDialog(null, "Tallet er ikke et primtall.");
                    primFunnet = false;
                    if (showConfirmDialog(null, "En gang til?") == 0) {
                        nyttSpill = true;
                    } else {
                        nyttSpill = false;
                    }
                }
            }

            if (primFunnet) {
                showMessageDialog(null, "Tallet er et primtall!");
                if (showConfirmDialog(null, "En gang til?") == 0) {
                    nyttSpill = true;
                } else {
                    nyttSpill = false;
                }
            }

        } while (nyttSpill);
        



    }
}