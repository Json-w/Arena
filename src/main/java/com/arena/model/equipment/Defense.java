package com.arena.model.equipment;

public class Defense {
    private String name;
    private double ac;

    public Defense(String name, double ac) {
        this.name = name;
        this.ac = ac;
    }

    public double getAc() {
        return ac;
    }

    public void setAc(double ac) {
        this.ac = ac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
