# Stomp the Yard

<h1 align="center">
  <img alt="dance gif" src="dance.gif"/>
</h1>

An ideal music provider for you in a perfect occasion.

### Requirements

* Java 13
* [Spring Boot with Maven](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [PostgreSQL](https://www.postgresql.org/)

### How to run

Create an empty database in PostgreSQL named `hiphop` with the user `amazing` and an empty password.

```bash
$ createuser -U postgres -s amazing
$ createdb amazing
$ psql -U amazing

amazing-# CREATE DATABASE hiphop; 
```

Use the Maven Wrapper embedded inside project to build and run your application:

```bash
$ ./mvnw spring-boot:run
```