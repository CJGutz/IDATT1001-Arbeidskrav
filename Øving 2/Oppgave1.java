import java.util.*;

class Oppgave1{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Årstall:");
        int arstall = scanner.nextInt();

        if (arstall % 100 == 0) {
            if (arstall % 400 == 0) {
                System.out.println("Året er et skuddår.");
            } else {
                System.out.println("Året er ikke et skuddår.");
            }
        } else {
            if (arstall % 4 == 0) {
                System.out.println("Året er et skuddår");
            } else {
                System.out.println("Året er ikke et skuddår.");
            }
        }

    }
}