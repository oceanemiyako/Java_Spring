package com.example.exo_security2.services;

import com.example.exo_security2.models.DogDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class DogService {


    private final Map<UUID, DogDTO> dogs;

    public DogService() {
      this.dogs = new HashMap<>();
        DogDTO dogA = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Etoile")
                .breed("Labrador")
                .age(4)
                .build();

        DogDTO dogB = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Yuki")
                .breed("Berger Allemand")
                .age(12)
                .build();

        DogDTO dogC = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Neige")
                .breed("Samoyed")
                .age(1)
                .build();

        dogs.put(dogA.getId(), dogA);
        dogs.put(dogB.getId(), dogB);
        dogs.put(dogC.getId(), dogC);
    }

    public List<DogDTO> getDogs() {
        return dogs.values().stream().toList();
    }

    public Optional<DogDTO> getDogById(UUID id) {
        return dogs.values().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public DogDTO addDog(DogDTO dogData) {
        if (dogData.getId() == null) {
            dogData.setId(UUID.randomUUID());
        }

        dogs.put(dogData.getId(), dogData);

        return dogData;
    }

    public Boolean deleteDogById(UUID id) {
        Optional<DogDTO> foundDog = getDogById(id);

        if (foundDog.isPresent()){
            dogs.remove(foundDog.get().getId());

            return true;
        }

        return false;
    }

}
