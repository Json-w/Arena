package com.arena.model.equipment;

import com.arena.model.player.Player;

/**
 * 毒性特性
 */
public class PoisonousWeaponCharacter extends AbstractWeaponCharacter {
    private double characterAtk;

    public PoisonousWeaponCharacter(double characterAtk) {
        this.characterAtk = characterAtk;
    }

    @Override
    public String getStatusDescrib() {
        return "中毒了";
    }

    @Override
    public String characterAttack(Player player) {
        player.setBlood(player.getBlood()-characterAtk);
        return String.format("%s受到%s点毒性伤害,李四剩余生命:%s",player.getName(),characterAtk,player.getBlood());
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
