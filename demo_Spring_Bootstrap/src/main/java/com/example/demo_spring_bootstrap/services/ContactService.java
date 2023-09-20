package com.example.demo_spring_bootstrap.services;

import com.example.demo_spring_bootstrap.models.ContactDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class ContactService {

    private final Map<UUID, ContactDTO> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();

        ContactDTO contactA = ContactDTO.builder()
                .id(UUID.randomUUID())
                .lastname("Garcia")
                .firstname("Oceane")
                .email("oceane@email.fr")
                .phone("123456789")
                .build();

        ContactDTO contactB = ContactDTO.builder()
                .id(UUID.randomUUID())
                .lastname("Boutillier")
                .firstname("Aurelie")
                .email("aurelie@email.fr")
                .phone("987456123")
                .build();

        ContactDTO contactC = ContactDTO.builder()
                .id(UUID.randomUUID())
                .lastname("Break")
                .firstname("Bastien")
                .email("bastien@email.fr")
                .phone("789456235")
                .build();

        contacts.put(contactA.getId(), contactA);
        contacts.put(contactB.getId(), contactB);
        contacts.put(contactC.getId(), contactC);

    }

    public  List<ContactDTO> getContacts() {
        return contacts.values().stream().toList();
    }

    public Optional<ContactDTO> getContactsById(UUID id) {
        return contacts.values().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public ContactDTO addContact(ContactDTO contactData) {
        if (contactData.getId() == null) {
            contactData.setId(UUID.randomUUID());
        }

        contacts.put(contactData.getId(), contactData);

        return contactData;
    }

}
