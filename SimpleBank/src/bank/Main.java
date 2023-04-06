package bank;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();


        Angestellter a1 = new Angestellter(bank, 0, 1, 20);
        Angestellter a2 = new Angestellter(bank, 1, 2, 20);
        Angestellter a3 = new Angestellter(bank, 2, 0, 20);


        System.out.println("Kontostand vorher:");
        bank.kontoStand();

        a1.start();
        a2.start();
        a3.start();
    }
}