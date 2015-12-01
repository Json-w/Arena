package com.arena.model;

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
            if(status.getWeaponCharacter() instanceof DizzyWeaponCharactor){
                return status.getWeaponCharacter().characterAttack(this);
            }
            result += status.getWeaponCharacter().characterAttack(this)+"\n";
        }
        result += String.format("%s%s攻击了%s%s", roleName, name, atkedPlayer.getRoleName(), atkedPlayer.getName());
        return result;
    }

    @Override
    public String beAttacked(Player player) {
        blood -= player.getAttack().getNormalAtk();
        if (player.getAttack().getWeaponCharacter() != null) {
            setStatus(new Status(player.getAttack().getWeaponCharacter()));
        }
        if (status != null) {
            return String.format(",%s受到了%s点伤害,%s,%s剩余生命:%s", name, player.getAtk(), name + status.getDescrib(), name, blood);
        }
        return String.format(",%s受到了%s点伤害,%s剩余生命:%s", name, player.getAtk(), name, blood);
    }
}
