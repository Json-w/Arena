package com.arena.model.equipment;

import com.arena.model.player.Player;

/**
 * 冰冻特性
 */
public class FreezeWeaponCharactor extends AbstractWeaponCharacter {
    private int roundTimes;

    public FreezeWeaponCharactor(int roundTimes) {
        this.roundTimes = roundTimes;
    }

    public FreezeWeaponCharactor() {
        roundTimes = 0;
    }

    @Override
    public String getStatusDescrib() {
        return "冰冻了";
    }

    @Override
    public String characterAttack(Player player) {
        roundTimes ++;
        return "";
    }

    @Override
    public String shouldInjuredPersonLike(Player player) {
        return String.format("%s冰冻了,无法攻击",player.getName());
    }


    @Override
    public void setRoundTimes(int roundTimes) {
        this.roundTimes = roundTimes;
    }

    @Override
    public boolean ifAttack() {
        if(roundTimes%2 > 0){
            return  false;
        }else {
            return true;
        }
    }
}
