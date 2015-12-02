package com.arena.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jason on 15-11-30.
 */
public class OrdinaryPersonTest {

    @Test
    public void test_ordinaryPerson_fight_each_other_should_return_right_info(){
        OrdinaryPerson ordinaryPersonA = new OrdinaryPerson("张三",5,10);
        OrdinaryPerson ordinaryPersonB = new OrdinaryPerson("李四",3,12);

        String attackResult = ordinaryPersonA.attack(ordinaryPersonB);
        assertThat(attackResult,is("普通人张三攻击了普通人李四,李四受到了5.0点伤害,李四剩余生命:7.0"));
        assertThat(ordinaryPersonB.getBlood(),is(7.0));
    }

    @Test
    public void test_ordinaryPerson_fight_with_warrior_who_has_weapon(){
        Warrior warrior = new Warrior("张三",15,50,new Weapon("倚天剑",5),new NoDefense());
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",10,40);

        String attackResult = warrior.attack(ordinaryPerson);

        assertThat(attackResult,is("战士张三用倚天剑攻击了普通人李四,李四受到了20.0点伤害,李四剩余生命:20.0"));
        assertThat(ordinaryPerson.getBlood(),is(20.0));
    }
}
