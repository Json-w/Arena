package com.arena.model.equipment;

import com.arena.model.equipment.AbstractWeaponCharacter;
import com.arena.model.player.Player;

/**
 * Created by jason on 15-12-1.
 */
public class DizzyWeaponCharactor extends AbstractWeaponCharacter {
    private int roundTimes;
    public DizzyWeaponCharactor(int roundTimes) {
        this.roundTimes = roundTimes;
    }

    public DizzyWeaponCharactor() {
        roundTimes = 0;
    }

    @Override
    public String getStatusDescrib() {
        return "晕倒了";
    }

    @Override
    public String characterAttack(Player player) {
        roundTimes +=2;
        return "";
    }

    @Override
    public String shouldInjuredPersonLike(Player player) {
        roundTimes--;
        return String.format("%s晕倒了,无法攻击,眩晕还剩:%s轮",player.getName(), roundTimes);
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
        if (roundTimes > 0) {
            return false;
        } else {
            return true;
        }
    }
}
