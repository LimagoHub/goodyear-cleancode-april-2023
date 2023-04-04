package de.goodyear.game.nimgame.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final String MESSAGE = "Computer nimmt %s Steine.";
    private static final int TURNS[] = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(String name) {
        super(name);
    }


    @Override
    public Integer doTurn(final Integer stones) {
        final int turn = TURNS[stones % 4];
        System.out.println(String.format(MESSAGE, turn));
        return turn;
    }
}
