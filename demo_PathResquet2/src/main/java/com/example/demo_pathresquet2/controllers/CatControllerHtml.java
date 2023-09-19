package com.example.demo_pathresquet2.controllers;

import com.example.demo_pathresquet2.services.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/cats")
@RequiredArgsConstructor

@RestController
public class CatControllerHtml {

        private List<CatService> catsList = new ArrayList<>();

        @GetMapping("/listing")
        public String catsList(Model model) {
            model.addAttribute("cats", catsList);
            return "cats/listing";
        }

        @GetMapping("/{id}")
        public String catsDetails(@PathVariable Long id, Model model) {
            CatService cats = getCatById(id);
            if (cats != null) {
                model.addAttribute("cat", cats);
                return "cats/details";
            } else {
                return "redirect:/cats/listing";
            }
        }

        @GetMapping("/api/v1/listing")
        @ResponseBody
        public List<CatService> apiCatList() {
            return catsList;
        }

        @GetMapping("/api/v1/details/{id}")
        @ResponseBody
        public CatService apiCatsDetails(@PathVariable Long id) {
            return getCatById(id);
        }

        private CatService getCatById(Long id) {
            for (CatService cats : catsList) {
                if (cats.getCats().equals(id)) {
                    return cats;
                }
            }
            return null;
        }
    }






