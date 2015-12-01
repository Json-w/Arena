package com.arena.model;

/**
 * Created by jason on 15-11-30.
 */
public class Status {
    private int roundTimes;
    private WeaponCharacter weaponCharacter;

    public Status(WeaponCharacter weaponCharacter) {
        this.weaponCharacter = weaponCharacter;
    }

    public Status(int roundTimes, WeaponCharacter weaponCharacter) {
        this.roundTimes = roundTimes;
        this.weaponCharacter = weaponCharacter;
    }

    public WeaponCharacter getWeaponCharacter() {
        return weaponCharacter;
    }

    public void setWeaponCharacter(WeaponCharacter weaponCharacter) {
        this.weaponCharacter = weaponCharacter;
    }

    public int getRoundTimes() {
        return roundTimes;
    }

    public void setRoundTimes(int roundTimes) {
        this.roundTimes = roundTimes;
    }

    public String getDescrib() {
        return weaponCharacter.getStatusDescrib()+"了";
    }
}
