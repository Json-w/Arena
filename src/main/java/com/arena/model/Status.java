package com.arena.model;

/**
 * Created by jason on 15-11-30.
 */
public class Status {
    private String statusCode;
    private String statusDescirbe;
    private WeaponCharacter weaponCharacter;
    public Status(String statusCode, String statusDescirbe) {
        this.statusCode = statusCode;
        this.statusDescirbe = statusDescirbe;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescirbe() {
        return statusDescirbe;
    }

    public void setStatusDescirbe(String statusDescirbe) {
        this.statusDescirbe = statusDescirbe;
    }

    public WeaponCharacter getWeaponCharacter() {
        return weaponCharacter;
    }

    public void setWeaponCharacter(WeaponCharacter weaponCharacter) {
        this.weaponCharacter = weaponCharacter;
    }
}
