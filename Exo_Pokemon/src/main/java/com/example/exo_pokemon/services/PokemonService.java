package com.example.exo_pokemon.services;

import com.example.exo_pokemon.models.PokemonDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
public class PokemonService {

//    private final RestTemplateBuilder builder;
//
//    public ResponseEntity<String> getPostsString() {
//        RestTemplate restTemplate = builder.build();
//
//        ResponseEntity<String> entityString = restTemplate
//                .getForEntity("https://pokeapi.co/api/v2/pokemon", String.class);
//
//        return entityString;
//    }
//
//
//    public PokemonDTO getPokemon(String name) {
//        RestTemplate restTemplate = builder.build();
//
//        ResponseEntity<JsonNode> responseJson = restTemplate
//                .getForEntity("pokemon/" + name, JsonNode.class);
//
//        List<String> abilityNames = new ArrayList<>();
//
//        String nameFound = responseJson.getBody().get("name").asText();
//
//        responseJson.getBody().findPath("abilities").elements().forEachRemaining(a -> {
//            abilityNames.add(a.findPath("ability").get("name").asText());
//        });
//
//        return PokemonDTO
//                .builder()
//                .abilities(abilityNames)
//                .build();
//    }
//
//
//    public Integer getPokemonCount() {
//        RestTemplate restTemplate = builder.build();
//
//        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("pokedex", JsonNode.class);
//
//        if (responseEntity.getBody() != null) {
//            return responseEntity.getBody().get("pokemon").size();
//        }
//        return null;
//    }
//
//
//    private final RestTemplateBuilder restTemplateBuilder;
//
//    public PokemonDTO getPokemonDetails(String value) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<PokemonDTO> response = restTemplate.getForEntity("/pokemon/" + value, PokemonDTO.class);
//        String formattedId = String.format("%03d", response.getBody().getId());
//        response.getBody().setId(Integer.parseInt(formattedId));
//        return response.getBody();
//    }

    private final RestTemplateBuilder restTemplateBuilder;

    public PokemonDTO getPokemonDetails(String value) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<PokemonDTO> response = restTemplate.getForEntity("/pokemon/" + value, PokemonDTO.class);
        String formattedId = String.format("%03d", response.getBody().getId());
        response.getBody().setId(Integer.parseInt(formattedId));
        return response.getBody();
    }


}
