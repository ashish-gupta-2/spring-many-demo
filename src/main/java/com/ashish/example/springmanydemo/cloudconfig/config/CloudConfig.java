package com.ashish.example.springmanydemo.cloudconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RefreshScope
@ConfigurationProperties(value = "app")
@Component
public class CloudConfig {
    private String message;
    private String message1;
}
