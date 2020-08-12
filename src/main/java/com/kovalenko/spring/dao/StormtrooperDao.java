package com.kovalenko.spring.dao;

import com.kovalenko.spring.model.Stormtrooper;

import java.util.List;

public interface StormtrooperDao {

  List<Stormtrooper> getAll();

  void save (Stormtrooper stormtrooper);

  void deleteById (Long id);

  void update (Stormtrooper stormtrooper);
}
