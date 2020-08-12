package com.kovalenko.spring.service;

import com.kovalenko.spring.model.Stormtrooper;

import java.util.List;

public interface StormtrooperService {

  List<Stormtrooper> getAll();

  void deleteById(Long id);

  Stormtrooper updateById(Long id);

  void save(Stormtrooper stormtrooper);
}
