package com.example.demo_pathresquet2.models;

import lombok.*;

import java.util.UUID;
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
@Data
@Builder
public class PersonDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;

    public PersonDTO(UUID id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
