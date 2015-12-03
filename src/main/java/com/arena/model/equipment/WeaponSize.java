package com.arena.model.equipment;

import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Player;

/**
 * Created by adminstrator on 2015/12/3.
 * 武器长短
 */
public interface WeaponSize {
    /**
     *
     * @param player
     * @return 是否player可以装备此武器
     * @throws CanNotAssembleException 无法装备此武器
     */
    public boolean ifPlayerCanAssemble(Player player) throws CanNotAssembleException;

    /**
     *
     * @param player
     * @return 是否player可以发挥武器特性
     */
    public boolean ifPlayerCanUseCharactor(Player player);
}
