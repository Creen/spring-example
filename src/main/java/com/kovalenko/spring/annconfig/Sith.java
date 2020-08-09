package com.kovalenko.spring.annconfig;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//@Component
public class Sith {

  private String name;
  private Ship ship;
  private Saber saber;
}
