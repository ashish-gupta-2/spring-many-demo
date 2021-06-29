package com.ashish.example.springmanydemo.h2.controller;

import com.ashish.example.springmanydemo.h2.dao.PersonRepo;
import com.ashish.example.springmanydemo.h2.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class H2TestController {
    PersonRepo personRepo;

    public H2TestController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @RequestMapping("/")
    public String home() {
        log.info("Calling Home...");
        return "home";
    }

    @RequestMapping("/addPerson")
    public ModelAndView addPerson(Person person) {
        log.info("Saving Customer...");
        String msg = "";
        try {
            personRepo.save(person);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message",msg);
        return modelAndView;
    }

    @RequestMapping("/findPerson")
    public ModelAndView findPerson(@RequestParam Integer pid) {
        log.info("Fetching Person...");
        Person person = personRepo.findById(pid).orElse(new Person());
        log.info(person + "");

        List<Person> personsGender = personRepo.findByGender(person.getGender());
        List<Person> personsPid = personRepo.findByPidGreaterThan(pid);
        List<Person> personsGenderOrder = personRepo.findByGenderWithOrderName(person.getGender());

        log.info("personsGender:: {}",personsGender);
        log.info("personsPid:: {}",personsPid+"");
        log.info("personsGenderOrder:: {}",personsGenderOrder+"");


        ModelAndView modelAndView = new ModelAndView("fetch");
        modelAndView.addObject(person);
        return modelAndView;
    }

    @RequestMapping("/updatePerson")
    public ModelAndView updatePerson(Person person) {
        log.info("updating Customer...");
        String msg = "";
        try {
            personRepo.save(person);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message",msg);
        return modelAndView;
    }

    @RequestMapping("/deletePerson")
    public ModelAndView deletePerson(@RequestParam Integer pid) {
        log.info("deleting Customer...");
        String msg = "";
        try {
            personRepo.deleteById(pid);
        } catch (Exception e) {
            log.error(e.getMessage());
            msg = e.getMessage();
        }

        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message",msg);
        return modelAndView;
    }

}
