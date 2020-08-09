package com.kovalenko.spring.annconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.kovalenko.spring.annconfig")
public class AnnotationConfig {

  @Bean("sith")
  @Scope("prototype")
  public Sith getSith() {

    Sith sith = new Sith();
    sith.setName("Lord");
    sith.setShip(getShip());
    sith.setSaber(getSaber());
    return sith;
  }

  @Bean("ship")
  public Ship getShip() {

    Ship ship = new Ship();
    ship.setName("mega-destroyer");
    return ship;
  }

  @Bean("saber")
  public Saber getSaber(){
    Saber saber = new Saber();
    saber.setName("dark-black");
    return saber;
  }
}
