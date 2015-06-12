package com.dev.mas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

public class SpringMongoConfig {

	public @Bean MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(
				"localhost", 27017), "local");
		return mongoTemplate;

	}

}
