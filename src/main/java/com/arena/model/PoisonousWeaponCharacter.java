package com.arena.model;

/**
 * Created by jason on 15-11-30.
 */
public class PoisonousWeaponCharacter implements WeaponCharacter{
    private Status status;

    public PoisonousWeaponCharacter() {
        status = new Status("01","中毒");
    }

    @Override
    public String damagePlayer(Player player) {
        player.setStatus(status);
        return String.format("%s中毒了",player.getName());
    }
}
