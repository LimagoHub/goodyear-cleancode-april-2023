package de.goodyear.game.nimgame;

import de.goodyear.game.AbstractGame;


public class NimGameImpl extends AbstractGame<Integer,Integer> {


    public NimGameImpl() {
        setBoard(23);

    }

    protected boolean isTurnValid() {
        return getTurn() >= 1 && getTurn() <= 3;
    }
    protected void updateBoard() {
        setBoard(getBoard() - getTurn());
    }

    protected boolean isGameover() {
        return getBoard() < 1 || getPlayers().isEmpty();
    }
}
