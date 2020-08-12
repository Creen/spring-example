# Web Application

## About
A simple web application to manage an army of stormtroopers o take over the galaxy, using Spring MVC and Hibernate, configured by java-based configuration.

### Features
In progress...

### Languagues & Technologies
- Java
- Gradle
- Lombok
- Postgres
- Spring MVC
- Hibernate

### Reference

1. **Used Postgres, DriverManager to connect to the database and SQL.**

    Link to the [commit](https://github.com/Creen/spring-example/commit/8d50cce4e46257d368b29d7d5ca29b786018f354)

```
Class.forName("org.postgresql.Driver");
conn = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/spring",
    "user",
    "123"); 
```

