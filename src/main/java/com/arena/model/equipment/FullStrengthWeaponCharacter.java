package com.arena.model.equipment;

import com.arena.model.player.Player;

/**
 * 全力一击特性
 */
public class FullStrengthWeaponCharacter extends AbstractWeaponCharacter {

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
    public void setRoundTimes(int roundTimes) {

    }

    @Override
    public boolean ifAttack() {
        return true;
    }
}
