package com.example.demo_spring_bootstrap.controllers;


import com.example.demo_spring_bootstrap.exception.ResourceNotFound;
import com.example.demo_spring_bootstrap.models.ContactDTO;
import com.example.demo_spring_bootstrap.services.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
@Slf4j
public class ContactRestController {

    private final ContactService contactService;

    @GetMapping
    public List<ContactDTO> listContacts(@RequestParam(value = "name", defaultValue = "") String filterByName){
        List<ContactDTO> contacts = contactService.getContacts();

        log.debug("GET to /contacts/list");

        if (!filterByName.isEmpty() && !filterByName.isBlank()) {
            contacts = contacts.stream().filter(d -> d.getLastname().startsWith(filterByName)).toList();
        }

        return contacts;
    }

    @GetMapping("/{contactId}")
    public ContactDTO getDetails (@PathVariable("contactId") UUID id){
        Optional<ContactDTO> foundContact = contactService.getContactsById(id);

        if (foundContact.isPresent()) {
            return foundContact.get();
        }

        throw new ResourceNotFound();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContactHandler(@RequestBody ContactDTO newContact) {
        ContactDTO createdContact = contactService.addContact(newContact);

        return new ResponseEntity<String>("Contact created! New id: " + createdContact.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContactHandler(@PathVariable("contactId") UUID id) {
        Optional<ContactDTO> foundContact = contactService.getContactsById(id);

        if (foundContact.isPresent()) {

            if(contactService.deleteContactById(id)) {
                return new ResponseEntity<String>("Contact deleted at id: " + id, HttpStatus.OK);
            }

            return new ResponseEntity<String>("Something went wrong...", HttpStatus.NOT_MODIFIED);

        } else {
            throw new ResourceNotFound();
        }
    }

    @PatchMapping("/{contactId}")
    public ContactDTO editContact(@PathVariable("contactId") UUID id, @RequestBody ContactDTO contactData) {
        Optional<ContactDTO> foundContact = contactService.getContactsById(id);

        if (foundContact.isPresent()) {
            return contactService.editContact(id, contactData);
        } else {
            throw new ResourceNotFound();
        }
    }
}
