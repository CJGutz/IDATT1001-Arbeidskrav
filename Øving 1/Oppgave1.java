class Oppgave1{
    public static void main(String[] args){
        double tommeCentiFaktor = 2.54;

        double[] testDatasett = {5.6, 2.5, 9.5, 1, 3};

        for (int i = 0; i < testDatasett.length; i++) {
            System.out.println("Centimeter: " + (testDatasett[i] * tommeCentiFaktor));
        }
    }
}