package com.elssu.vko12;

import java.util.Random;

public class Skeleton extends Monster {
    private String[] names;
    public Skeleton(String name,int maxLife) {
        super(name,maxLife);
        this.maxLife = randomLife();
        this.life = this.maxLife;
        this.names = new String[] {"Mr.Bones", "Skelly", "Bony Stark", "Mister Boney Pants Guy", "Skellington" };
        this.name = getRandomName(names);
    }


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
