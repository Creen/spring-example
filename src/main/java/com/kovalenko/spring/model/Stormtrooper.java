package com.kovalenko.spring.model;

import lombok.Data;

@Data
public class Stormtrooper {

    private Long id;
    private String name;
    private Integer age;
    private Weapon weapon;
}
