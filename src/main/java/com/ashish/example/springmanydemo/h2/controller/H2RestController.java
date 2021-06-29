package com.ashish.example.springmanydemo.h2.controller;

import com.ashish.example.springmanydemo.h2.dao.PersonRepo;
import com.ashish.example.springmanydemo.h2.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class H2RestController {
    PersonRepo personRepo;

    public H2RestController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping(path="/persons", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findAllPerson() {
        log.info("Fetching All Customer...");
        return personRepo.findAll();
    }

    @GetMapping("/person/{pid}")
    public Optional<Person> findPersonById(@PathVariable("pid") Integer pid) {
        log.info("Fetching Customer By id ...");
        return personRepo.findById(pid);
    }

    @PostMapping("/person")
    public Person addPersonRest(@RequestBody Person person) {
        log.info("Adding Customer By Rest ...");
        return personRepo.save(person);
    }

    @DeleteMapping("/person/{pid}")
    public String deletePersonById(@PathVariable("pid") Integer pid) {
        log.info("Deleting Customer By id ...");
        Person p = personRepo.getOne(pid);
        personRepo.delete(p);
        return "Deleted";
    }

    @PutMapping("/person")
    public String updatePersonById(@RequestBody Person person) {
        log.info("Updating Customer ...");
        personRepo.save(person);
        return "Updated";
    }
}
