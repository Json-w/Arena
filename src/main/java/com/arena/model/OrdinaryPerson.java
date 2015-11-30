package com.arena.model;

/**
 * Created by jason on 15-11-29.
 */
public class OrdinaryPerson extends Player {
    private String roleName="普通人";
    public OrdinaryPerson(String name, double atk, double blood) {
        super(name,atk,blood);
    }

    @Override
    public String getRoleName() {
        return "普通人";
    }

    @Override
    public String attack(Player atkedPlayer){

        return String.format("%s%s攻击了%s%s", roleName,name,atkedPlayer.getRoleName(),atkedPlayer.getName());
    }
}
