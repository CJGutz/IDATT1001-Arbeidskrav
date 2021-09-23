import java.util.*;

class Oppgave3{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hva vil du?");
        System.out.println("    1. Addere:");
        System.out.println("    2. Multiplisere:");
        System.out.println("    3. Transponere:");
 
        int menyValg = scanner.nextInt();

        Matrise m1 = new Matrise(hentArray());

        if (menyValg == 1) {
            Matrise m2 = new Matrise(hentArray());
            m1.print();
            System.out.println("+");
            m2.print();
            System.out.println("=");
            m1.summer(m2).print();
        } else if (menyValg == 2) {
            Matrise m2 = new Matrise(hentArray());
            m1.print();
            System.out.println("*");
            m2.print();
            System.out.println("=");
            m1.multipliser(m2).print();
        } else if (menyValg == 3) {
            m1.print();
            System.out.println("=>");
            m1.transponer().print();
        } else {
            return;
        }
        

    }

    static int[][] hentArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ny matrise: \n");

        System.out.println("Rader:");
        int rader = scanner.nextInt();
        System.out.println("Kolonner:");
        int kolonner = scanner.nextInt();

        int[][] array = new int[rader][kolonner];
        int indexRad = 0;
        for (int i = 0; i < rader; i++) {
            System.out.println("Celler i rad " +  (i + 1) + ": [x,y,z,]");
            String input = scanner.next();
            int indexKolonne = 0;
            String gjeldendeTall = "";
            for (int j = 0; j < input.length(); j++) {
                if (Character.toString(input.charAt(j)).equals(",")) {
                    array[indexRad][indexKolonne] = Integer.parseInt(gjeldendeTall);
                    indexKolonne++;
                    gjeldendeTall = "";
                } else {
                    gjeldendeTall += input.charAt(j);
                }
            }
            indexRad++;
        }

        return array;
    }
} 