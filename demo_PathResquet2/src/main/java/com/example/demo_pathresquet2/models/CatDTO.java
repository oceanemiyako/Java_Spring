package com.example.demo_pathresquet2.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CatDTO {

    private UUID id;
    private String name;
    private String breed;
    private Integer age;

}
