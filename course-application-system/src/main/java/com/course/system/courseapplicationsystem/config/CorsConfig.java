package com.course.system.courseapplicationsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000/*","https://nayan-savi.github.io/react-course-app/#/*", "*")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*");
    }
}
