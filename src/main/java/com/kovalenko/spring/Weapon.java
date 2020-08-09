package com.kovalenko.spring;

import org.springframework.stereotype.Component;

@Component
public class Weapon implements Subject {

    private String name;

//    public Weapon(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSubject() {
        return name;
    }
}
