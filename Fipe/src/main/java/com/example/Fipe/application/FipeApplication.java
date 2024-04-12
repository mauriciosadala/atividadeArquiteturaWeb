package com.example.Fipe.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories(basePackages = "com.example.Fipe.repository")
public class FipeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FipeApplication.class, args);
    }
}
