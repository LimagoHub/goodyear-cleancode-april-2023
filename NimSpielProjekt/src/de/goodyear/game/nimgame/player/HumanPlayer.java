package de.goodyear.game.nimgame.player;

import java.util.Scanner;

public class HumanPlayer extends AbstractNimGamePlayer{

    private static final String USER_PROMPT = "Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3.";
    private final Scanner scanner = new Scanner(System.in);
    public HumanPlayer() {
    }

    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public Integer doTurn(final Integer stones) {
        System.out.println(String.format(USER_PROMPT, stones));
        return  scanner.nextInt();
    }
}
