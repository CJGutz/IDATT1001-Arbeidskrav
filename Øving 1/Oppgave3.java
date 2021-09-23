import java.util.*;

class Oppgave3{
    public static void main(String[] args){

        int sekIMin = 60;
        int sekITime = 3600;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sekunder:");
        int sekAngitt = scanner.nextInt();

        int timer = sekAngitt / sekITime;
        int min = (sekAngitt % sekITime) / sekIMin;
        int sek = (sekAngitt % sekITime) % sekIMin;

        System.out.println("Timer: " + timer + ", Minutter: " + min + ", Sekunder: " + sek);

        int[] testDatasett = {5425,1,456,65,345435};

        for (int i = 0; i < testDatasett.length; i++) {
        int timerData = testDatasett[i] / sekITime;
        int minData = (testDatasett[i] % sekITime) / sekIMin;
        int sekData = (testDatasett[i] % sekITime) % sekIMin;

        System.out.println("Timer: " + timerData + ", Minutter: " + minData + ", Sekunder: " + sekData);
        }
    }
}