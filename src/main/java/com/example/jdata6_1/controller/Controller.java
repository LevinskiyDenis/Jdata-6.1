package com.example.jdata6_1.controller;

import com.example.jdata6_1.entity.Person;
import com.example.jdata6_1.service.Service;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/persons")

public class Controller {

    private final Service service;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age-less-than")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return service.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

}


