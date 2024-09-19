package com.kdg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // 허용할 origin을 여기에 추가
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH")
                .allowCredentials(true)
                .maxAge(3600);
    }
}