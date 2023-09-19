package com.example.demo_pathresquet2.services;

import com.example.demo_pathresquet2.models.CatDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Primary
public class CatService {

    private final Map<UUID, CatDTO> cats;

    public CatService(){
        cats = new HashMap<>();

        CatDTO catsA = CatDTO.builder()
                .id(UUID.randomUUID())
                .name("Leetchi")
                .breed("Persan")
                .age(4).build();

        CatDTO catsB = CatDTO.builder()
                .id(UUID.randomUUID())
                .name("Yugi")
                .breed("Chartreux")
                .age(3).build();

        CatDTO catsC = CatDTO.builder()
                .id(UUID.randomUUID())
                .name("Maki")
                .breed("Norvegien")
                .age(6).build();

        CatDTO catsD = CatDTO.builder()
                .id(UUID.randomUUID())
                .name("Akuma")
                .breed("Bombay")
                .age(5).build();

        cats.put(catsA.getId(),catsA);
        cats.put(catsB.getId(), catsB);
        cats.put(catsC.getId(), catsC);
        cats.put(catsD.getId(), catsD);


    }

    public List<CatDTO> getCats() {
        return cats.values().stream().toList();
    }

    public CatDTO getCatById(UUID id){
        return  cats.values().stream()
                .filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
