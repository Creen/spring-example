package com.kovalenko.spring;

public class Stormtrooper {

    private Subject subject;

    public Stormtrooper() {

    }

    public Stormtrooper(Subject subject) {
        this.subject = subject;
    }

    public void getInHands() {
        System.out.println("I keep in hands " + subject.getSubject());
    }
}