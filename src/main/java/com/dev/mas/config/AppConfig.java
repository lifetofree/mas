package com.dev.mas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "com.dev.mas.config", "com.dev.mas.controller",
		"com.dev.mas.dao", "com.dev.mas.model", "com.dev.mas.service" })
@Import({ MongoConfig.class })
public class AppConfig {

}
