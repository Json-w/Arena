package com.arena.model;

/**
 * Created by jason on 15-11-30.
 */
public class PoisonousWeaponCharacter extends AbstractWeaponCharacter{
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
