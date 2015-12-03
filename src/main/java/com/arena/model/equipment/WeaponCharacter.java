package com.arena.model.equipment;

import com.arena.model.player.Player;

/**
 * Created by jason on 15-11-30.
 * 武器特性抽象接口
 */
public interface WeaponCharacter {
    /**
     *
     * @return 状态描述
     */
    public String getStatusDescrib();
    /**
     *
     * @return 属性攻击
     */
    public String characterAttack(Player player);
    /**
     *
     * @return 受伤的人应该是什么状态(为了输出需要)
     */
    public String shouldInjuredPersonLike(Player player);
    /**
     *
     * @return 回合 用于冰冻特性  击晕特性 计算是否触发
     */
    public void setRoundTimes(int roundTimes);
    /**
     *
     * @return 用于冰冻 击晕特性  其他特性默认实现返回true
     */
    public boolean ifAttack();

    /**
     *
     * @return  抽象类实现此方法   用于实现触发几率。
     */
    public boolean ifCharacterEffecitve();
}
