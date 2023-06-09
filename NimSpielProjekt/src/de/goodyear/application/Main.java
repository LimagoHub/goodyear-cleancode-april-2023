package de.goodyear.application;


import de.goodyear.client.GameClient;
import de.goodyear.game.AbstractGame;
import de.goodyear.game.Game;
import de.goodyear.game.nimgame.NimGameImpl;
import de.goodyear.game.nimgame.player.ComputerPlayer;
import de.goodyear.game.nimgame.player.HumanPlayer;
import de.goodyear.io.ConsolenWriter;
import de.goodyear.io.Writer;

public class Main {
    public static void main(String[] args) {

        Writer writer = new ConsolenWriter();
        NimGameImpl game  = new NimGameImpl(writer);
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(game);
        client.go();

    }
}