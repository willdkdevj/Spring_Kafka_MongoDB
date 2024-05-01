package com.accenture.testkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TestKafkaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestKafkaProviderApplication.class, args);
	}

}
