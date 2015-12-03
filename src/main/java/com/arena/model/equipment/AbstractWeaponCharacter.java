package com.arena.model.equipment;

import java.util.Random;

/**
 * 实现 触发几率随机性
 */
public abstract class AbstractWeaponCharacter implements WeaponCharacter {
    protected Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public boolean ifCharacterEffecitve() {
        if (random == null) {
            random = new Random();
        }
        int randomx = random.nextInt(10);
        if (randomx < 3) {
            return false;
        } else {
            return true;
        }
    }
}
