package de.goodyear.application;


import de.goodyear.client.GameClient;
import de.goodyear.game.AbstractGame;
import de.goodyear.game.Game;
import de.goodyear.game.nimgame.NimGameImpl;
import de.goodyear.game.nimgame.player.ComputerPlayer;
import de.goodyear.game.nimgame.player.HumanPlayer;

public class Main {
    public static void main(String[] args) {

        NimGameImpl game  = new NimGameImpl();
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(game);
        client.go();

    }
}