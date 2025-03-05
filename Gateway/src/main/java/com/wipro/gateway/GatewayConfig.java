package com.wipro.gateway;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
        		 .route("order-service", r -> r.path("/order/**")
        	                .and().method("GET", "POST")  // Allows GET and POST requests
        	                .uri("http://localhost:8082"))
        	            .route("user-service", r -> r.path("/user/**")
        	                .and().method("GET", "POST")
        	                .uri("http://localhost:8083"))
        	            .build();
    }
}

