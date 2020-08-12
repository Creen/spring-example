package com.kovalenko.spring.dao.impl;

import com.kovalenko.spring.dao.StormtrooperDao;
import com.kovalenko.spring.model.Stormtrooper;
import com.kovalenko.spring.model.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("StormtrooperDaoImplJdbcTemplate")
//@RequiredArgsConstructor
public class StormtrooperDaoImplJdbcTemplate implements StormtrooperDao {

  private static final String GET_ALL_STORMTROOPERS =
      "SELECT s.stormtrooper_id, stormtrooper_name, stormtrooper_age, w.weapon_name\n"
          + "FROM stormtrooper AS s\n"
          + "LEFT JOIN weapon AS w\n"
          + "ON s.stormtrooper_id = w.stormtrooper_id;";

  private static final String DELETE_STORMTROOPER =
      "DELETE FROM stormtrooper WHERE stormtrooper_id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Stormtrooper> getAll() {

    return jdbcTemplate.query(GET_ALL_STORMTROOPERS, new RowMapper<Stormtrooper>() {
      @Override
      public Stormtrooper mapRow(ResultSet rs, int rowNum) throws SQLException {

        Weapon weapon = new Weapon();
        weapon.setName(rs.getString("weapon_name"));

        Stormtrooper stormtrooper = new Stormtrooper();
        stormtrooper.setId(rs.getLong("stormtrooper_id"));
        stormtrooper.setName(rs.getString("stormtrooper_name"));
        stormtrooper.setAge(rs.getInt("stormtrooper_age"));
        stormtrooper.setWeapon(weapon);

        return stormtrooper;
      }
    });
  }

  @Override
  public void save(Stormtrooper stormtrooper) {

  }

  @Override
  public void deleteById(Long id) {

    jdbcTemplate.update(DELETE_STORMTROOPER);
  }

  @Override
  public void update(Stormtrooper stormtrooper) {

  }
}
