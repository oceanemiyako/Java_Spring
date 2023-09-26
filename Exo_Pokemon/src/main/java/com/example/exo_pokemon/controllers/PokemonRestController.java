package com.example.exo_pokemon.controllers;

import com.example.exo_pokemon.exceptions.ElementNotFoundException;
import com.example.exo_pokemon.models.PokemonDTO;
import com.example.exo_pokemon.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/pokemon")
public class PokemonRestController {
//
//    private final PokemonService pokemonService;
//
//    @GetMapping
//    public String getHome() {
//        return "home";
//    }


    /*@GetMapping("{value}")
    public String getPokemon(
            @PathVariable String value,
            Model model
    ) throws ElementNotFoundException {
        PokemonDTO pokemonDTO = pokemonService.getPokemon(" ");
        int pokemonCount = pokemonService.getPokemonCount();

        if (pokemonDTO != null) {
            model.addAttribute("pokemon", pokemonDTO);
            model.addAttribute("count", pokemonCount);

            return "home";
        }
        throw new ElementNotFoundException();
    }

    @GetMapping("/{pokeName}")
    public PokemonDTO getPokemonByName(@PathVariable String pokeName) {

        return pokemonService.getPokemon(pokeName);
    }*/
//    @GetMapping("toto")
//    public String getPokemonDetails() {
//        String value = "1";
//        String finalValue;
//
//        try {
//            Integer valueAsInteger = Integer.parseInt(value);
//            finalValue = valueAsInteger.toString();
//        } catch (NumberFormatException ex) {
//            finalValue = value;
//        }
//
//        PokemonDTO response = pokemonService.getPokemonDetails(finalValue);
//
//        return "home";
//    }

}
