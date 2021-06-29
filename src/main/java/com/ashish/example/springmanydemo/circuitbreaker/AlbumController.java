package com.ashish.example.springmanydemo.circuitbreaker;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AlbumController {

    private AlbumService service;

    @GetMapping("/albums")
    public String albums() {
        return service.getAlbumList();
    }

}
