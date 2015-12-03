package com.arena.model.equipment;

import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Knight;
import com.arena.model.player.Player;

/**
 * Created by adminstrator on 2015/12/3.
 */
public class LongWeaponSize implements WeaponSize {
    @Override
    public boolean ifPlayerCanAssemble(Player player) throws CanNotAssembleException {
        if(player instanceof Knight){
            return true;
        }else {
            throw new CanNotAssembleException(player.getRoleName()+" can not Assemble this weapon");
        }
    }

    @Override
    public boolean ifPlayerCanUseCharactor(Player player) {
        if(player instanceof Knight){
            return  true;
        }
        return false;
    }
}
