package com.arena.model.equipment;

import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Knight;
import com.arena.model.player.Warrior;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LongWeaponSizeTest {
    @Test(expected = CanNotAssembleException.class)
    public void test_assemble_long_weapon_to_assassin_should_throw_canNotAssembleException() throws CanNotAssembleException {
        LongWeaponSize longWeaponSize = new LongWeaponSize();
        longWeaponSize.ifPlayerCanAssemble(new Warrior("李四",3,26));
    }

    @Test
    public void test_if_player_who_has_assemble_long_weapon_can_use_weapon_character_should_return_false(){
        LongWeaponSize longWeaponSize = new LongWeaponSize();

        assertThat(longWeaponSize.ifPlayerCanUseCharactor(new Warrior("李四",3,26)),is(false));
    }

    @Test
    public void test_if_player_who_has_assemble_long_weapon_can_use_weapon_character_should_return_true(){
        LongWeaponSize longWeaponSize = new LongWeaponSize();

        assertThat(longWeaponSize.ifPlayerCanUseCharactor(new Knight("李四",3,36)),is(true));
    }

}
