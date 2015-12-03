package com.arena.model.equipment;

import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Player;

/**
 * Created by adminstrator on 2015/12/3.
 */
public interface WeaponSize {
    public boolean ifPlayerCanAssemble(Player player) throws CanNotAssembleException;

    public boolean ifPlayerCanUseCharactor(Player player);
}
