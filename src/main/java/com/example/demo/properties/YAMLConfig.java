package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Component
@ConfigurationProperties()
public class YAMLConfig {

    private String name;
    private String environment;
    private Set<String> servers = new HashSet<>();

}
