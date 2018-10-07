package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@PropertySource("classpath:roles.properties") // поддерживает только properties фалй
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "ldapx")
public class SupportedRoleTemplatesProperties {

    private String username;
    private List<String> supportedRoleTemplates = new ArrayList<>();

}
