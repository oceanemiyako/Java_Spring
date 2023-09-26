package com.example.exo_pokemon.controllers;

import com.example.exo_pokemon.exceptions.ElementNotFoundException;
import com.example.exo_pokemon.models.PokemonDTO;
import com.example.exo_pokemon.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pokemon")
public class PokemonRestController {

    private final PokemonService pokemonService;


    @GetMapping("{value}")
    public String getPokemon(
            @PathVariable String value,
            Model model
    ) throws ElementNotFoundException {
        PokemonDTO pokemonDTO = pokemonService.getPokemon(" ");
        int pokemonCount = pokemonService.getPokemonCount();

        if (pokemonDTO != null) {
            model.addAttribute("pokemon", pokemonDTO);
            model.addAttribute("count", pokemonCount);

            return "pokemon/details";
        }
        throw new ElementNotFoundException();
    }

    @GetMapping("pokemon/{pokeName}")
    public PokemonDTO getPokemonByName(@PathVariable String pokeName) {
        return pokemonService.getPokemon(pokeName);
    }


}
