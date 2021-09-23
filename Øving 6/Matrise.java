class  Matrise{
    final int[][] matrise;

    public Matrise(int[][] matrise) {
        this.matrise = matrise;
    }

    public Matrise summer(Matrise m2) {
        Matrise kopi = new Matrise(new int[this.matrise.length][this.matrise[0].length]);
        if (this.matrise.length != m2.matrise.length) {return null;}
        for (int i = 0; i < m2.matrise.length; i++) {
            if (this.matrise[i].length != m2.matrise[i].length) {return null;}
            for (int j = 0; j < m2.matrise[i].length;j++) {
                kopi.matrise[i][j] = m2.matrise[i][j] + this.matrise[i][j];
            }
        }
        return kopi;
    }


    public Matrise multipliser(Matrise m2) {
        Matrise kopi = new Matrise(new int[this.matrise.length][m2.matrise[0].length]);
        if (this.matrise[0].length != m2.matrise.length) {return null;}
        for (int i = 0; i < m2.matrise[0].length; i++) {
            for (int j = 0; j < this.matrise.length; j++) {
                for (int k = 0; k < this.matrise[0].length; k++) {
                    kopi.matrise[j][i] = kopi.matrise[j][i] + this.matrise[j][k] * m2.matrise[k][i];
                }
            }
        }
     
        return kopi;
    }

    public Matrise transponer() {
        int[][] array = new int[this.matrise[0].length][this.matrise.length];

        for (int i = 0; i < this.matrise.length; i++) {
            for (int j = 0; j < this.matrise[0].length; j++) {
                array[j][i] = this.matrise[i][j];
            }
        }
        return new Matrise(array);
    }

    public void print() {
        System.out.println("\n");
        if (this.matrise == null) {
            System.out.println("Operasjon umulig");
        }
        else {
            for (int i = 0; i < this.matrise.length; i++) {
                String print = "[ ";
                for (int j = 0; j < this.matrise[i].length; j++) {
                    print += Integer.toString(this.matrise[i][j]) + " ";
                }
                print += "]";
                System.out.println(print);
            }
        }
        System.out.println("\n");
    }
}