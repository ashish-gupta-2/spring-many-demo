package com.ashish.example.springmanydemo.circuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class AlbumService {

    RestTemplate restTemplate;

    @CircuitBreaker(name="albumService", fallbackMethod = "orderFallback")
    public String getAlbumList() {
        String url = "https://jsonplaceholder.typicode.com/albums";
        return  restTemplate.getForObject(url, String.class);
    }

    public String orderFallback(Exception e){
        return "Album service is down";

    }
}
