package com.example.jdata6_1.controller;

import com.example.jdata6_1.entity.Person;
import com.example.jdata6_1.service.Service;
import com.example.jdata6_1.service.UserCredentialsService;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/persons")
public class Controller {

    private final Service service;
    private final ApplicationContext context;

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age-less-than")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return service.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/by-name-and-surname")
    @PreAuthorize("hasRole('ROLE_READ') or hasRole('ROLE_WRITE')")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/accountinfo")
    @PreAuthorize("#username == authentication.principal.username")
    public UserDetails getInfoByUsername(@RequestParam String username) {
        UserCredentialsService service = context.getBean(UserCredentialsService.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return service.loadUserByUsername(currentPrincipalName);
    }

}


