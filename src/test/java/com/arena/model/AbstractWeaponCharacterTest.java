package com.arena.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by adminstrator on 2015/12/3.
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractWeaponCharacterTest {
    @Mock
    Random random;

    @Test
    public void test_AbstractWeaponCharacter_ifCharacterEffective_should_return_right_info(){
        AbstractWeaponCharacter abs = new AbstractWeaponCharacter() {
            @Override
            public String getStatusDescrib() {
                return null;
            }

            @Override
            public String characterAttack(Player player) {
                return null;
            }

            @Override
            public String shouldInjuredPersonLike(Player player) {
                return null;
            }

            @Override
            public int getRoundTimes() {
                return 0;
            }

            @Override
            public void setRoundTimes(int roundTimes) {

            }

            @Override
            public boolean ifAttack() {
                return false;
            }
        };
        abs.setRandom(random);
        when(random.nextInt(10)).thenReturn(5,1);

        assertThat(abs.ifCharacterEffecitve(),is(true));
        assertThat(abs.ifCharacterEffecitve(),is(false));

    }


}
