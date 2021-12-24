package com.growmore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GrowmoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowmoreEurekaServerApplication.class, args);
	}

}
