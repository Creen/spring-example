package com.kovalenko.spring.dao;

import com.kovalenko.spring.model.Stormtrooper;

import java.util.List;

public interface StormtrooperDao {

  List<Stormtrooper> getAll();

  Stormtrooper getNewStormtrooper();
}
