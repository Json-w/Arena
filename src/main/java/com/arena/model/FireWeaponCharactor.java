package com.arena.model;

/**
 * Created by jason on 15-12-1.
 */
public class FireWeaponCharactor implements WeaponCharacter {
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