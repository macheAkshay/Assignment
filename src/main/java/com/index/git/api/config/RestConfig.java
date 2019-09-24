package com.index.git.api.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.index.*"})
public class RestConfig {

	private static final Logger logger = Logger.getLogger(RestConfig.class);
	
	static {
		
		System.out.println("RestConfig Loaded...!");
		logger.info("RestConfig Loaded...!");
	}
}
