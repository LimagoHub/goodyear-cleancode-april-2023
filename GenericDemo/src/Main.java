import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        List<Tier> tiere = new ArrayList<>();

        tiere.add(new Tier());
        tiere.add(new Katze());

        List<Katze> katzen = new ArrayList<>();
        katzen.add(new Katze());
        //katzen.add(new Hund());

        List<Hund> hunde = new ArrayList<>();
        hunde.add(new Pudel());
        hunde.add(new Hund());

        // List<Tier> nochMehrTiere = new ArrayList<Hund>(); nicht erlaubt
        print(tiere);
        print(hunde);
        print(katzen);

        List<? super Tier> liste = getFilledList();
        liste.add(new Katze());

        for(Object obj: liste) {
            System.out.println(obj);
        }
    }

    private void print(List<? extends Tier> tiere) {



        for (Tier tier : tiere) {
            System.out.println(tier);
        }
    }

    private List<? super Tier> getFilledList() {

        List<Object> tiere = new ArrayList<>();
        tiere.add(new Hund());

        return  tiere;
    }
}



class Tier {

}

class Katze extends Tier {

}

class Hund extends Tier {

}

class Pudel extends Hund {

}
class Kunde {

}