# Archetype Spring Boot

## About

Ce projet a pour but de servir de base à la création de futures applications. Il repose sur le framework Spring Boot. 

## Technical Stack

- Java 1.8+
- Maven 3.3+
- Spring boot 1.5.6
- Lombok abstraction
- JPA with H2 for explanation
- Swagger 2 API documentation
- Spring retry and circuit breaker for external service call
- REST API model validation 
- Spring cloud config for external configuration on GIT REPO
- Cucumber and Spring Boot test for integration test
- Jenkins Pipeline for multi branch project
- Continuous delivery and integration standards with Sonar check and release management
- Support retry in sanity checks  

## Installation

-  to run locally , you need to configure the run configuration by passing :
1- VM parameter: -DLOG_PATH=../log
2- Set SPRING profile to LOCAL 

## TODO

* Màj version Spring Boot
* Mapping d'entité Bean vers DTO
* Authentification Google et Facebook
