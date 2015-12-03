package com.arena.model.equipment;

import com.arena.model.player.Player;

/**
 * Created by jason on 15-11-30.
 */
public interface WeaponCharacter {
    public String getStatusDescrib();
    public String characterAttack(Player player);
    public String shouldInjuredPersonLike(Player player);
    public int getRoundTimes();
    public void setRoundTimes(int roundTimes);
    public boolean ifAttack();
    public boolean ifCharacterEffecitve();
}
