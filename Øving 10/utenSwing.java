import java.util.*;

class utenSwing {

    public static void main(String[] args) {

        MenyRegister register = new MenyRegister();
        Scanner in = new Scanner(System.in);

        boolean fortsett = true;
        while (fortsett) {

            System.out.println("\nMeny: \n    1. Registrer rett\n    2. Finn rett med navn\n    3. Finn retter av gitt type\n    4. Registrer ny meny\n    5. Finn meny mellom to priser\n    Alt annet: Avslutt\n");
        
            int menyValg = (int)tryCatch();

            if (menyValg < 1 || menyValg > 5) {fortsett = false;}

            switch (menyValg) {
                case 1:

                    System.out.print("Navn av retten:  ");
                    String rettNavn = in.nextLine();
                    System.out.print("Pris:  ");
                    double pris = tryCatch();
                    System.out.print("Type rett:  ");
                    String rettType = in.nextLine();
                    System.out.print("Oppskrift:  ");
                    String oppskrift = in.nextLine();

                    register.nyRett(rettNavn, pris, rettType, oppskrift);
                    System.out.println("\n" + register);

                    break;
                case 2:

                    System.out.print("Navn av rett:  ");
                    String navn = in.nextLine();

                    System.out.println(register.finnRettFraNavn(navn));

                    break;
                case 3:

                    System.out.print("Type:  ");
                    String type = in.nextLine();

                    ArrayList<Rett> retter = register.finnRettFraType(type);

                    for (Rett rett : retter) {
                        System.out.println(rett);
                    }

                    break;
                case 4:

                    System.out.print("Antall retter:");
                    int antRetter = (int)tryCatch();

                    HashMap<String, Rett> alleRetter = register.getRetter();
                    HashMap<String, Rett> menyRetter = new HashMap<String, Rett>();

                    for (int i = 0; i < antRetter; i++) {
                        System.out.print("Navn:"  );
                        String rett = in.nextLine();
                        try {
                            menyRetter.put(rett, alleRetter.get(rett));
                        } catch (NumberFormatException e) {
                            System.out.println("Fant ikke rett");
                        }
                    }

                    register.nyMeny(menyRetter);

                    System.out.println("\nRegisteret:\n" + register);

                    break;
                case 5:

                    System.out.print("Pris en:  ");
                    double p1 = tryCatch();
                    System.out.print("Pris to:  ");
                    double p2 = tryCatch();

                    ArrayList<Meny> menyer = register.finnMeny(p1, p2);

                    for (Meny meny : menyer) {
                        System.out.println(meny);
                    }

                    break;
            }
        }
    }   

    public static double tryCatch() {
        Scanner in = new Scanner(System.in);

        try {
            double number = Double.parseDouble(in.nextLine());
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Error ocurred --> returning 0");
            return 0;
        }
    }
}