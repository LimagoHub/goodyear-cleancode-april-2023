package de.goodyear.game.nimgame;

import de.goodyear.game.Game;

import java.util.Scanner;

public class NimGameImpl implements Game {

    private final Scanner scanner = new Scanner(System.in);

    private int stones;

    private int turn;

    public NimGameImpl() {
        stones = 23;

    }

    @Override
    public void play() {
       while ( ! isGameover()) {
           playRounds();
       }
    }

    private void playRounds() {
        humanTurn();
        computerTurn();
    }

    private void humanTurn() {
        if(isGameover()) return;


        while(true) {
            System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3.", stones));
            turn = scanner.nextInt();
            if(turn >= 1 && turn <= 3) break;
            System.out.println("Ungueltiger Zug");
        }

        terminateTurn("Mensch");
    }
    private void computerTurn() {

        if(isGameover()) return;

        final int turns[] = {3,1,1,2};
        turn = turns[stones % 4];

        System.out.println(String.format("Computer nimmt %s Steine.", turn));

        terminateTurn("Computer");

    }

    private void terminateTurn( String player) {// Integration
        updateBoard();
        printGameOverMessageIfGameIsOver(player);
    }

    private void printGameOverMessageIfGameIsOver(String player) {
        if (isGameover()) {
            System.out.println(player +  " hat verloren");
        }
    }

    private void updateBoard() {
        stones -= turn;
    }

    private boolean isGameover() {
        return stones < 1;
    }
}
