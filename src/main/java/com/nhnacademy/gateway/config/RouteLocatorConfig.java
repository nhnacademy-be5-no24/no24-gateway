package com.nhnacademy.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {
    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("shop-service",
                        p->p.path("/shop/**").and()
                                .uri("lb://SHOP-SERVICE")
                )
                .route("auth-service",
                        p -> p.path("/auth/**")
                                .or()
                                .path("/login/**")
                                .or()
                                .path("/logout/**")
                                .uri("lb://AUTH-SERVICE")
                )
                .route("delivery-service",
                        p -> p.path("/delivery/**").and()
                                .uri("lb://DELIVERY-SERVICE")
                )
                .build();

    }
}
