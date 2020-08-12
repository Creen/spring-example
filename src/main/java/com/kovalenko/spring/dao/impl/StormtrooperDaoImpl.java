package com.kovalenko.spring.dao.impl;

import com.kovalenko.spring.config.DatabaseConfiguration;
import com.kovalenko.spring.dao.StormtrooperDao;
import com.kovalenko.spring.model.Stormtrooper;
import com.kovalenko.spring.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StormtrooperDaoImpl implements StormtrooperDao {

  private static final String GET_ALL_STORMTROOPERS =
      "SELECT s.stormtrooper_id, stormtrooper_name, stormtrooper_age, w.weapon_name\n"
      + "FROM stormtrooper AS s\n"
      + "LEFT JOIN weapon AS w\n"
      + "ON s.stormtrooper_id = w.stormtrooper_id;";

  private static final String INSERT_STORMTROOPER_NAME_AND_AGE =
      "INSERT INTO stormtrooper (stormtrooper_name, stormtrooper_age) VALUES (?, ?)";

  private static final String INSETN_STORMTROOPER_WEAPON =
      "INSERT INTO weapon (weapon_name, stormtrooper_id) VALUES (?, ?)";

  private static final String DELETE_STORMTROOPER =
      "DELETE FROM stormtrooper WHERE stormtrooper_id = ?";

  private static final String UPDATE_STORMTROOPER_NAME_AND_AGE =
      "UPDATE stormtrooper SET stormtrooper_name=?, stormtrooper_age=? WHERE stormtrooper_id=?";

  private static final String UPDATE_STORMTROOPER_WEAPON =
      "UPDATE weapon SET weapon_name=? WHERE stormtrooper_id=?";

  @Autowired
  private DatabaseConfiguration connection;

  @Override
  public List<Stormtrooper> getAll() {

    List<Stormtrooper> stormtroopers = new ArrayList<>();

    try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(GET_ALL_STORMTROOPERS);
        ResultSet resultSet = preparedStatement.executeQuery()){

      while (resultSet.next()) {

        Weapon weapon = new Weapon();
        weapon.setName(resultSet.getString("weapon_name"));

        Stormtrooper stormtrooper = new Stormtrooper();
        stormtrooper.setId(resultSet.getLong("stormtrooper_id"));
        stormtrooper.setName(resultSet.getString("stormtrooper_name"));
        stormtrooper.setAge(resultSet.getInt("stormtrooper_age"));
        stormtrooper.setWeapon(weapon);

        stormtroopers.add(stormtrooper);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }

    return stormtroopers;
  }

  @Override
  public void save(Stormtrooper stormtrooper) {

    try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(
        INSERT_STORMTROOPER_NAME_AND_AGE, PreparedStatement.RETURN_GENERATED_KEYS)) {

      preparedStatement.setString(1, stormtrooper.getName());
      preparedStatement.setInt(2, stormtrooper.getAge());

      int executeUpdate = preparedStatement.executeUpdate();

      if (executeUpdate > 0) {

        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement(
                INSETN_STORMTROOPER_WEAPON)) {

          if (generatedKeys.next()) {

            int generatedKeysInt = generatedKeys.getInt(1);
            preparedStatement1.setString(1, stormtrooper.getWeapon().getName());
            preparedStatement1.setLong(2, generatedKeysInt);
            preparedStatement1.executeUpdate();
          }
        }
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteById(Long id) {

    try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_STORMTROOPER)) {

      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Stormtrooper stormtrooper) {

    try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(
        UPDATE_STORMTROOPER_NAME_AND_AGE, PreparedStatement.RETURN_GENERATED_KEYS)) {

      preparedStatement.setString(1, stormtrooper.getName());
      preparedStatement.setInt(2, stormtrooper.getAge());
      preparedStatement.setLong(3, stormtrooper.getId());

      int executeUpdate = preparedStatement.executeUpdate();

      if (executeUpdate > 0) {

        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement(
                UPDATE_STORMTROOPER_WEAPON)) {

          if (generatedKeys.next()) {

            int generatedKeysInt = generatedKeys.getInt(1);
            preparedStatement1.setString(1, stormtrooper.getWeapon().getName());
            preparedStatement1.setLong(2, generatedKeysInt);
            preparedStatement1.executeUpdate();
          }
        }
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
