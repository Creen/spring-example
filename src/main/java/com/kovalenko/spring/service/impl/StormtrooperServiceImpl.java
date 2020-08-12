package com.kovalenko.spring.service.impl;

import com.kovalenko.spring.dao.StormtrooperDao;
import com.kovalenko.spring.exeption.StormtrooperException;
import com.kovalenko.spring.model.Stormtrooper;
import com.kovalenko.spring.service.StormtrooperService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class StormtrooperServiceImpl implements StormtrooperService {

  private final StormtrooperDao stormtrooperDao;

  public StormtrooperServiceImpl(@Qualifier("StormtrooperDaoImplJdbcTemplate") StormtrooperDao stormtrooperDao) {
    this.stormtrooperDao = stormtrooperDao;
  }

  @Override
  public List<Stormtrooper> getAll() {
    return stormtrooperDao.getAll();
  }

  @Override
  public Stormtrooper updateById(Long id) {

    Stormtrooper stormtrooperToUpdate = getAll().stream()
        .filter(stormtrooper -> stormtrooper.getId().equals(id))
        .findFirst()
        .orElse(null);

    stormtrooperDao.update(stormtrooperToUpdate);
    return stormtrooperToUpdate;
  }

  @Override
  public void deleteById(Long id) {
    stormtrooperDao.deleteById(id);
  }

  @Override
  public void save(Stormtrooper stormtrooper) {
    if (checkIfStormtrooperNameIsExist(stormtrooper)) {
      throw new StormtrooperException("Stormtrooper with that name is already exist");
    } else {
      stormtrooperDao.save(stormtrooper);
    }
  }

  private boolean checkIfStormtrooperNameIsExist(Stormtrooper stormtrooper) {

    List<Stormtrooper> stormtroopers = getAll().stream()
        .filter(stormtrooperDB -> stormtrooperDB.getName().equals(stormtrooper.getName()))
        .collect(Collectors.toList());

    if (!stormtroopers.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}