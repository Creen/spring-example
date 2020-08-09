package com.kovalenko.spring;

import org.springframework.stereotype.Component;

@Component
public class Flag implements Subject {

    Color color;

//    public Flag(Color color) {
//        this.color = color;
//    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String getSubject() {
        return color.name();
    }
}

enum Color {

    WHITE, BLACK
}