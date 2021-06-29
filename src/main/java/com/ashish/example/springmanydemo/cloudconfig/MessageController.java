package com.ashish.example.springmanydemo.cloudconfig;

import com.ashish.example.springmanydemo.cloudconfig.config.CloudConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Configuration
@RestController
public class MessageController {

    @Autowired
    CloudConfig cloudConfig;


    @Value("${app.message : Default Hello}")
    String message;

    @GetMapping("/message")
    public String albums() {
        return message;
    }

    @GetMapping("/cloudmessage")
    public String getMessage() {
        return cloudConfig.getMessage()+ "----"+cloudConfig.getMessage1();
    }
}
