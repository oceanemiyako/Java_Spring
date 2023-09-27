package com.example.exo_security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
/*
Réaliser une application Web sécurisée disposant de plusieurs pages. Vous devrez avoir trois pages demandant d'être connectés pour être accessibles et deux pages permettant leur accès à n'importe quel utilisateur.
 */
@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {

    @GetMapping
    public String getHomePage() {
        return "home";
    }




}
