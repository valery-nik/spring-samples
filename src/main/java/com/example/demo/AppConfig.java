package com.example.demo;

import com.example.demo.properties.SupportedRoleTemplatesProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties({ApplicationProperties.class, SupportedRoleTemplatesProperties.class})
@EnableConfigurationProperties(SupportedRoleTemplatesProperties.class)
//@PropertySource({"myapp.properties"})
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {
}
