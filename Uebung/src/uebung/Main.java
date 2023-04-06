package uebung;

import uebung.client.ArrayClient;
import uebung.generator.GeneratorBuilder;
import uebung.generator.RandomGeneratorBuilderImpl;
import uebung.time.BenchmarkProxy;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private int feld[] = new int[Integer.MAX_VALUE/2];
    private int runningThreads;
    private ExecutorService service;

    public static void main(String[] args) {
        for (int runningThreads = 1; runningThreads <= Runtime.getRuntime().availableProcessors()+1 ; runningThreads++) {
            GeneratorBuilder generatorBuilder = new RandomGeneratorBuilderImpl();
            ArrayService arrayService = new ParallelArrayServiceImpl(generatorBuilder,runningThreads);

            arrayService = (ArrayService) BenchmarkProxy.newInstance(arrayService);

            ArrayClient client = new ArrayClient(arrayService);
            client.doSomethingWithFilledArray();
        }


       // new Main().run();
    }


}