package com.ihm.contextualizer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@EnableMongoRepositories
public class ContextualizerApplication{

    public static void main(String[] args) {
        //SpringApplication.run(ContextualizerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(ContextualizerApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
        springApplication.run(args);
    }



}
