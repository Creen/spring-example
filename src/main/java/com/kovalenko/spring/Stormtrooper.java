package com.kovalenko.spring;

public class Stormtrooper {

    private Subject subject;
    private String name;

    public Stormtrooper() {

    }

    public Stormtrooper(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getInHands() {
        System.out.println("I keep in hands " + subject.getSubject());
    }
}
