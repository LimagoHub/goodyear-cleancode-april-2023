package de.goodyear.client;

import de.goodyear.game.Game;

public class GameClient {

    private final Game game;

    public GameClient(Game game) {
        this.game = game;
    }

    public void go() {
        game.play();
    }
}
