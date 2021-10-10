import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Dimension;

class Oppgave2 {

    static ArrayList<JComboBox<String>> rettValger;
    static final String[] TYPER = {"Antipasto", "Brunsj", "Dessert", "Forett", "Frokost", "Hovedrett", "Lunsj", "Primi Piatti", "Side", "Vegetar", "Vegan"};

    public static void main(String[] args) {

        MenyRegister register = new MenyRegister();
        JFrame frame = new JFrame();
        JFrame konsoll = new JFrame();

        // Lag knapper
        JButton registrerRettKnapp = new JButton("Registrer rett");
        JButton rettGittNavnKnapp = new JButton("Finn rett med navn");
        JButton rettGittTypeKnapp = new JButton("Finn retter med type");
        JButton nyMenyKnapp = new JButton("Registrer ny meny");
        JButton finnMenyKnapp = new JButton("Finn meny");

        // Lag JLabel
        JLabel outputLabel = new JLabel();

        // Actionlistener til alle knapper
        registrerRettKnapp.addActionListener( e -> { // registrer ny rett

            frame.setVisible(false);
            JFrame nyFrame = new JFrame();

            // JComponents
            JTextField navnField = new JTextField();
            JTextField prisField = new JTextField();
            JComboBox<String> typeValg = new JComboBox<String>(TYPER);
            JTextField oppskriftField = new JTextField();
            JButton leggTilKnapp = new JButton("Legg til");
            JButton tilbakeknapp = new JButton("Tilbake");
            
            // JLabel
            JLabel navnLabel = new JLabel("Navn:");
            JLabel prisLabel = new JLabel("Pris:");
            JLabel typeLabel = new JLabel("Type:");
            JLabel oppskriftLabel = new JLabel("Oppskrift:");

            
            // legg til info
            leggTilKnapp.addActionListener((event) -> {

                // Få info fra field
                String navn = String.valueOf(navnField.getText());

                Double pris;
                try { pris = Double.parseDouble(prisField.getText()); }
                catch (NumberFormatException exception) {pris = 0.0;}

                String type = String.valueOf(typeValg.getItemAt(typeValg.getSelectedIndex()));

                String oppskrift = String.valueOf(oppskriftField.getText());

                // Registrer rett og print ut
                register.nyRett(navn, pris, type, oppskrift);
                
                outputLabel.setText(tilMultiLinje(register.toString()));

                //endre frame
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // tilbake
            tilbakeknapp.addActionListener((event) -> {
                // steng vindu og gå tilbake
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // Legg til JComponents til JFrame
            nyFrame.add(navnLabel); nyFrame.add(navnField);
            nyFrame.add(prisLabel); nyFrame.add(prisField);
            nyFrame.add(typeLabel); nyFrame.add(typeValg);
            nyFrame.add(oppskriftLabel); nyFrame.add(oppskriftField);
            nyFrame.add(tilbakeknapp); nyFrame.add(leggTilKnapp);

            // Layout
            nyFrame.setLayout(new GridLayout(9,1, 25, 25));

            // JFrame innstillinger
            nyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nyFrame.setSize(500,500);
            nyFrame.setVisible(true);
            
        });

        rettGittNavnKnapp.addActionListener(e -> { // finn info om rett med gitt navn

            frame.setVisible(false);
            JFrame nyFrame = new JFrame();

            // JComponents
            JComboBox<String> navnValg = new JComboBox<String>();
            for (Rett rett : register.getRetter().values()) {
                navnValg.addItem(rett.getNavn());
            }
            JButton finnKnapp = new JButton("Finn");
            JButton tilbakeKnapp = new JButton("Tilbake");

            // JLabel
            JLabel navnLabel = new JLabel("Navn:");
            
            // finn med navn
            finnKnapp.addActionListener((event) -> {
                // Få info fra field og print resultat
                String navn = String.valueOf(navnValg.getItemAt(navnValg.getSelectedIndex()));

                try {
                    outputLabel.setText(tilMultiLinje(register.finnRettFraNavn(navn).toString()));
                } catch (NullPointerException exception) {
                    outputLabel.setText("Ingen rett valgt");
                } 
                // endre frame
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // tilbake
            tilbakeKnapp.addActionListener((event) -> {
                // steng vindu og gå tilbake
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // Legg til JComboBox, JLabel og JButton til JFrame
            nyFrame.add(navnLabel); nyFrame.add(navnValg);
            nyFrame.add(tilbakeKnapp); nyFrame.add(finnKnapp); 

            // Layout
            nyFrame.setLayout(new GridLayout(3,1,20,150));
            
            // JFrame innstillinger
            nyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nyFrame.setSize(500,500);
            nyFrame.setVisible(true);
        });

        rettGittTypeKnapp.addActionListener(e -> { // finn info om retter med gitt type

            frame.setVisible(false);
            JFrame nyFrame = new JFrame();

            // JComponents
            JComboBox<String> typeValg = new JComboBox<String>();
            for (Rett rett : register.getRetter().values()) {
                typeValg.removeItem(rett.getType());
                typeValg.addItem(rett.getType());
            } 
            JButton finnKnapp = new JButton("Finn");
            JButton tilbakeKnapp = new JButton("Tilbake");

            // JLabel
            JLabel typeLabel = new JLabel("Type:");
            
            // finn med type
            finnKnapp.addActionListener((event) -> {
                // Få info fra field og print resultat
                String type = String.valueOf(typeValg.getItemAt(typeValg.getSelectedIndex()));
                
                ArrayList<Rett> retter;
                try {

                    retter = register.finnRettFraType(type);
                    String retterString = "";
                    for (Rett rett : retter) {
                        retterString += rett + "\n";
                    }
                    outputLabel.setText(tilMultiLinje(retterString));  

                } catch (NullPointerException exception) {
                    outputLabel.setText("Ingen type valgt");
                }

                // endre frame
                nyFrame.setVisible(false);
                frame.setVisible(true);

            });

            // tilbake
            tilbakeKnapp.addActionListener((event) -> {
                // steng vindu og gå tilbake
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // Legg til JField til JFrame
            nyFrame.add(typeLabel); nyFrame.add(typeValg);
            nyFrame.add(tilbakeKnapp); nyFrame.add(finnKnapp);

            // Layout
            nyFrame.setLayout(new GridLayout(3,1,20,150));

            // JFrame innstillinger
            nyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nyFrame.setSize(500,500);
            nyFrame.setVisible(true);
        });

        nyMenyKnapp.addActionListener(e -> { // registrer ny meny

            frame.setVisible(false);
            JFrame nyFrame = new JFrame();

            // JComponents
            JButton leggTilKnapp = new JButton("+");
            JButton lagKnapp = new JButton("Lag meny");
            JButton tilbakeKnapp = new JButton("Tilbake");

            // antall retter og feltene
            rettValger = new ArrayList<JComboBox<String>>();
            
            // legg til rett
            leggTilKnapp.addActionListener(event -> {

                JComboBox<String> rettValg = new JComboBox<String>();
                for (Rett rett : register.getRetter().values()) {rettValg.addItem(rett.getNavn());}
                rettValger.add(rettValg);

                JLabel rettLabel = new JLabel("Ny rett:");
                nyFrame.add(rettLabel);
                nyFrame.add(rettValg);
                nyFrame.setVisible(true);
            });

            // lag meny
            lagKnapp.addActionListener((event) -> {
                // Få info fra field og lag meny

                HashMap<String, Rett> alleRetter = register.getRetter();
                HashMap<String, Rett> menyRetter = new HashMap<String, Rett>();

                for (JComboBox<String> rettValg : rettValger) {
                    String rettNavn = String.valueOf(rettValg.getItemAt(rettValg.getSelectedIndex()));
                    menyRetter.put(rettNavn, alleRetter.get(rettNavn));
                }

                try {
                    if (menyRetter.size() != 0) {
                        register.nyMeny(menyRetter);
                        outputLabel.setText(tilMultiLinje("\nRegisteret:\n" + register.toString()));
                    } else {
                        outputLabel.setText("Ingen meny registrert");
                    }

                } catch (NullPointerException exception) {

                    outputLabel.setText("Ikke gyldig meny");

                }
                // endre frame
                nyFrame.setVisible(false);
                frame.setVisible(true);
            
            });

            // tilbake
            tilbakeKnapp.addActionListener((event) -> {
                // steng vindu og gå tilbake
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });
            
            // Legg til JField til JFrame
            nyFrame.add(tilbakeKnapp); nyFrame.add(leggTilKnapp);
            nyFrame.add(lagKnapp);

            // Layout
            nyFrame.setLayout(new GridLayout(10,1));

            // JFrame innstillinger
            nyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nyFrame.setSize(500,500);
            nyFrame.setVisible(true);
        });

        finnMenyKnapp.addActionListener(e -> { // finn menyer mellom to totalpriser

            frame.setVisible(false);
            JFrame nyFrame = new JFrame();

            // JComponents
            JTextField pris1Field = new JTextField();
            JTextField pris2Field = new JTextField();
            JButton finnKnapp = new JButton("Finn");
            JButton tilbakeKnapp = new JButton("Tilbake");

            // JLabel
            JLabel pris1Label = new JLabel("Pris #1:");
            JLabel pris2Label = new JLabel("Pris #2:");
            
            // finn med type
            finnKnapp.addActionListener((event) -> {

                // Få info fra field og print resultat
                Double pris1;
                try { pris1 = Double.parseDouble(pris1Field.getText()); }
                catch (NumberFormatException exception) {pris1 = 0.0;}

                Double pris2;
                try { pris2 = Double.parseDouble(pris2Field.getText()); }
                catch (NumberFormatException exception) {pris2 = 0.0;}
                
                ArrayList<Meny> menyer = register.finnMeny(pris1, pris2);

                String menyerString = (menyer.size() != 0) ? "" : "Ingen menyer funnet";
                for (Meny meny : menyer) {
                    menyerString += "\nMenyen har totalprisen " + meny.getTotalpris() + "kr:\n" + meny;
                }

                outputLabel.setText(tilMultiLinje(menyerString));

                // endre frame
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // tilbake
            tilbakeKnapp.addActionListener((event) -> {
                // steng vindu og gå tilbake
                nyFrame.setVisible(false);
                frame.setVisible(true);
            });

            // Legg til komponenter til JFrame
            nyFrame.add(pris1Label); nyFrame.add(pris1Field);
            nyFrame.add(pris2Label); nyFrame.add(pris2Field);
            nyFrame.add(tilbakeKnapp); nyFrame.add(finnKnapp);

            // Layout
            nyFrame.setLayout(new GridLayout(3,1, 0, 150));

            // JFrame innstillinger
            nyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nyFrame.setSize(500,500);
            nyFrame.setVisible(true);
        });

        // Legg til knapper
        konsoll.add(outputLabel);

        frame.add(registrerRettKnapp);
        frame.add(rettGittNavnKnapp);
        frame.add(rettGittTypeKnapp);
        frame.add(nyMenyKnapp);
        frame.add(finnMenyKnapp);

        // Rediger JFrames
        konsoll.setLayout(new FlowLayout(FlowLayout.CENTER, 130,50));
        konsoll.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        konsoll.setSize(600,300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        konsoll.setLocation(dim.width/2, dim.height/2-konsoll.getSize().height/2);
        konsoll.setVisible(true);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 130,50));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocation(dim.width/2-frame.getSize().width, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);

    }

    public static String tilMultiLinje(String enLinjeString) {

        return "<html>" + enLinjeString.replaceAll("\n", "<br>");
    }
}