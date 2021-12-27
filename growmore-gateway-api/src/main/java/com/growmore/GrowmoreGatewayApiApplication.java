package com.growmore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GrowmoreGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowmoreGatewayApiApplication.class, args);
	}
	@Bean
	public RouteLocator customRoute(RouteLocatorBuilder builder) {

		return builder.routes().
						route("farmerService", r -> r.path("/farmer-api/**")
						.uri("lb://FARMER-SERVICE"))
				.route("problemService", r -> r.path("/problem-api/**")
						.uri("lb://PROBLEM-SERVICE"))
				.route("analystService",r->r.path("/analyst-api/**")
						.uri("lb://ANALYST-SERVICE"))
				.build();


	}

}
