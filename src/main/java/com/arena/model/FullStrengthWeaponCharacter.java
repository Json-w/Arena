package com.arena.model;

/**
 * Created by jason on 15-12-2.
 */
public class FullStrengthWeaponCharacter implements WeaponCharacter{

    @Override
    public String getStatusDescrib() {
        return "发动了全力一击";
    }

    @Override
    public String characterAttack(Player player) {
        return "";
    }

    @Override
    public String shouldInjuredPersonLike(Player player) {
        return "";
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
        return true;
    }
}
