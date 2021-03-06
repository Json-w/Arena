package com.arena.model.equipment;

import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Assassin;
import com.arena.model.player.Player;

/**
 * 短兵器
 */
public class ShortWeaponSize implements WeaponSize {
    @Override
    public boolean ifPlayerCanAssemble(Player player) throws CanNotAssembleException {
        if (player instanceof Assassin) {
            return true;
        } else {
            throw new CanNotAssembleException(player.getRoleName() + " can not Assemble this weapon");
        }
    }

    @Override
    public boolean ifPlayerCanUseCharactor(Player player) {
        if (player instanceof Assassin) {
            return true;
        }
        return false;
    }
}
