package com.elssu.vko12;

import java.util.ArrayList;

public class GameManager {
    private static GameManager gameManager = null;
    private static Monster latestMonster;

    public ArrayList<Monster> monsters = new ArrayList<>();
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
    public Monster generateMonster() {
        boolean stuff = Math.random() < 0.5;
        Monster monster;
        if(stuff){
            monster = new Skeleton("name", 1);

        }else{
            monster = new Vampire("name", 1);

        }
        latestMonster = monster;
        return latestMonster;
    }


    public Monster getLatestMonster() {
        return latestMonster;
    }
}