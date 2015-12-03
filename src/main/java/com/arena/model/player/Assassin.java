package com.arena.model.player;

/**
 * Created by adminstrator on 2015/12/3.
 */
public class Assassin extends Warrior {
    public Assassin(String name, double atk, double blood) {
        super(name, atk, blood);
        roleName = "刺客";
    }
}
