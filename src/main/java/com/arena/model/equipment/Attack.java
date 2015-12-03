package com.arena.model.equipment;

/**
 * 综合正常攻击和武器属性攻击
 */
public class Attack {
    private double normalAtk;
    private WeaponCharacter weaponCharacter;

    public Attack(double normalAtk, WeaponCharacter weaponCharacter) {
        this.normalAtk = normalAtk;
        this.weaponCharacter = weaponCharacter;
    }

    public double getNormalAtk() {
        return normalAtk;
    }

    public void setNormalAtk(double normalAtk) {
        this.normalAtk = normalAtk;
    }

    public WeaponCharacter getWeaponCharacter() {
        return weaponCharacter;
    }

    public void setWeaponCharacter(WeaponCharacter weaponCharacter) {
        this.weaponCharacter = weaponCharacter;
    }
}
