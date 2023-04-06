package app;

import de.tiere.Schwein;

public class Main {
    public static void main(String[] args) {
        Schwein piggy = new Schwein("Miss Piggy");

        System.out.println(piggy);  // 10

        piggy.fuettern();

        System.out.println(piggy); // 10 spontan

        while(piggy.getGewicht()<11) {
            // Do nothing
        }

        System.out.println(piggy); // 11 nach 2 Sekunden
    }
}