package com.example.demo_spring_bootstrap.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ContactDTO {

    private UUID id;
    private String lastname;
    private String firstname;
    private String email;
    private String phone;

}
