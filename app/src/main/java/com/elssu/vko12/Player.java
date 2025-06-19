package com.elssu.vko12;

public class Player {
    public Player() {
        this.damage = 15;
        this.score =0;
    }
    private int damage;
    private int score;
    public void attack(Monster monsu) {
        monsu.takeDamage(damage);
    }
    public int getDamage(){
        return damage;
    }
    public void addScore(int number){
        this.score = this.score + number;
    }
    public int getScore() {
        return score;
    }
}
