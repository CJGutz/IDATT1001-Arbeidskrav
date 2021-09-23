import java.util.*;

class Oppgave2 {
    public static void main(String[] args){

        int sekIMin = 60;
        int sekITime = 3600;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Timer:");
        int time = scanner.nextInt();
        System.out.println("Minutter:");
        int min = scanner.nextInt();
        System.out.println("Sekunder:");
        int sek = scanner.nextInt();

        int totaltSekunder = time * sekITime + min * sekIMin + sek;
        System.out.println("Totalt antall sekunder er: " + totaltSekunder);

        int[][] testDatasett = {{1,754,64}, {9,23,565}, {2,6,0}, {45, 6, 1}};
        for (int i = 0; i < testDatasett.length; i++){
            int total = testDatasett[i][0] * sekITime + testDatasett[i][1] * sekIMin + testDatasett[i][2];
            System.out.println("Totalt antall sekunder er: " + total);
        }


    }
}
