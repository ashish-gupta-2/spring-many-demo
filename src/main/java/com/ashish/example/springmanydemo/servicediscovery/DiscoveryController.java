package com.ashish.example.springmanydemo.servicediscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiscoveryController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/messagefrommicro")
    public String messageFromMicroService(){
        return restTemplate.getForObject("http://microservice/micro-message",String.class);
    }
}
