package com.arena.model.equipment;

import com.arena.model.equipment.AbstractWeaponCharacter;
import com.arena.model.player.Player;

/**
 * Created by jason on 15-12-1.
 * 火焰特性
 */
public class FireWeaponCharactor extends AbstractWeaponCharacter {
    private double characterAtk;

    public FireWeaponCharactor(double characterAtk) {
        this.characterAtk = characterAtk;
    }

    @Override
    public String getStatusDescrib() {
        return "燃烧了";
    }

    @Override
    public String characterAttack(Player player) {
        player.setBlood(player.getBlood() - characterAtk);
        return String.format("%s受到%s点燃烧伤害,%s剩余生命:%s", player.getName(), characterAtk,player.getName(),player.getBlood());
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