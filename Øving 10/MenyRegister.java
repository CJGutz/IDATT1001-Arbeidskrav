import java.util.HashMap;
import java.util.ArrayList;

class MenyRegister {

    ArrayList<Meny> menyer;
    HashMap<String, Rett> retter;

    public MenyRegister() {
        menyer = new ArrayList<Meny>();
        retter = new HashMap<String, Rett>();
    }

    public HashMap<String, Rett> getRetter() {
        return retter;
    }

    public ArrayList<Meny> getMenyer() {
        return menyer;
    }

    public void nyRett(String navn, double pris, String type, String oppskrift) {
        Rett rett = new Rett(navn, pris, type, oppskrift);
        retter.put(navn, rett);
    }

    public Rett finnRettFraNavn(String navn) {
        return retter.get(navn);
    }

    public ArrayList<Rett> finnRettFraType(String type) {
        if (type.equals("null")) {throw new NullPointerException("Type is nullobject");}

        ArrayList<Rett> typeRetter = new ArrayList<Rett>();

        for (Rett rett : retter.values()) {
            if (rett.getType().equals(type)) {
                typeRetter.add(rett);
            }
        }

        return typeRetter;
    }

    public void nyMeny(HashMap<String, Rett> retter) {

        if (retter.size() != 0) {
            Meny meny = new Meny(retter);
            menyer.add(meny);
        }
    }

    public ArrayList<Meny> finnMeny(double p1, double p2) {
        double under = (p1 <= p2) ? p1 : p2;
        double over = (p1 >= p2) ? p1 : p2;

        ArrayList<Meny> funnetMenyer = new ArrayList<Meny>();

        for (Meny meny : menyer) {
            if (meny.getTotalpris() >= under && meny.getTotalpris() <= over) {
                funnetMenyer.add(meny);
            }
        }

        return funnetMenyer;
    }

    public String toString() {
        String returnString = "";

        int i = 1;
        for (Meny meny : menyer) {
            returnString += "\nMeny nummer " + i + " har totalprisen " + meny.getTotalpris() + "kr:\n" + meny + "\n";
            i++;
        }

        returnString += "\nAlle retter:\n";

        for (Rett rett : retter.values()) {
            returnString += "   " + rett + "\n";
        }

        return returnString;
    }

}