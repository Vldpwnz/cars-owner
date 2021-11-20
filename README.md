# springboot-sample-app

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/be/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle 7.2](https://gradle.org/)

Clone project: 

``` 
$ git clone https://github.com/Vldpwnz/cars-owner
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `/cars-owner/src/main/java/ee/hansabIT/CarsOwnerApplication.java` class from your IDE.

Also you can run: 
```
gradle bootRun
```

## Running tests

To verify if everything works as desired run tests: 

```shell
gradle test
```
In command line should see message:

**_BUILD SUCCESS_**

## Rest endpoints

Implemented following endpoints: 

- GET /users
- GET /users/1
- GET /users/1/cars
- GET /cars
- GET /cars/1

Run in shell to test endpoints: 

```
$ curl http://localhost:8080/<endpoint_uri>
or
$ curl http://localhost:8080/<users/cars>?find=<search_value>&sort=<sort_field>&order=<asc/desc>&page=<page_number>
```
- <users/cars> - uri endpoins
- <search_value> - search keyword
  - find parameter is optional
- <sort_field> - field you want sort by
  - sort is optional
- <asc/desc> - order ascending or descending
  - order is optional
- <page_number> number of page you need to load (implemented pagination)

**There is no direct order required for parameters sended to api**

## Frontend part

Frontend part is loaded to a different GitHub project: [cars-owner-frontend](https://github.com/Vldpwnz/cars-owner-front)
  

