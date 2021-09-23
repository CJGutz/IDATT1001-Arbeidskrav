class Oppgave2{
    public static void main(String[] args) {
        minRandom tilfeldig = new minRandom();

        for (double i = 0; i < 10; i++) {
            for (double j = 10; j < 20; j++) {
                int heltall = tilfeldig.nesteHeltall((int)i,(int)j);
                double desimaltall = tilfeldig.nesteDesimaltall(1/20,1);
                System.out.println("Heltall: " + heltall);
                System.out.println("Desimaltall: " + desimaltall);                
            }
        }
    }
} 