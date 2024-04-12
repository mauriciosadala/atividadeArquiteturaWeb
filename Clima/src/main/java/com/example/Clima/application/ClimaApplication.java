package com.example.Clima.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories(basePackages = "com.example.Clima.repository")
public class ClimaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClimaApplication.class, args);
    }
}
