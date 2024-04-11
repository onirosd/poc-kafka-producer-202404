## #########################
## DESCRIPCION ##
## #########################

Proyecto desarrollado con Spring Boot  como microservicio  y utilizando una estructura de Polling de Base de Datos
para poder escuchar las inserciones de registros en una tabla de azure database.

## #########################
## COMANDOS ##
## #########################

## Comando para crear proyecto spring boot

spring init --dependencies=web,kafka,data-jpa,sqlserver --build=maven proyecto-kafka_02


## Comando para instalar las dependencias sin ejecutar test
 mvn install -DskipTests

## Comando para instalar todo de nuevo  , instalar dependencias y ejecutar test.
mvn clean install

## Comando para correr el sring boot
mvn spring-boot:run

## #########################
## GIT REPOSITORIO ##
## #########################

https://github.com/onirosd/poc-kafka-producer-202404/tree/main

## #########################
## DOCUMENTACION IMPORTANTE ##
## #########################

-- Proyectos en Sporing Boot
https://www.javaguides.net/2018/10/free-open-source-projects-using-spring-boot.html#google_vignette
-- Documentacion oficial Spring Boot
https://spring.io/quickstart
-- Arquitecturas Event Driven con Spring Boot  (interesante)
https://medium.com/@bubu.tripathy/event-driven-architecture-adb658a1dc9c
-- Demo con kafka , github 
https://github.com/redhat-developer-demos/kafka-java-demo/tree/main
-- Spring Inicializador de nuevo proyecto
https://start.spring.io/
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.installing.cli

-- Repositorios de version de kafka
https://dlcdn.apache.org/kafka/3.7.0/

