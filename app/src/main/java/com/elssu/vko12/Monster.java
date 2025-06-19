package com.elssu.vko12;

public abstract class Monster {
    protected String name;
    protected int life;
    protected int maxLife;

    public Monster(String name, int maxLife) {
        this.name = name;
        this.life = maxLife;
        this.maxLife = maxLife;

    }

    public void takeDamage(int dmg) {
        this.life = life - dmg;
    }
    public int getLife(){
        return life;
    }
    public String getName(){
        return name;
    }
    public int getMaxLife(){
        return maxLife;
    }
}
