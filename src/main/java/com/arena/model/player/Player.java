package com.arena.model.player;

import com.arena.model.equipment.Attack;

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

    public abstract Attack getAttack();

    public double getBlood() {
        return blood;
    }

    public abstract String attack(Player atkedPlayer);



    public boolean isAlive() {
        return blood > 0;
    }

    public abstract String beAttacked(Player player);

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
