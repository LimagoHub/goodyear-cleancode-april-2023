package de.tiere;

public class Schwein {

    private String name;
    private volatile int gewicht; // Volatile schaltet Optimierung ab (keine Registervariable)

    public Schwein(String name) {
        this.name = name;
        this.gewicht = 10;
    }

    public void fuettern() {   // Asyn

         new Thread(this::fuetternImpl).start();
    }

    private void fuetternImpl() {
        try {
            Thread.sleep(2000);
            gewicht ++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }

//    class SchweineRunner extends Thread {
//        @Override
//        public void run() {
//           fuetternImpl();
//        }
//    }
}
