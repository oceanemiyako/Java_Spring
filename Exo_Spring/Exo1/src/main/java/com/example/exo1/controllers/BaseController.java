package com.example.exo1.controllers;

import ch.qos.logback.core.model.Model;
import com.example.exo1.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/")
@Controller
public class BaseController {
    @GetMapping("/personDetail")
        public String personDetails(Model model) {
            Person person = new Person("Leetchi","Leet", "leetchileet@test.com");
            model.addAttribute("person", person);
            return "PersonDetail";
        }

        @GetMapping("/api/v1/person-details")
        @ResponseBody
        public Person apiPersonDetails() {
            return new Person("Yugi", "giho", "yugiho@test.com");
        }

        @GetMapping("/text-data")
        public String textData(Model model) {
            model.addAttribute("text", "Ceci est un élément simple de type textuel.");
            return "text-data";
        }

        @GetMapping("/api/v1/text-data")
        @ResponseBody
        public String apiTextData() {
            return "Ceci est un élément simple de type textuel.";
        }

        @GetMapping("/text-list")
        public String textList(Model model) {
            List<String> texts = new ArrayList<>();
            texts.add("Texte 1");
            texts.add("Texte 2");
            model.addAttribute("texts", texts);
            return "text-list";
        }

        @GetMapping("/api/v1/text-list")
        @ResponseBody
        public List<String> apiTextList() {
            List<String> texts = new ArrayList<>();
            texts.add("Texte 1");
            texts.add("Texte 2");
            return texts;
        }
}


