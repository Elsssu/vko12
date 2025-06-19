package com.elssu.vko12;

import java.util.Random;

public class Vampire extends Monster {
    public Vampire(String name,int maxLife) {
        super(name, maxLife);
        this.maxLife = randomLife();
        this.life = this.maxLife;
        this.names = new String[] {"Count Dracula", "Vlad", "Feratu", "Carmilla", "Colin Robertson" };
        this.name = getRandomName(names);
    }
    private String[] names;

    public String getRandomName (String[] names) {
        if (names == null || names.length == 0) return null;

        Random rand = new Random();
        return names[rand.nextInt(names.length)];
    }

    public int randomLife(){
        int randomlife =(int)(Math.random() * 31) + 10;
        return randomlife;
    }
}