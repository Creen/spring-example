package com.kovalenko.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Jedi {

//    @Autowired
//    @Qualifier("flag")
    private Subject subject;

    public Jedi() {
    }

    public Jedi(@Qualifier("flag")Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void getInHands() {
        System.out.println("I keep in hands nothing");
    }
}
