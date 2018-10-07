package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "ldap")
public class YAMLSupportedRoleTemplatesProperties {

    private String username;
    private List<String> supportedRoleTemplates = new ArrayList<>();

}
