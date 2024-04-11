package com.example.proyectokafka_02;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication{
    public static void main(String[] args) {
        System.setProperty("user.timezone", "America/Lima");
        TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
        SpringApplication.run(DemoApplication.class, args);
    }
}
