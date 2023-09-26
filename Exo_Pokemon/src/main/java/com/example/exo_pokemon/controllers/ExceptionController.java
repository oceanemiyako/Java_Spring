package com.example.exo_pokemon.controllers;
import org.springframework.web.client.RestClientException;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RestClientException.class)
    public String handleRestClientException() {
        return "error/404";
    }
}
