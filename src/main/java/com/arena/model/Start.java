package com.arena.model;

import com.arena.model.common.Printer;
import com.arena.model.equipment.*;
import com.arena.model.exception.CanNotAssembleException;
import com.arena.model.player.Assassin;
import com.arena.model.player.Knight;
import com.arena.model.player.OrdinaryPerson;
import com.arena.model.player.Warrior;

/**
 * Created by jason on 15-11-28.
 */
public class Start {
    public static void main(String[] args) throws CanNotAssembleException {
//        Arena arena;
//        Warrior warrior = new Warrior("张三", 8, 20);
//        Weapon weapon = new Weapon("优质毒剑",3);
//        weapon.setWeaponCharacter(new PoisonousWeaponCharacter(2));
//        warrior.setWeapon(weapon);
//        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
//        arena = new Arena(warrior,ordinaryPerson);
//        arena.setPrinter(new Printer());
//        arena.start();

//          Arena arena;
//          Warrior warrior = new Warrior("张三", 8, 20);
//          Weapon weapon = new Weapon("晕锤",3);
//          weapon.setWeaponCharacter(new DizzyWeaponCharactor());
//          warrior.setWeapon(weapon);
//          OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,50);
//          arena = new Arena(warrior,ordinaryPerson);
//          arena.setPrinter(new Printer());
//          arena.start();

//        Warrior warrior = new Warrior("张三", 8, 20);
//        Weapon weapon = new Weapon("冰剑",3);
//        weapon.setWeaponCharacter(new FreezeWeaponCharactor(2));
//        warrior.setWeapon(weapon);
//        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
//        arena = new Arena(warrior,ordinaryPerson);
//        arena.setPrinter(new Printer());
//        arena.start();
//
//        Warrior hammerWarrior = new Warrior("张三", 8, 40);
//        Weapon weapon = new Weapon("晕锤",4);
//        weapon.setWeaponCharacter(new DizzyWeaponCharactor());
//        hammerWarrior.setWeapon(weapon);
//        Warrior swordWarrior = new Warrior("李四",3,35);
//        Weapon sword = new Weapon("毒剑",5);
//        sword.setWeaponCharacter(new PoisonousWeaponCharacter(2));
//        swordWarrior.setWeapon(sword);
//        arena = new Arena(swordWarrior,hammerWarrior);
//        arena.setPrinter(new Printer());
//
//        arena.start();

//        Warrior fullStrengthWarrior = new Warrior("张三", 8, 30);
//        Weapon fullStrengthWeapon = new Weapon("利剑",3);
//        fullStrengthWeapon.setWeaponCharacter(new FullStrengthWeaponCharacter());
//        fullStrengthWarrior.setWeapon(fullStrengthWeapon);
//        Warrior freezeWarrior = new Warrior("李四",3,68);
//        Weapon weapon = new Weapon("冰剑",2);
//        weapon.setWeaponCharacter(new FreezeWeaponCharactor());
//        freezeWarrior.setWeapon(weapon);
//        arena = new Arena(fullStrengthWarrior,freezeWarrior);
//        arena.setPrinter(new Printer());
//        arena.start();

//        Warrior warrior = new Warrior("张三", 8, 20);
//        Weapon weapon = new Weapon("冰剑",3);
//        weapon.setWeaponCharacter(new FreezeWeaponCharactor());
//        warrior.setWeapon(weapon);
//        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
//        arena = new Arena(warrior,ordinaryPerson);
//        arena.setPrinter(new Printer());
//
//        arena.start();

          Arena arena;
          Assassin assassin = new Assassin("张三",8,20);
          Weapon weapon = new Weapon("冰雪峨嵋刺",2);
          AbstractWeaponCharacter weaponCharacter = new FreezeWeaponCharactor();
          weapon.setWeaponCharacter(weaponCharacter);
          weapon.setWeaponSize(new ShortWeaponSize());
          assassin.setWeapon(weapon);
          Knight knight = new Knight("李四",6,20);
          arena = new Arena(assassin,knight);
          arena.setPrinter(new Printer());
          arena.start();

    }
}
