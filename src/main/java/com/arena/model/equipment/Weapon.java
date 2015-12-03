package com.arena.model.equipment;

/**
 * 武器
 */
public class Weapon {
    private String name;
    private double additionATK;
    private WeaponCharacter weaponCharacter;
    private WeaponSize weaponSize;
    public Weapon(String name,double additionATK) {
        this.additionATK = additionATK;
        this.name = name;
    }

    public Weapon(String name, double additionATK, WeaponCharacter weaponCharacter, WeaponSize weaponSize) {
        this.name = name;
        this.additionATK = additionATK;
        this.weaponCharacter = weaponCharacter;
        this.weaponSize = weaponSize;
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

    public WeaponSize getWeaponSize() {
        return weaponSize;
    }

    public void setWeaponSize(WeaponSize weaponSize) {
        this.weaponSize = weaponSize;
    }
}
