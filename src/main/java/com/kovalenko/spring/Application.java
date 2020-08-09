package com.kovalenko.spring;

import com.kovalenko.spring.annconfig.AnnotationConfig;
import com.kovalenko.spring.annconfig.Sith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

//        System.out.println("------------XML-------------");
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Stormtrooper stormtrooperBean = context.getBean("stormtrooper", Stormtrooper.class);
//        Stormtrooper stormtrooperBean2 = context.getBean("stormtrooper", Stormtrooper.class);
//        stormtrooperBean.getInHands();
//        System.out.println(stormtrooperBean.getName());
//        System.out.println(stormtrooperBean == stormtrooperBean2);
//
//        System.out.println("--------XML + Annotation----------");
//        Jedi jedi = context.getBean("jedi", Jedi.class);
//        Jedi jedi2 = context.getBean("jedi", Jedi.class);
//        System.out.println(jedi == jedi2);
//        jedi.getInHands();

        System.out.println("--------Java config----------");
        ApplicationContext annContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Sith sith = annContext.getBean("sith", Sith.class);
        Sith sith2 = annContext.getBean("sith", Sith.class);
        System.out.println(sith.toString());
        System.out.println(sith == sith2);
    }
}
