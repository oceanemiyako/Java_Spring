package com.example.exo_security2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class DogEntity {

@Id
@GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String name;
    private String breed;
    private Integer age;

}
