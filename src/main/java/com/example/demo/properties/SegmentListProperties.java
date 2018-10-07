package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "segment")
public class SegmentListProperties {

    private List<String> list;

    SegmentListProperties() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return this.list;
    }

}
