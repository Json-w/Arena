package com.arena.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.inOrder;

/**
 * Created by jason on 15-11-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class WarriorTest {
    @Mock
    private Printer printer;

    @Test
    public void should_warrior_setup_success() {
        Warrior warrior = new Warrior("张三", 20, 100);

        assertThat(warrior.getRoleName() + warrior.getName(), is("战士张三"));
    }

    @Test
    public void test_warrior_with_no_weapon_and_no_defense_should_return_right_info() {
        Warrior warriorA = new Warrior("王五", 12, 38);
        Warrior warriorB = new Warrior("李四", 10, 40);

        String attackResult = warriorA.attack(warriorB);

        assertThat(warriorB.getBlood(), is(28.0));
        assertThat(attackResult, is("战士王五攻击了战士李四,李四受到了12.0点伤害,李四剩余生命:28.0"));
    }

    @Test
    public void test_warrior_with_weapon_and_defense_should_return_right_info() {
        Warrior warriorA = new Warrior("王五", 12, 38);
        Warrior warriorB = new Warrior("李四", 10, 40);
        warriorA.setWeapon(new Weapon("屠龙刀", 5));
        warriorA.setDefense(new Defense("金丝软甲", 7));

        String attackResult = warriorA.attack(warriorB);

        assertThat(warriorB.getBlood(), is(23.0));
        assertThat(attackResult, is("战士王五用屠龙刀攻击了战士李四,李四受到了17.0点伤害,李四剩余生命:23.0"));
    }

    @Test
    public void test_warrior_with_posionous_sword_attack_ordinaryPerson() {
//        Warrior warrior = new Warrior("张三", 5, 20, new Weapon("优质毒剑", 3), new NoDefense());
//        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
//
//        String beAttackResult = ordinaryPerson.beAttacked(warrior.getAtk());
//        String attackResult = ordinaryPerson.attack(warrior);
//        InOrder inOrder = inOrder(printer);
//
//        assertThat(beAttackResult,is("李四受到了8.0点伤害,李四中毒了,李四剩余生命:10.0"));
//        inOrder.verify(printer).printToConsol("李四受到2点毒性伤害,李四剩余生命:8.0");
//        assertThat(attackResult,is(""));
    }
}
