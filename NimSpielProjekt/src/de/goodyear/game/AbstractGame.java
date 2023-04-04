package de.goodyear.game;

import de.goodyear.game.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame <BOARD, TURN> implements Game{


    private BOARD board;

    private TURN turn;

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




    @Override
    public void play() {
        while ( ! isGameover()) {
            playRounds();
        }
    }

    private void playRounds() {
        for(var player : players) {
            setCurrentPlayer(player);
            playSingleTurn();
        }
    }

    private void playSingleTurn() {
        if(isGameover()) return;
        executeTurnForCurrentPlayer();
        terminateTurn();
    }

    private void executeTurnForCurrentPlayer() {

        do {
            turn = getCurrentPlayer().doTurn(board);
        } while(turnIsInvalid());
    }
    private void terminateTurn( ) {// Integration
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }

    private boolean turnIsInvalid() {
        if(isTurnValid()) {
            return false;
        }
        System.out.println("Ungueltiger Zug");
        return true;
    }

    private void printGameOverMessageIfGameIsOver() {
        if (isGameover()) {
            System.out.println(getCurrentPlayer().getName() +  " hat verloren");
        }
    }

    protected abstract boolean isTurnValid();
    protected abstract void updateBoard() ;

    protected abstract  boolean isGameover();

}
