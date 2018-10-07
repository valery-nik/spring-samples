package com.example.demo;

import com.example.demo.properties.YAMLConfig;
import com.example.demo.properties.YAMLSupportedRoleTemplatesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class DemoApplicationTests implements CommandLineRunner {

    @Autowired
    private YAMLConfig myConfig;

    @Autowired
    private YAMLSupportedRoleTemplatesProperties yamlSupportedRoleTemplatesProperties;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplicationTests.class);
        app.run();
    }

    public void run(String... args) throws Exception {
        System.out.println("using environment: " + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
        System.out.println("servers: " + myConfig.getServers());
//        using environment: production
//        name: prod-YAML
//        servers: [www.abc.com, www.xyz.com]

        System.out.println("---------------------------------application.yml---------------------------------");
        System.out.println("ldap.username: " + yamlSupportedRoleTemplatesProperties.getUsername());
        System.out.println("ldap.supportedRoleTemplates: " + yamlSupportedRoleTemplatesProperties.getSupportedRoleTemplates());
        System.out.println("---------------------------------------------------------------------------------");

    }
}
