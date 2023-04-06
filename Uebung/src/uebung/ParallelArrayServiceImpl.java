package uebung;

import uebung.generator.Generator;
import uebung.generator.GeneratorBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelArrayServiceImpl implements ArrayService{

    private int feld[] = new int[1];
    private final int  runningThreads;
    private ExecutorService service;
    private final GeneratorBuilder generatorBuilder;

    public ParallelArrayServiceImpl(GeneratorBuilder generatorBuilder, int runningThreads) {
        this.generatorBuilder = generatorBuilder;
        this.runningThreads = runningThreads;
    }

    @Override
    public void fillArray(int[] data) {
        this.feld = data;
        run();
    }

    private void run() {



        try {
            runImpl();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runImpl() throws InterruptedException {

        startThreadPoolForArrayFilling();

    }



    private void startThreadPoolForArrayFilling() throws InterruptedException {
        service = Executors.newFixedThreadPool(runningThreads);
        startWorkerPerActiveThread();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startWorkerPerActiveThread() {
        for (int actThread = 0; actThread < runningThreads; actThread++) {
            startSingleWorkerForSegment(actThread);
        }
    }

    private void startSingleWorkerForSegment(final int actThread) {
        final int segmentSize = feld.length/ runningThreads;
        final int start = actThread *segmentSize;
        final int end = start+segmentSize;
        service.execute(new FillSegmentWorker(start, end));
    }
    class FillSegmentWorker implements Runnable{

        private final int start;
        private final int end;

        public FillSegmentWorker(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            Generator generator = generatorBuilder.create();
            for (int i = start; i < end; i++) {
                feld[i] = generator.next();
            }
        }
    }
}


