package com.jairhdev.apicontact.controller;

import com.jairhdev.apicontact.model.entities.Contact;
import com.jairhdev.apicontact.model.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/contacts")
public class ContactController {

    private final ContactService service;

    ContactController(ContactService service) {
        this.service = service;
    }

    // *****************************

    @PostMapping
    public ResponseEntity<Contact> save(@RequestBody Contact contact) {
        contact = service.save(contact);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contact.getId()).toUri();
        return ResponseEntity.created(uri).body(contact);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Contact> updateById(@PathVariable Long id, @RequestBody Contact contact) {
        return ResponseEntity.ok().body(service.updateById(id, contact));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
