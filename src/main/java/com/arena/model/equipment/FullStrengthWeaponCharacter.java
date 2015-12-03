package com.arena.model.equipment;

import com.arena.model.equipment.AbstractWeaponCharacter;
import com.arena.model.player.Player;

/**
 * Created by jason on 15-12-2.
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
