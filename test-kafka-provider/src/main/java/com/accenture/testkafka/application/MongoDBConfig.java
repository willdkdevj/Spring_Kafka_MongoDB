package com.accenture.testkafka.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoDatabaseFactory mongoConfigure(){
        return new SimpleMongoClientDatabaseFactory(("mongodb://root:root@localhost:27017/order-catalog?authSource=admin"));
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory factory){
        return new MongoTemplate(factory);
    }

}
