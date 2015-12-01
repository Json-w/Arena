package com.arena.model;

/**
 * Created by jason on 15-12-1.
 */
public class FireWeaponCharactor implements WeaponCharacter{
    @Override
    public String getStatusDescrib() {
        return null;
    }

    @Override
    public String characterAttack(Player player) {
        return null;
    }

    @Override
    public int getRoundTimes() {
        return 0;
    }

    @Override
    public void setRoundTimes(int roundTimes) {

    }

    @Override
    public boolean ifAttack() {
        return false;
    }
}
