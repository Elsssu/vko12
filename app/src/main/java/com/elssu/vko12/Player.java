package com.elssu.vko12;

public class Player {
    public Player() {
        this.damage = 15;
    }
    private int damage;
    private int score;
    public void attack(Monster monsu) {
        monsu.takeDamage(damage);
    }
    public int getScore() {
        return score;
    }
}
