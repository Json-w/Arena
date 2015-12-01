package com.arena.model;

/**
 * Created by jason on 15-12-1.
 */
public class DizzyWeaponCharactor implements WeaponCharacter {
    private int roundTimes;

    public DizzyWeaponCharactor(int roundTimes) {
        this.roundTimes = roundTimes;
    }

    public DizzyWeaponCharactor() {
        roundTimes = 2;
    }

    @Override
    public String getStatusDescrib() {
        return "晕倒";
    }

    @Override
    public String characterAttack(Player player) {
        roundTimes--;
        return String.format("%s晕倒了,无法攻击,眩晕还剩:%s轮",player.getName(),roundTimes);
    }

    @Override
    public int getRoundTimes() {
        return roundTimes;
    }

    @Override
    public void setRoundTimes(int roundTimes) {
        this.roundTimes = roundTimes;
    }

    @Override
    public boolean ifAttack() {
        if(roundTimes >0){
            return  false;
        }else {
            return true;
        }
    }
}
