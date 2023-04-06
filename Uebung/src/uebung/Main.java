package uebung;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    private int feld[] = new int[Integer.MAX_VALUE/2];

    public static void main(String[] args) {


        new Main().run();
    }

    private void run() {
        for (int runningThreads = 1; runningThreads <= Runtime.getRuntime().availableProcessors() ; runningThreads++) {
            System.out.println("Start...");
            Random random = new Random();
            var start = Instant.now();
            for (int i = 0; i < feld.length; i++) {
                feld[i] = random.nextInt();
            }
            var ende = Instant.now();
            var duration = Duration.between(start, ende);
            System.out.println("Duration = " + duration.toMillis());
        }

    }
}