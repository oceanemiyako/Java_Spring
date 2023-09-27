package com.example.exo_security2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
Réaliser une application Web permettant, de façon sécurisée, de modifier des entités de données. Par exemple, vous pouvez faire une liste de contacts, une liste de chiens, de voitures, etc...

La visualisation des données devra être publique (/dogs, /dogs/1, ...)

La modification des données devra être privée et demandera à un utilisateur d'être connecté (/dogs/add, /dog/delete/1, /dogs/edit/1, ...)

Les données se trouverons stockées en base de données via l'utilisation de PostgreSQL.

Vous utiliserez une sécurisation via l'Http Basic et le mécanisme de session de sorte à stocker en cookies votre état de sécurité.
 */
@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {


    @GetMapping
    public String getDogPage() {
        return "home";
    }





}
