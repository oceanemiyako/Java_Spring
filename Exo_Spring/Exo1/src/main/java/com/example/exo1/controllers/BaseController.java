package com.example.exo1.controllers;

import com.example.exo1.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/base") //http://localhost:8080/ renvoi avec une page html (vue)
@Controller
public class BaseController {
    @GetMapping("/home")
        public String home(Model model) {
            Person person = new Person("Leetchi","Leet", "leetchileet@test.com");
            model.addAttribute("person", person);
            return "home";
        }


        @GetMapping("/textData")
        public String textData(Model model) {
            model.addAttribute("text", "blablabla");
            return "text-data";
        }

}


