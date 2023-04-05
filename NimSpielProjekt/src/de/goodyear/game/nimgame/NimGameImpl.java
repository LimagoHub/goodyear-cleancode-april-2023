package de.goodyear.game.nimgame;

import de.goodyear.game.AbstractGame;
import de.goodyear.io.Writer;


public class NimGameImpl extends AbstractGame<Integer,Integer> {


    public NimGameImpl(final Writer writer) {
        super(writer);
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

    @Override
    protected void prepare() {
        write(getCurrentPlayer().getName() + " ist am Zug");
    }
}
