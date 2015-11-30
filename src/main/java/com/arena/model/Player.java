package com.arena.model;

/**
 * Created by jason on 15-11-28.
 */
public abstract class Player {
    protected String name;
    protected double atk;
    protected double blood;
    protected Status status;

    public Player(String name, double atk, double blood) {
        this.name = name;
        this.atk = atk;
        this.blood = blood;
    }

    public abstract String getRoleName();

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public void setBlood(double blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public double getAtk() {
        return atk;
    }

    public double getBlood() {
        return blood;
    }

    public String attack(Player atkedPlayer) {
        if(null != status){
            if(status.getStatusCode().equals("01")){

            }
        }
        return String.format("%s攻击了%s", name, atkedPlayer.getName());
    }

    public boolean isAlive() {
        return blood > 0;
    }

    public String beAttacked(double damage) {
        blood -= damage;
        return String.format("%s受到了%s点伤害,%s剩余生命:%s", name, damage, name, blood);
    }


    public void setStatus(Status status) {
        this.status = status;
    }
}
