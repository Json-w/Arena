package com.arena.model;

/**
 * Created by jason on 15-11-28.
 */
public class Start {
    public static void main(String[] args){
//        Arena arena;
//        Warrior warrior = new Warrior("张三", 8, 20);
//        Weapon weapon = new Weapon("优质毒剑",3);
//        weapon.setWeaponCharacter(new PoisonousWeaponCharacter(2));
//        warrior.setWeapon(weapon);
//        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
//        arena = new Arena(warrior,ordinaryPerson);
//        arena.setPrinter(new Printer());
//        arena.start();
//
        Arena arena;
        Warrior warrior = new Warrior("张三", 8, 20);
        Weapon weapon = new Weapon("晕锤",3);
        weapon.setWeaponCharacter(new DizzyWeaponCharactor());
        warrior.setWeapon(weapon);
        OrdinaryPerson ordinaryPerson = new OrdinaryPerson("李四",3,18);
        arena = new Arena(warrior,ordinaryPerson);
        arena.setPrinter(new Printer());
        arena.start();
    }
}
