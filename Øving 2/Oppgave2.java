class Oppgave2{
    public static void main(String[] args) {

        double[][] data = {{35.9,450},{39.5,500}}; // data: {pris per stykk, vekt i gram}

        double kgPris;
        for (int i = 0; i < data.length; i++) {
            kgPris = data[i][0] / data[i][1] * 1000;
            System.out.println("Kiloprisen til produkt nr. " + (i + 1) + " er " + kgPris + " kr. ");
        }
    }
}