package de.goodyear.game;

import de.goodyear.game.player.Player;
import de.goodyear.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame <BOARD, TURN> implements Game{


    private BOARD board;

    private TURN turn;

    private final Writer writer;

    public AbstractGame(final Writer writer) {
        this.writer = writer;
    }

    private List<Player<BOARD,TURN>> players = new ArrayList<>();
    private Player<BOARD,TURN> currentPlayer;

    protected List<Player<BOARD, TURN>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    private void setCurrentPlayer(Player<BOARD, TURN> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    protected Player<BOARD, TURN> getCurrentPlayer() {
        return currentPlayer;
    }


    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(BOARD board) {
        this.board = board;
    }

    protected TURN getTurn() {
        return turn;
    }

    protected void setTurn(TURN turn) {
        this.turn = turn;
    }

    public void addPlayer(Player<BOARD,TURN> player) {
        players.add(player);
    }
    public  void removePlayer(Player<BOARD,TURN> player) {
        players.remove(player);
    }


    /**
     *
     */
    @Override
    public void play() {
        while ( ! isGameover()) playRounds();
    }

    private void playRounds() {
        for(var player : players) prepareAndPlayTurn(player);
    }

    private void prepareAndPlayTurn(Player<BOARD, TURN> player) {
        setCurrentPlayer(player);
        playSingleTurn();
    }

    private void playSingleTurn() {
        if(initTurn()) return;
        tryTurnUntilItIsValid();
        terminateTurn();
    }

    private boolean initTurn() { // Retval nur status
        prepare();
        return isGameover();
    }

    private void tryTurnUntilItIsValid() {
        // TODO Finde besseren Methodennamen
        do turn = getCurrentPlayer().doTurn(board); while(turnIsInvalid());
    }
    private void terminateTurn( ) {// Integration
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }

    private boolean turnIsInvalid() {
        if(isTurnValid()) return false;
        write("Ungueltiger Zug");
        return true;
    }

    private void printGameOverMessageIfGameIsOver() {
        if (isGameover()) write(getCurrentPlayer().getName() +  " hat verloren");

    }

    protected void prepare() {
        // NOP
    }
    protected void write(String message) {
        writer.write(message);
    }
    protected abstract boolean isTurnValid();
    protected abstract void updateBoard() ;

    protected abstract  boolean isGameover();


}
