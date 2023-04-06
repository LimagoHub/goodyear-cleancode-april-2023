package uebung.generator;

public class RandomGeneratorBuilderImpl implements GeneratorBuilder{
    @Override
    public Generator create() {
        return new RandomGeneratorImpl();
    }
}
