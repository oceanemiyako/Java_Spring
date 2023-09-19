package com.example.demo_pathresquet2.controllers;


import com.example.demo_pathresquet2.models.PersonDTO;
import com.example.demo_pathresquet2.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/persons")
@RestController
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService personService;

    @GetMapping("list")
    public List<PersonDTO> listPerson() {
        return personService.getPersons();
    }










}
