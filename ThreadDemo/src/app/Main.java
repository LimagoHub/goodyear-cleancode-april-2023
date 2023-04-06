package app;

public class Main {
    public static void main(String[] args) throws Exception{

        MyThread hund = new MyThread("Wau");
        MyThread katze = new MyThread("Miau");
        MyThread maus = new MyThread("Piep");

        Thread t1 = new Thread(hund);
        Thread t2 = new Thread(katze);
        Thread t3 = new Thread(maus);


        t1.start();
        t2.start();

        t2.join(); // Blockiert den Main-Thread bis der der Katze Thread durchgelaufen ist
        System.out.println("Hello world!");
        t3.start();


    }
}
