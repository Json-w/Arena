package com.arena.model;

/**
 * Created by jason on 15-11-29.
 */
public class Weapon {
    private String name;
    private double additionATK;
    private WeaponCharacter weaponCharacter;

    public Weapon(String name,double additionATK) {
        this.additionATK = additionATK;
        this.name = name;
    }

    public double getAdditionATK() {
        return additionATK;
    }

    public void setAdditionATK(double additionATK) {
        this.additionATK = additionATK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponCharacter getWeaponCharacter() {
        return weaponCharacter;
    }

    public void setWeaponCharacter(WeaponCharacter weaponCharacter) {
        this.weaponCharacter = weaponCharacter;
    }
}
