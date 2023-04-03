package de.goodyear.application;


import de.goodyear.client.GameClient;
import de.goodyear.game.Game;
import de.goodyear.game.nimgame.NimGameImpl;

public class Main {
    public static void main(String[] args) {

        Game game  = new NimGameImpl();
        GameClient client = new GameClient(game);
        client.go();

    }
}