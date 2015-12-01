package com.arena.model;

/**
 * Created by jason on 15-11-29.
 */
public class Warrior extends Player {
    private String roleName = "战士";
    private Weapon weapon;
    private Defense defense;

    public Warrior(String name, double atk, double blood, Weapon woodWeapon, Defense woodDefense) {
        super(name, atk, blood);
        this.weapon = woodWeapon;
        this.defense = woodDefense;
    }

    public Warrior(String name, double atk, double blood) {
        super(name, atk, blood);
        this.weapon = new NoWeapon();
        this.defense = new NoDefense();
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String attack(Player atkedPlayer) {
        String result = "";
        if (status != null) {
            if (status.getWeaponCharacter() instanceof DizzyWeaponCharactor) {
                return status.getWeaponCharacter().characterAttack(this);
            }
            result = status.getWeaponCharacter().characterAttack(this) + "/n";
        }
        if ("".equals(weapon.getName())) {
            result += String.format("%s%s攻击了%s%s", roleName, name, atkedPlayer.getRoleName(), atkedPlayer.getName());
        } else {
            result += String.format("%s%s用%s攻击了%s%s", roleName, name, weapon.getName(), atkedPlayer.getRoleName(), atkedPlayer.getName());
        }
        return result;
    }

    @Override
    public double getAtk() {
        return super.getAtk() + weapon.getAdditionATK();
    }

    @Override
    public Attack getAttack() {
        return new Attack(getAtk(), weapon.getWeaponCharacter());
    }


    @Override
    public String beAttacked(Player player) {
        if (player.getStatus() != null && !player.getStatus().getWeaponCharacter().ifAttack()) {
            return "";
        }
        blood -= (player.getAttack().getNormalAtk() - defense.getAc());
        if (player.getAttack().getWeaponCharacter() != null) {
            setStatus(new Status(player.getAttack().getWeaponCharacter()));
        }
        if (status != null) {
            return String.format(",%s受到了%s点伤害,%s,%s剩余生命:%s", name, player.getAttack().getNormalAtk() - defense.getAc(), name + status.getDescrib(), name, blood);
        }
        return String.format(",%s受到了%s点伤害,%s剩余生命:%s", name, player.getAttack().getNormalAtk() - defense.getAc(), name, blood);
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
