package com.example.jdata6_1.service;

import com.example.jdata6_1.entity.Person;
import com.example.jdata6_1.repository.CustomizedPersonRepository;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Data
@org.springframework.stereotype.Service
public class Service {

    private final CustomizedPersonRepository repository;

    public List<Person> getPersonsByCity(String city) {
        return repository.findAllByCityEquals(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return repository.findAllByAgeIsLessThan(age, Sort.by("age"));
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return repository.findByNameEqualsAndSurnameEquals(name, surname);
    }
}
