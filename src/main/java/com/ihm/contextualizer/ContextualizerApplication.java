package com.ihm.contextualizer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {})
@EnableMongoRepositories

public class ContextualizerApplication{

    public static void main(String[] args) {
        //SpringApplication.run(ContextualizerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(ContextualizerApplication.class);
        springApplication.run(args);
    }



}
