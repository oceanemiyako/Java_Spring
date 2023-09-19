package com.example.demo_pathresquet2.controllers;


import com.example.demo_pathresquet2.exception.ResourceNotFoundException;
import com.example.demo_pathresquet2.models.CatDTO;
import com.example.demo_pathresquet2.services.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/cats")
@RestController
@RequiredArgsConstructor
public class CatRestController {

    private final CatService catService;

    @GetMapping("list") // GET http://localhost:8080/api/v1/cats/list
    public List<CatDTO> listCat() {
        return catService.getCats();
    }

    @GetMapping("details/{catId}") // GET http://localhost:8080/api/v1/cats/details/XXXXX
    public ResponseEntity<CatDTO> getCatById(@PathVariable("catId") UUID id) throws ResourceNotFoundException {
        CatDTO found = catService.getCatById(id);

        if (found != null) {
            return ResponseEntity.ok(found);
        } else {
            throw new ResourceNotFoundException();
        }


    }
}
