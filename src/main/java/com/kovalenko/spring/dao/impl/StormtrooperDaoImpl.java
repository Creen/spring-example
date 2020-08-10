package com.kovalenko.spring.dao.impl;

import com.kovalenko.spring.dao.StormtrooperDao;
import com.kovalenko.spring.model.Stormtrooper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StormtrooperDaoImpl implements StormtrooperDao {

  private List<Stormtrooper> stormtroopers = new ArrayList<>();
  private long identifier = 1;

  @Override
  public List<Stormtrooper> getAll() {
    return stormtroopers;
  }

  @Override
  public Stormtrooper getNewStormtrooper() {
    Stormtrooper stormtrooper = new Stormtrooper();
    stormtrooper.setId(identifier++);
    return stormtrooper;
  }
}
