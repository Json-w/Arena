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
 * Created by jason on 15-11-28.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArenaTest {

    @Mock
    private Printer printer;

    private Player playerA;
    private Player playerB;
    private Arena arena;

    @Test
    public void test_Arena_start_can_get_correct_winner() {
        playerA = new OrdinaryPerson("张三", 30, 100);
        playerB = new OrdinaryPerson("李四", 20, 100);
        arena = new Arena(playerA, playerB);
        arena.setPrinter(printer);

        arena.start();

        assertThat(arena.getWinner(), is(playerA));
    }

    @Test
    public void test_every_round_has_ouput_infomation(){
        Weapon woodWeapon = new Weapon("优质木棒",1);
        Defense woodDefense = new Defense("木盾",1);
        playerA = new Warrior("张三",8,10,woodWeapon,woodDefense);
        playerB = new OrdinaryPerson("李四", 5, 10);
        arena = new Arena(playerA, playerB);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用优质木棒攻击了普通人李四,李四受到了9.0点伤害,李四剩余生命:1.0");
        inOrder.verify(printer).printToConsol("普通人李四攻击了战士张三,张三受到了4.0点伤害,张三剩余生命:6.0");
        inOrder.verify(printer).printToConsol("战士张三用优质木棒攻击了普通人李四,李四受到了9.0点伤害,李四剩余生命:-8.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_posionous_sword_fight_with_ordinaryPerson(){
        Warrior warrior = new Warrior("张三", 8, 20, new Weapon("优质毒剑", 3), new NoDefense());
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用优质毒剑攻击了普通人李四,李四受到了11点伤害,李四中毒了,李四剩余生命：9.0");
        inOrder.verify(printer).printToConsol("李四受到2点毒性伤害, 李四剩余生命：7.0");
        inOrder.verify(printer).printToConsol("普通人李四攻击了战士张三,张三受到了3点伤害,张三剩余生命：17.0");
        inOrder.verify(printer).printToConsol("战士张三用优质毒剑攻击了普通人李四,李四受到了11点伤害,李四中毒了,李四剩余生命：-4.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

}
