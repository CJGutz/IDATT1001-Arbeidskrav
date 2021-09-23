final class NyString {
    final String[] nyString;

    public NyString(String[] nyString) {
        this.nyString = nyString;
    }

    public String forkorting() {;
        String forkortelse = "";
        for (String i : this.nyString) {
            forkortelse += i.charAt(0); 
        } 
        return forkortelse;
    }

    public String fjern(String b) {
        String bokstav = b;
        String tekst = "";
        for (String i : this.nyString) {
            for (int j = 0; j < i.length(); j++) {
                if (i.codePointAt(j) == bokstav.codePointAt(0)) {
                    tekst = tekst;
                } else {
                    tekst += i.charAt(j);
                }
            }
            tekst += " ";
            
        }
        return tekst;
    }
}