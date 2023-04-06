import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        new Main().run();
    }

    private void run() {

        try {

//            ExecutorService service = Executors.newFixedThreadPool(10);
//            for (int i = 0; i < 10; i++) {
//                service.execute(new MyRunner());
//            }
//            service.shutdown();// Keine Neuaufnahme von Runnables
//            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS); // Wartet bis alle Threads fertig sind oder die Wartezeit abgelaufen ist
//            System.out.println("Fertig");

            ExecutorService service = Executors.newFixedThreadPool(2);
            Future<Integer> f1 = service.submit(new SinnDesLebens());// 10
            Future<Integer> f2 = service.submit(new SinnDesLebens());//100
            service.shutdown();
            int ergebnis1 = f1.get();
            int ergebnis2 = f2.get();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    class MyRunner implements Runnable {

        @Override
        public void run() {
            try {
                long time = (long)(Math.random()*2000);
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getId() + " wurde beendet nach " + time + " Millis");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class SinnDesLebens implements Callable<Integer> {


        @Override
        public Integer call() throws Exception {
            long time = (long)(Math.random()*2000);
            Thread.sleep(time);
            return  42;
        }
    }
}