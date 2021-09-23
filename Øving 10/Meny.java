import java.util.HashMap;

class Meny {

    private HashMap<String, Rett> retter;
    private double totalpris;

    public Meny(HashMap<String, Rett> retter) {
        this.retter = retter;

        totalpris = 0;
        for (Rett rett : retter.values()) {
            if (rett.equals(null)) {throw new NullPointerException("dish is nullobject");}
            totalpris += rett.getPris();
        }
    }

    public HashMap<String, Rett> getRetter() {
        return retter;
    }
    
    public double getTotalpris() {
        return totalpris;
    }

    public String toString() {
        String returnString = "";
        for (Rett rett : retter.values()) {
            returnString += "\n     " + rett;
        }
        return returnString;
    }

}