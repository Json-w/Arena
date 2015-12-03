package com.arena.model.equipment;

import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Warrior;
import org.junit.Test;

/**
 * Created by adminstrator on 2015/12/3.
 */
public class LongWeaponSizeTest {
    @Test(expected = CanNotAssembleException.class)
    public void test_assemble_long_weapon_to_assassin_should_throw_canNotAssembleException() throws CanNotAssembleException {
        LongWeaponSize longWeaponSize = new LongWeaponSize();
        longWeaponSize.ifPlayerCanAssemble(new Warrior("李四",3,26));
    }
}
