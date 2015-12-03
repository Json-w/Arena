package com.arena.model;

import com.arena.model.common.Printer;
import com.arena.model.equipment.*;
import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

/**
 * Created by jason on 15-11-28.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArenaTest {

    @Mock
    private Printer printer;
    @Mock
    private Random random;

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
    public void test_warrior_with_posionous_sword_fight_with_ordinaryPerson() throws CanNotAssembleException {
        Warrior warrior = new Warrior("张三", 8, 20);
        Weapon weapon = new Weapon("优质毒剑",3);
        AbstractWeaponCharacter poisonousWeaponCharacter = new PoisonousWeaponCharacter(2);
        poisonousWeaponCharacter.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9);
        weapon.setWeaponCharacter(poisonousWeaponCharacter);
        warrior.setWeapon(weapon);
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用优质毒剑攻击了普通人李四,李四受到了11.0点伤害,李四中毒了,李四剩余生命:7.0");
        inOrder.verify(printer).printToConsol("李四受到2.0点毒性伤害,李四剩余生命:5.0\n普通人李四攻击了战士张三,张三受到了3.0点伤害,张三剩余生命:17.0");
        inOrder.verify(printer).printToConsol("战士张三用优质毒剑攻击了普通人李四,李四受到了11.0点伤害,李四中毒了,李四剩余生命:-6.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_dizzy_hammer_fight_with_ordinaryPerson() throws CanNotAssembleException {
        Warrior warrior = new Warrior("张三", 8, 20);
        Weapon weapon = new Weapon("晕锤",3);
        AbstractWeaponCharacter dizzyWeaponChar = new DizzyWeaponCharactor();
        dizzyWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9);
        weapon.setWeaponCharacter(dizzyWeaponChar);
        warrior.setWeapon(weapon);
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用晕锤攻击了普通人李四,李四受到了11.0点伤害,李四晕倒了,李四剩余生命:7.0");
        inOrder.verify(printer).printToConsol("李四晕倒了,无法攻击,眩晕还剩:1轮");
        inOrder.verify(printer).printToConsol("战士张三用晕锤攻击了普通人李四,李四受到了11.0点伤害,李四晕倒了,李四剩余生命:-4.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_fire_sword_fight_with_ordinaryPerson() throws CanNotAssembleException {
        Warrior warrior = new Warrior("张三", 8, 20);
        Weapon weapon = new Weapon("火剑",3);
        AbstractWeaponCharacter fireWeaponChar = new FireWeaponCharactor(2);
        fireWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9);
        weapon.setWeaponCharacter(fireWeaponChar);
        warrior.setWeapon(weapon);
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用火剑攻击了普通人李四,李四受到了11.0点伤害,李四燃烧了,李四剩余生命:7.0");
        inOrder.verify(printer).printToConsol("李四受到2.0点燃烧伤害,李四剩余生命:5.0\n普通人李四攻击了战士张三,张三受到了3.0点伤害,张三剩余生命:17.0");
        inOrder.verify(printer).printToConsol("战士张三用火剑攻击了普通人李四,李四受到了11.0点伤害,李四燃烧了,李四剩余生命:-6.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_freeze_sword_fight_with_ordinaryPerson() throws CanNotAssembleException {
        Warrior warrior = new Warrior("张三", 8, 20);
        Weapon weapon = new Weapon("冰剑",3);
        AbstractWeaponCharacter freezrWeaponChar = new FreezeWeaponCharactor();
        freezrWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9);
        weapon.setWeaponCharacter(freezrWeaponChar);
        warrior.setWeapon(weapon);
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用冰剑攻击了普通人李四,李四受到了11.0点伤害,李四冰冻了,李四剩余生命:7.0");
        inOrder.verify(printer).printToConsol("李四冰冻了,无法攻击");
        inOrder.verify(printer).printToConsol("战士张三用冰剑攻击了普通人李四,李四受到了11.0点伤害,李四冰冻了,李四剩余生命:-4.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_full_strength_sword_fight_with_ordinaryPerson() throws CanNotAssembleException {
        Warrior warrior = new Warrior("张三", 8, 20);
        Weapon weapon = new Weapon("利剑",3);
        AbstractWeaponCharacter fullStrengthWeaponChar = new FullStrengthWeaponCharacter();
        fullStrengthWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9);
        weapon.setWeaponCharacter(fullStrengthWeaponChar);
        warrior.setWeapon(weapon);
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用利剑攻击了普通人李四,张三发动了全力一击,李四受到了33.0点伤害,李四剩余生命:-15.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_dizzy_hammer_fight_with_warrior_who_has_poisonous_sword_more_round_times() throws CanNotAssembleException {
        Warrior hammerWarrior = new Warrior("张三", 8, 40);
        Weapon weapon = new Weapon("晕锤",4);
        AbstractWeaponCharacter dizzyWeaponChar = new DizzyWeaponCharactor();
        dizzyWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9,9);
        weapon.setWeaponCharacter(dizzyWeaponChar);
        hammerWarrior.setWeapon(weapon);
        Warrior swordWarrior = new Warrior("李四",3,35);
        Weapon sword = new Weapon("毒剑",5);
        AbstractWeaponCharacter poisonousWeaponChar = new PoisonousWeaponCharacter(2);
        poisonousWeaponChar.setRandom(random);
        sword.setWeaponCharacter(poisonousWeaponChar);
        swordWarrior.setWeapon(sword);
        arena = new Arena(hammerWarrior,swordWarrior);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用晕锤攻击了战士李四,李四受到了12.0点伤害,李四晕倒了,李四剩余生命:23.0");
        inOrder.verify(printer).printToConsol("李四晕倒了,无法攻击,眩晕还剩:1轮");
        inOrder.verify(printer).printToConsol("战士张三用晕锤攻击了战士李四,李四受到了12.0点伤害,李四晕倒了,李四剩余生命:11.0");
        inOrder.verify(printer).printToConsol("李四晕倒了,无法攻击,眩晕还剩:2轮");
        inOrder.verify(printer).printToConsol("战士张三用晕锤攻击了战士李四,李四受到了12.0点伤害,李四晕倒了,李四剩余生命:-1.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_warrior_with_posidonous_sword_fight_with_warrior_who_has_dizzy_hammer_more_round_times() throws CanNotAssembleException {
        Warrior hammerWarrior = new Warrior("张三", 8, 40);
        Weapon weapon = new Weapon("晕锤",4);
        AbstractWeaponCharacter dizzyWeaponChar = new DizzyWeaponCharactor();
        dizzyWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9,9);
        weapon.setWeaponCharacter(dizzyWeaponChar);
        hammerWarrior.setWeapon(weapon);
        Warrior swordWarrior = new Warrior("李四",3,35);
        Weapon sword = new Weapon("毒剑",5);
        AbstractWeaponCharacter poisonousWeaponChar = new PoisonousWeaponCharacter(2);
        poisonousWeaponChar.setRandom(random);
        sword.setWeaponCharacter(poisonousWeaponChar);
        swordWarrior.setWeapon(sword);
        arena = new Arena(swordWarrior,hammerWarrior);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士李四用毒剑攻击了战士张三,张三受到了8.0点伤害,张三中毒了,张三剩余生命:32.0");
        inOrder.verify(printer).printToConsol("张三受到2.0点毒性伤害,李四剩余生命:30.0\n战士张三用晕锤攻击了战士李四,李四受到了12.0点伤害,李四晕倒了,李四剩余生命:23.0");
        inOrder.verify(printer).printToConsol("李四晕倒了,无法攻击,眩晕还剩:1轮");
        inOrder.verify(printer).printToConsol("张三受到2.0点毒性伤害,李四剩余生命:28.0\n战士张三用晕锤攻击了战士李四,李四受到了12.0点伤害,李四晕倒了,李四剩余生命:11.0");
        inOrder.verify(printer).printToConsol("李四晕倒了,无法攻击,眩晕还剩:2轮");
        inOrder.verify(printer).printToConsol("张三受到2.0点毒性伤害,李四剩余生命:26.0\n战士张三用晕锤攻击了战士李四,李四受到了12.0点伤害,李四晕倒了,李四剩余生命:-1.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }
    @Test
    public void test_warrior_with_fullStrength_sword_fight_with_warrior_who_has_freeze_sword_more_round_times() throws CanNotAssembleException {
        Warrior fullStrengthWarrior = new Warrior("张三", 8, 30);
        Weapon fullStrengthWeapon = new Weapon("利剑",3);
        AbstractWeaponCharacter fullStrengthWeaponChar = new FullStrengthWeaponCharacter();
        fullStrengthWeaponChar.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(9,9);
        fullStrengthWeapon.setWeaponCharacter(fullStrengthWeaponChar);
        fullStrengthWarrior.setWeapon(fullStrengthWeapon);
        Warrior freezeWarrior = new Warrior("李四",3,68);
        Weapon weapon = new Weapon("冰剑",2);
        AbstractWeaponCharacter freezeWeaponChar = new FreezeWeaponCharactor();
        freezeWeaponChar.setRandom(random);
        weapon.setWeaponCharacter(freezeWeaponChar);
        freezeWarrior.setWeapon(weapon);
        arena = new Arena(fullStrengthWarrior,freezeWarrior);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("战士张三用利剑攻击了战士李四,张三发动了全力一击,李四受到了33.0点伤害,李四剩余生命:35.0");
        inOrder.verify(printer).printToConsol("战士李四用冰剑攻击了战士张三,张三受到了5.0点伤害,张三冰冻了,张三剩余生命:25.0");
        inOrder.verify(printer).printToConsol("张三冰冻了,无法攻击");
        inOrder.verify(printer).printToConsol("战士李四用冰剑攻击了战士张三,张三受到了5.0点伤害,张三冰冻了,张三剩余生命:20.0");
        inOrder.verify(printer).printToConsol("战士张三用利剑攻击了战士李四,张三发动了全力一击,李四受到了33.0点伤害,李四剩余生命:2.0");
        inOrder.verify(printer).printToConsol("战士李四用冰剑攻击了战士张三,张三受到了5.0点伤害,张三冰冻了,张三剩余生命:15.0");
        inOrder.verify(printer).printToConsol("张三冰冻了,无法攻击");
        inOrder.verify(printer).printToConsol("战士李四用冰剑攻击了战士张三,张三受到了5.0点伤害,张三冰冻了,张三剩余生命:10.0");
        inOrder.verify(printer).printToConsol("战士张三用利剑攻击了战士李四,张三发动了全力一击,李四受到了33.0点伤害,李四剩余生命:-31.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test
    public void test_Assassin_use_short_weapon_fight_with_knight_who_has_no_weapon() throws CanNotAssembleException {
        Assassin assassin = new Assassin("张三",8,20);
        Weapon weapon = new Weapon("冰雪峨嵋刺",2);
        AbstractWeaponCharacter weaponCharacter = new FreezeWeaponCharactor();
        weaponCharacter.setRandom(random);
        weapon.setWeaponCharacter(weaponCharacter);
        when(random.nextInt(anyInt())).thenReturn(9,8);
        weapon.setWeaponSize(new ShortWeaponSize());
        assassin.setWeapon(weapon);
        Knight knight = new Knight("李四",6,20);
        arena = new Arena(assassin,knight);
        InOrder inOrder = inOrder(printer);
        arena.setPrinter(printer);

        arena.start();

        inOrder.verify(printer).printToConsol("刺客张三用冰雪峨嵋刺攻击了骑士李四,李四受到了10.0点伤害,李四冰冻了,李四剩余生命:10.0");
        inOrder.verify(printer).printToConsol("李四冰冻了,无法攻击");
        inOrder.verify(printer).printToConsol("刺客张三用冰雪峨嵋刺攻击了骑士李四,李四受到了10.0点伤害,李四冰冻了,李四剩余生命:0.0");
        inOrder.verify(printer).printToConsol("李四被打败了");
    }

    @Test(expected = CanNotAssembleException.class)
    public void test_warrior_use_short_weapon_fight_with_knight_who_has_no_weapon() throws CanNotAssembleException{
        Warrior warrior = new Warrior("张三",8,20);
        Weapon weapon = new Weapon("冰雪峨嵋刺",2);
        AbstractWeaponCharacter weaponCharacter = new FreezeWeaponCharactor();
        weaponCharacter.setRandom(random);
        weapon.setWeaponCharacter(weaponCharacter);
        when(random.nextInt(anyInt())).thenReturn(9,8);
        weapon.setWeaponSize(new ShortWeaponSize());
        warrior.setWeapon(weapon);
        Knight knight = new Knight("李四",6,20);
        arena = new Arena(warrior,knight);
        arena.setPrinter(printer);

        arena.start();
    }
}
