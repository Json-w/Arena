package com.arena.model.player;

import com.arena.model.equipment.*;
import com.arena.model.exception.CanNotAssembleException;

/**
 * Created by jason on 15-11-29.
 * 战士
 */
public class Warrior extends Player {
    protected String roleName = "战士";
    protected Weapon weapon;
    protected Defense defense;

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
            String characterAttackResult = status.getWeaponCharacter().characterAttack(this);
            if (status != null) {
                if (!status.getWeaponCharacter().ifAttack()) {//玩家不能攻击的时候 输出玩家的状态
                    return status.getWeaponCharacter().shouldInjuredPersonLike(this);
                } else {
                    if (!characterAttackResult.equals("")) {
                        result += characterAttackResult + "\n";
                    }
                }
            }

        }
        if ("".equals(weapon.getName())) {
            result += String.format("%s%s攻击了%s%s", roleName, name, atkedPlayer.getRoleName(), atkedPlayer.getName()) + atkedPlayer.beAttacked(this);
        } else {
            result += String.format("%s%s用%s攻击了%s%s", roleName, name, weapon.getName(), atkedPlayer.getRoleName(), atkedPlayer.getName())
                    + atkedPlayer.beAttacked(this);
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
//        if (player.getStatus() != null && !player.getStatus().getWeaponCharacter().ifAttack()) {
//            return "";
//        }
        double atkedBlood = 0;
        atkedBlood = (player.getAttack().getNormalAtk() - defense.getAc());
        if (player.getAttack().getWeaponCharacter() != null) {
            if (player.getAttack().getWeaponCharacter().ifCharacterEffecitve()) {//判断武器是否生效
                if (player instanceof Warrior) {
                    Warrior warrior = (Warrior) player;
                    if (warrior.getWeapon().getWeaponSize() == null) {
                        setStatus(new Status(player.getAttack().getWeaponCharacter()));
                    } else {
                        if (warrior.getWeapon().getWeaponSize().ifPlayerCanUseCharactor(player)) {//判断武器在player手中是否有特效
                            setStatus(new Status(player.getAttack().getWeaponCharacter()));
                        }
                    }
                }
            }
            if (player.getAttack().getWeaponCharacter() instanceof FullStrengthWeaponCharacter) {
                atkedBlood = atkedBlood * 3;
            }
        }
        blood -= atkedBlood;
        if (status != null) {
            if (player.getAttack().getWeaponCharacter() instanceof FullStrengthWeaponCharacter) {
                return String.format(",%s,%s受到了%s点伤害,%s剩余生命:%s", player.getName() + status.getDescrib(), name, atkedBlood, name, blood);
            }
            return String.format(",%s受到了%s点伤害,%s,%s剩余生命:%s", name, atkedBlood, name + status.getDescrib(), name, blood);
        }
        return String.format(",%s受到了%s点伤害,%s剩余生命:%s", name, atkedBlood, name, blood);
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

    public void setWeapon(Weapon weapon) throws CanNotAssembleException {
        if(weapon.getWeaponSize()!=null){
            weapon.getWeaponSize().ifPlayerCanAssemble(this);
        }
        this.weapon = weapon;
    }
}
