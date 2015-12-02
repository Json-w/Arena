package com.arena.model;

/**
 * Created by jason on 15-11-30.
 */
public interface WeaponCharacter {
    public String getStatusDescrib();
    public String characterAttack(Player player);
    public String shouldInjuredPersonLike(Player player);
    public int getRoundTimes();
    public void setRoundTimes(int roundTimes);

    public boolean ifAttack();
}
