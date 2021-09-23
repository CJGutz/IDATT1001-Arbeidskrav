import java.util.*;

public class Oppgave1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Teller 1:");
        int tellerEn = scanner.nextInt();
        System.out.println("Nevner 1:");
        int nevnerEn = scanner.nextInt();

        Brok brok = new Brok(tellerEn, nevnerEn);

        System.out.println("Teller 2:");
        int tellerTo = scanner.nextInt();
        System.out.println("Nevner 2:");
        int nevnerTo = scanner.nextInt();

        Brok brok2 = new Brok(tellerTo, nevnerTo); 

        String operasjon = scanner.next();

        Brok nyBrok = new Brok(1,1);

        if (operasjon.equals("+")) {nyBrok = brok.getSum(brok2);}
        else if (operasjon.equals("-")) {nyBrok = brok.getSub(brok2);} 
        else if (operasjon.equals("*")) {nyBrok = brok.getMult(brok2);}
        else if (operasjon.equals("/")) {nyBrok = brok.getDiv(brok2);}
        else {System.out.println("Operasjon ikke godkjent");}
        
        System.out.print(brok.forkortOgPrint(nyBrok));

    }
}