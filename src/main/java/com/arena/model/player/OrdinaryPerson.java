package com.arena.model.player;

import com.arena.model.equipment.Attack;
import com.arena.model.equipment.FullStrengthWeaponCharacter;

/**
 * Created by jason on 15-11-29.
 */
public class OrdinaryPerson extends Player {
    private String roleName = "普通人";

    public OrdinaryPerson(String name, double atk, double blood) {
        super(name, atk, blood);
    }

    @Override
    public String getRoleName() {
        return "普通人";
    }

    @Override
    public Attack getAttack() {
        return new Attack(super.getAtk(), null);
    }

    @Override
    public String attack(Player atkedPlayer) {
        String result = "";
        if (status != null) {
            String characterAttackResult = status.getWeaponCharacter().characterAttack(this);
            if (status != null) {
                if (!status.getWeaponCharacter().ifAttack()) {//玩家不能攻击的时候
                    return status.getWeaponCharacter().shouldInjuredPersonLike(this);
                } else {
                    if (!characterAttackResult.equals("")) {
                        result += characterAttackResult + "\n";
                    }
                }
            }
        }
        result += String.format("%s%s攻击了%s%s", roleName, name, atkedPlayer.getRoleName(), atkedPlayer.getName());
        result += atkedPlayer.beAttacked(this);
        return result;
    }

    @Override
    public String beAttacked(Player player) {
//        if (player.getStatus() != null && !player.getStatus().getWeaponCharacter().ifAttack()) {
//            return "";
//        }
        double atkedBlood = 0;
        atkedBlood = (player.getAttack().getNormalAtk());
        if (player.getAttack().getWeaponCharacter() != null) {
            if (player.getAttack().getWeaponCharacter().ifCharacterEffecitve()) {//判断武器是否生效
                setStatus(new Status(player.getAttack().getWeaponCharacter()));
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
}
