package com.elssu.vko12;

public class Player {
    public Player() {
        this.damage = 10;
    }
    private int damage;
    private int score;
    public void attack(Monster monsu) {
        monsu.takeDamage(damage);
    }
    public int getScore() {
        int geh = 0;
        return geh;
    }
}
