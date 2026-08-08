package com.mycompany.app;

public class Entity {

    private String name, desc;

    public Entity(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String interact() {
        return desc;
    }

    public String getName(){
        return name;
    }
}
