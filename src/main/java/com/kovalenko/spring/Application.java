package com.kovalenko.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        System.out.println("------------XML-------------");
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Stormtrooper stormtrooperBean = context.getBean("stormtrooper", Stormtrooper.class);
        stormtrooperBean.getInHands();

        System.out.println("--------XML + Annotation----------");
        Jedi jedi = context.getBean("jedi", Jedi.class);
        jedi.getInHands();
    }
}
