package com.kovalenko.spring.config;

import javafx.event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

@Configuration
//@PropertySource(value = {"classpath:application.properties"}) //3 approach
public class DatabaseConfiguration {

  //4 approach
//  @Value("${jdbc.name}")
//  private String driver;
//  @Value("${jdbc.url}")
//  private String url;
//  @Value("${jdbc.name}")
//  private String username;
//  @Value("${jdbc.password}")
//  private String password;

//  @Autowired //3 approach
//  private Environment environment;
//
//  @Bean //1 approach
//  public Connection getConnection() {
//
//    Connection conn = null;
//    try {
//      Class.forName("org.postgresql.Driver");
//      conn = DriverManager.getConnection(
//          "jdbc:postgresql://localhost:5432/spring",
//          "user",
//          "123");
//    }
//    catch (SQLException | ClassNotFoundException e) {
//      e.printStackTrace();
//    }
//    return conn;
//  }

  @Bean //2 approach
  public DataSource dataSource() {

    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/spring");
    dataSource.setUsername("user");
    dataSource.setPassword("123");

    return dataSource;
  }
//
//  @Bean //3 approach
//  public DataSource dataSourceWithProperties() {
//
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.Driver")));
//    dataSource.setUrl(environment.getProperty("jdbc.url"));
//    dataSource.setUsername(environment.getProperty("jdbc.name"));
//    dataSource.setPassword(environment.getProperty("jdbc.password"));
//
//    return dataSource;
//  }
//
//  @Bean //4 approach
//  public DataSource dataSourceWithProperties2() {
//
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(driver);
//    dataSource.setUrl(url);
//    dataSource.setUsername(username);
//    dataSource.setPassword(password);
//
//    return dataSource;
//  }

  @Bean //2 approach
  public JdbcTemplate jdbcTemplate() {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource());

    return jdbcTemplate;
  }
}
