package com.kovalenko.spring.config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {

  public Connection getConnection() {

    Connection conn = null;
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/spring",
          "user",
          "123");
    }
    catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return conn;
  }

}
