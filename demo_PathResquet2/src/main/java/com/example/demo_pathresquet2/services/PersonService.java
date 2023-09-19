package com.example.demo_pathresquet2.services;


import com.example.demo_pathresquet2.models.PersonDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class PersonService {

    private final Map<UUID, PersonDTO> persons;

    public PersonService(){
        persons = new HashMap<>();

        PersonDTO personA = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Oceane")
                .lastName("Garcia")
                .age(28)
                .build();

        PersonDTO personB = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Nicolas")
                .lastName("Bouriez")
                .age(30)
                .build();

        PersonDTO personC = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Bapt")
                .lastName("Break")
                .age(29)
                .build();

        PersonDTO personD = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Hug")
                .lastName("Font")
                .age(23)
                .build();

        persons.put(personA.getId(),personA);
        persons.put(personB.getId(), personB);
        persons.put(personC.getId(), personC);
        persons.put(personD.getId(), personD);


    }

    public List<PersonDTO> getPersons(){
        return persons.values().stream().toList();
    }

    public Optional<PersonDTO> getPersonById(UUID id){
       return persons.values().stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public PersonDTO getPersonByIdBis(UUID id){
        return  persons.values().stream()
                .filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
