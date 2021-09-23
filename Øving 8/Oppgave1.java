import java.util.*;

public class Oppgave1 {
    public static void main(String[] args) {
            new Meny();
    }       
}

class Meny{

    Scanner in;
    ArbTaker[] arbeidere;
    int arbeiderPlass;
    int aarGitt = 1;
    Person person;
    ArbTaker arbeider;


    public Meny() {
        in = new Scanner(System.in); 
        arbeiderPlass = 0;
        arbeidere = new ArbTaker[1];


        boolean hovedMenyFerdig = false;
        while(!hovedMenyFerdig) {
            System.out.println("\nChoose:");
            System.out.println("  1. Add employee");
            System.out.println("  2. Edit employee");
            System.out.println("  3. End");

            int operasjon = tryCatchInt();

            if (operasjon == 1) { // Add employee
                leggTilArbTaker();
                for (int i = arbeidere.length-1; i >= 0; i--) {
                    if (arbeidere[i] != null) {
                        printInfo(i, false, true);
                        break;
                    }
                }
            } else if (operasjon == 2) { // Edit employee
                System.out.println(person);
                if (arbeidere[0] == null) {
                    System.out.println("No employees added");
                } else {
                    endreArbTaker();
                }
            } else { // End
                System.out.println("End");
                hovedMenyFerdig = true;
            }
        }
    }

    public void leggTilArbTaker() {

        in = new Scanner(System.in);

        String[] sporsmaal = {"First name: ", 
                              "Surname: ", 
                              "Birthyear: ", 
                              "Employee number: ", 
                              "Year employed: ", 
                              "Monthly salary in NOK: ", 
                              "Taxrate: "};

        String[] svar = new String[sporsmaal.length];

        for (int i = 0; i < sporsmaal.length; i++) {
            System.out.print(sporsmaal[i]);
            svar[i] = in.nextLine();
        }

        person = new Person(svar[0], svar[1], svar[2]); // person kan eksistere uten å være arbTaker; agregering 

        arbeider = new ArbTaker(person,svar[3],svar[4],svar[5],svar[6]);

        arbeidere = addX(arbeiderPlass, arbeidere, arbeider);
        /* arbeidere[arbeiderPlass] = arbeider; */
        arbeiderPlass++;
    }



    public void endreArbTaker() {
        for (int i = 0; i < arbeidere.length; i++) {
            if (arbeidere[i] != null) {
                System.out.println(i+1 + ". " + arbeidere[i].getNavn() + ".");
            }
        }

        int velgArbeider = tryCatchInt();
        if (velgArbeider == 0) {return;}

        boolean endreMenyFerdig = false;
        while (!endreMenyFerdig) {
            System.out.println("Choose for " + arbeidere[velgArbeider-1].getNavn() + ":");
            System.out.println("  1. Change monthly salary");
            System.out.println("  2. Change taxrate");
            System.out.println("  3. Print out information");
            System.out.println("  4. End");

            int endreOperasjon = tryCatchInt();
            if (endreOperasjon == 0) {return;}

            if (endreOperasjon == 1) { // Change monthly salary
                System.out.print("New montly salary: ");
                int nyMndLnn = tryCatchInt();
                arbeidere[velgArbeider-1].setMaanedsloenn(nyMndLnn);
                System.out.println("New monthly salary is " + arbeidere[velgArbeider-1].getMaanedsloenn() + " NOK");
            } else if (endreOperasjon == 2) { // Change taxrate
                System.out.print("New taxrate: ");
                int nySkttPrsnt = tryCatchInt();
                arbeidere[velgArbeider-1].setSkatteprosent(nySkttPrsnt);
                System.out.println("New taxrate is " + arbeidere[velgArbeider-1].getSkatteprosent() + " %");
            } else if (endreOperasjon == 3) { // Print out information
                printInfo(velgArbeider-1,true, true);
            } else { // End
                endreMenyFerdig = true; 
            }
        }
    }



    public void printInfo(int i, boolean basicInfo, boolean allInfo) {
        if (basicInfo) {
            System.out.println("\nFirst name is " + arbeidere[i].personalia.getFornavn());
            System.out.println("Surname is " + arbeidere[i].personalia.getEtternavn());
            System.out.println("Birthyear is " + arbeidere[i].personalia.getFoedselaar());
            System.out.println("Employee number is " + arbeidere[i].getArbtakerNr());
            System.out.println("Year employed is " + arbeidere[i].getAnsettelsesaar());
            System.out.println("Monthly salary is " + arbeidere[i].getMaanedsloenn() + " NOK");
            System.out.println("Taxrate is " + arbeidere[i].getSkatteprosent() + " %");
        } 
        if (allInfo) {
            System.out.println("\nFull name is " + arbeidere[i].getNavn());
            System.out.println("Age is " + arbeidere[i].getAlder());
            System.out.println("Number of years employed is " + arbeidere[i].getAarAnsatt() + " years");
            System.out.println("Tax per month is " + arbeidere[i].getSkattIMaaned() + " NOK");
            System.out.println("Yearly salary is " + arbeidere[i].getBruttoloenn() + " NOK");
            System.out.println("Tax deductible is " + arbeidere[i].getSkattetrekk() + " NOK");
            System.out.println("\nHave this employee worked longer than x years?");
            System.out.print("x: ");
            aarGitt = tryCatchInt();
            System.out.println(arbeidere[i].omAnsattLengerEnn(aarGitt));
        }
        
    }



    public int tryCatchInt() {
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error occured --> returning 0 and ending"); 
            return 0; // Hvorfor gjør den om alle varibaler som bruker samme metode til 0?
        }
    }

    public static ArbTaker[] addX(int n, ArbTaker[] arr, ArbTaker x) {
        int i;
  
        ArbTaker newarr[] = new ArbTaker[n + 1];
  
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
  
        newarr[n] = x;
  
        return newarr;
    }
}
