package com.elssu.vko12;

public class GameManager {
    private static GameManager gameManager = null;

    private GameManager(){}
    public Player getPlayer() {
        Player player = null;
        return player;
    }

    public static GameManager getInstance() {
        if(gameManager == null);{
            gameManager = new GameManager();
        }
        return gameManager;
    }
}