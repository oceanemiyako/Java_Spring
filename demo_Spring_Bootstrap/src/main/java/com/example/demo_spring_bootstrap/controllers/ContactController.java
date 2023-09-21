package com.example.demo_spring_bootstrap.controllers;


import com.example.demo_spring_bootstrap.exception.ResourceNotFound;
import com.example.demo_spring_bootstrap.models.ContactDTO;
import com.example.demo_spring_bootstrap.services.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Slf4j
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public String listContacts(Model model, @RequestParam(value = "name", defaultValue = "") String filterByName) {
        List<ContactDTO> contacts = contactService.getContacts();

        if (!filterByName.isEmpty() && !filterByName.isBlank()) {
            contacts = contacts.stream().filter(d -> d.getLastname().startsWith(filterByName)).toList();
        }

        model.addAttribute("contacts", contacts);

        return "contacts/list";
    }

    @GetMapping("/{contactId}")
    public String getcontactDetails(@PathVariable("contactId") UUID id, Model model) {
        Optional<ContactDTO> foundContact = contactService.getContactsById(id);

        if (foundContact.isPresent()) {
            model.addAttribute("contact", foundContact.get());
            model.addAttribute("mode", "details");

            return "contacts/contactForm";
        }

        throw new ResourceNotFound();
    }

    @GetMapping("/add")
    public String getContactForm(Model model, @RequestParam(value = "exemple", defaultValue = "default") String blabla) {
        log.debug("blabla: " + blabla);

        model.addAttribute("contact", ContactDTO.builder().build());
        model.addAttribute("mode", "add");

        return "contacts/contactForm";
    }

    @PostMapping("/add")
    public String addContactHandler(ContactDTO newContact) {
        contactService.addContact(newContact);

        return "redirect:/contacts";
    }

    @PostMapping("/delete")
    public String deleteContactById(@PathVariable("contactId") UUID id) {

        contactService.deleteContactById(id);

        return "redirect:/contacts";
    }

    @PostMapping("/edit")
    public String updateContact(@PathVariable("contactId") UUID id, @ModelAttribute("contact") ContactDTO contact) {
        contactService.editContact(updateContact(id));
        return "redirect:/contacts/";
    }

}
