package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ActiveProfiles("test")
@TestExecutionListeners(MockitoTestExecutionListener.class)
@ContextConfiguration(classes = YAMLSupportedRoleTemplatesPropertiesTest.YAMLSupportedRoleTemplatesPropertiesConfig.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class YAMLSupportedRoleTemplatesPropertiesTest extends AbstractTestNGSpringContextTests {

    @Autowired
    YAMLSupportedRoleTemplatesProperties yamlRoleTemplates;

    @Autowired
    SupportedRoleTemplatesProperties propsRoleTemplates;

    @Test
    public void checkCorrectWorkWithRoleTemplates() {
        System.out.println("------------------------ application.yaml ------------------------");
        yamlRoleTemplates.getSupportedRoleTemplates().forEach(System.out::println);
        System.out.println("------------------------ roles.properties ------------------------");
        propsRoleTemplates.getSupportedRoleTemplates().forEach(System.out::println);
    }

    @ComponentScan(basePackages = {"com.example.demo.properties"})
    @EnableConfigurationProperties()
    @SpringBootConfiguration
    static class YAMLSupportedRoleTemplatesPropertiesConfig {

    }

}