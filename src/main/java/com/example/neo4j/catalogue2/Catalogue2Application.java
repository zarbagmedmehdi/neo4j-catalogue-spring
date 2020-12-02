package com.example.neo4j.catalogue2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Catalogue2Application {

    public static void main(String[] args) {
        SpringApplication.run(Catalogue2Application.class, args);
    }
    @Configuration
    class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {

            registry.addMapping("/**").allowedOrigins(
                            "http://localhost:4200").
                    allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                    .allowCredentials(true)
            ;
        }    }
}
