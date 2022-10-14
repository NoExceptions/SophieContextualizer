package com.ihm.contextualizer;

import com.mongodb.ConnectionString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MongoConfiguration {

    @Bean
    public ReactiveMongoDatabaseFactory mongoDatabaseFactory(){
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString("mongodb+srv://ihm:ihm_2022@cluster0.dkwemoo.mongodb.net/SContextDB?retryWrites=true&w=majority"));
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        ReactiveMongoTemplate ans = new ReactiveMongoTemplate(mongoDatabaseFactory());
        return ans;
    }


}