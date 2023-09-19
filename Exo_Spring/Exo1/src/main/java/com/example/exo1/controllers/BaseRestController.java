package com.example.exo1.controllers;


import com.example.exo1.models.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class BaseRestController {

 // Pour l'api on met @responseBody et renvoi en json

    @GetMapping("/api/v1/detail") //http://localhost:8080/api/v1/base
    @ResponseBody
    public Person detail() {
        return new Person("Yugi", "giho", "yugiho@test.com");
    }

    @GetMapping("/api/v1/TextData")
    @ResponseBody
    public String apiTextData() {
        return "bliblibli";
    }

    @GetMapping("/textlist")
    public String textList(Model model) {
        List<String> texts = new ArrayList<>();
        texts.add("Texte 1");
        texts.add("Texte 2");
        model.addAttribute("texts", texts);
        return "text-list";
    }

    @GetMapping("/api/v1/TextList")
    @ResponseBody
    public List<String> apiTextList() {
        List<String> texts = new ArrayList<>();
        texts.add("Texte 1");
        texts.add("Texte 2");
        return texts;
    }
}
