package uebung.generator;

import java.util.Random;

public class RandomGeneratorImpl implements Generator {

    private final Random random = new Random();


    @Override
    public int next() {
        return random.nextInt();
    }
}
