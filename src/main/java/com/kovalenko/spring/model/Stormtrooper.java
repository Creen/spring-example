package com.kovalenko.spring.model;

import lombok.Data;

@Data
public class Stormtrooper {

    private String name;
    private String weapon;

    public Stormtrooper() {
    }

    public Stormtrooper(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }
}
