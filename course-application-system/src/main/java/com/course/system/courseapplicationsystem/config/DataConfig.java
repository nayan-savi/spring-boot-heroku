package com.course.system.courseapplicationsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.course.system.courseapplicationsystem.repository")
public class DataConfig {
}
