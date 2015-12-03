package com.arena.model.equipment;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FreezeWeaponCharactorTest {
    @Test
    public void test_freezeWeaponCharactor_ifAttack_should_return_true(){
        FreezeWeaponCharactor freezeWeaponCharactor = new FreezeWeaponCharactor();
        freezeWeaponCharactor.setRoundTimes(4);

        assertThat(freezeWeaponCharactor.ifAttack(),is(true));

    }

    @Test
    public void test_freezeWeaponCharactor_ifAttack_should_return_false(){
        FreezeWeaponCharactor freezeWeaponCharactor = new FreezeWeaponCharactor();
        freezeWeaponCharactor.setRoundTimes(5);

        assertThat(freezeWeaponCharactor.ifAttack(),is(false));

    }
}
