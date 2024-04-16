package com.talentreef.interviewquestions.takehome.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        /*
        addMapping - Specify the URL pattern to which CORS config will apply
        allowedOrigins - Specify the origins that are allowed to make requests to the app
        allowedMethods - The types of requests accepted
        allowCredentials - Specifies whether or not the app allows cookies or HTTP auth
        maxAge - Amount of time (seconds) that a browser should cache the CORS config
        */
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}