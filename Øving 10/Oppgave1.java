import java.util.*;
import java.util.ArrayList;

class Oppgave1 {
    public static void main(String[] args) {
        ArrangementRegister register = new ArrangementRegister();
        Scanner in = new Scanner(System.in);

        boolean fortsett = true;
        while (fortsett) {

            System.out.println("Meny: \n    1. Legg til arrangement\n    2. Finn arrangementer med gitt dato\n    3. Finn arrangmenter med gitt sted\n    4. Finn arrangementer mellom to datoer\n    5. Sorter arrangementer med tid\n    6. Sorter arrangementer med sted\n    7. Sorter arrangementer med type\n    8. Vis arrangementer");
        
            int menyValg = (int)tryCatch();

            if (menyValg < 1 || menyValg > 8) {fortsett = false;}

            switch (menyValg) {

                case 1:

                    System.out.println("Skriv inn -> nummer navn-navnesen sted leder type tidspunkt <- i dette formatet");
                    String[] input = in.nextLine().split(" ");

                    if (input.length != 6) {System.out.println("\nIkke gyldig format\n"); break;}

                    int nummer;
                    long tidspunkt;
                    try {nummer = Integer.parseInt(input[0]);} catch (NumberFormatException e) {System.out.println("Error ocurred --> returning 0"); nummer = 0;}
                    try {tidspunkt = Long.parseLong(input[5]);} catch (NumberFormatException e) {System.out.println("Error ocurred --> returning 0"); tidspunkt = 0;}

                    register.registrerArrangement(nummer,input[1],input[2],input[3],input[4],tidspunkt);
                    System.out.println("\n" + register);

                    break;
                case 2:

                    System.out.print("Dato:  ");
                    long dato = tryCatch();

                    System.out.println(toString(register.arranITid(dato)));

                    break;
                case 3:

                    System.out.print("Sted:  ");
                    String sted = in.nextLine();

                    System.out.println(toString(register.arranISted(sted)));

                    break;
                case 4:

                    System.out.print("Dato foran:  ");
                    long datoEn = tryCatch();

                    System.out.print("Dato etter:  ");
                    long datoTo = tryCatch();

                    System.out.println(toString(register.arranMellomTid(datoEn, datoTo)));

                    break;
                case 5:

                    System.out.println(toString(register.sorterTid(register.getArran())));

                    break;
                case 6:

                    System.out.println(toString(register.sorterSted(register.getArran())));

                    break;
                case 7:

                    System.out.println(toString(register.sorterType(register.getArran())));

                    break;
                case 8:

                    System.out.println(register);
                    
                    break;
            }
        }
    }

    public static long tryCatch() {
        Scanner in = new Scanner(System.in);

        try {
            long integer = Long.parseLong(in.nextLine());
            return integer;
        } catch (NumberFormatException e) {
            System.out.println("Error ocurred --> returning 0");
            return 0;
        }
    }

    public static String toString(ArrayList<Arrangement> arrangementer) {
        String returnString = "";
        for (Arrangement arrangement : arrangementer) {
            returnString += "Arrangement nummer " + arrangement.getNummer() + ", " + arrangement.getNavn() + ", er " + arrangement.getTidspunkt() + " i " + arrangement.getSted() + ". Det er ledet av " + arrangement.getLeder() + " og er av typen " + arrangement.getType() + ".\n"; 
        }

        return returnString;
    }
}