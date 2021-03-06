package com.arena.model.equipment;

import com.arena.model.player.Player;
import com.arena.model.player.Warrior;

/**
 * 中等长度武器
 */
public class MiddleWeaponSize implements WeaponSize {
    @Override
    public boolean ifPlayerCanAssemble(Player player) {
        return true;
    }

    @Override
    public boolean ifPlayerCanUseCharactor(Player player) {
        if(player instanceof Warrior){
            if(player.getRoleName().equals("战士")){
                return true;
            }
        }
        return false;
    }
}
