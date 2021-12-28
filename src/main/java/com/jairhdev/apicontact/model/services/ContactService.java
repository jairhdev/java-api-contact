package com.jairhdev.apicontact.model.services;

import com.jairhdev.apicontact.model.entities.Contact;
import com.jairhdev.apicontact.model.repositories.ContactRepository;
import com.jairhdev.apicontact.model.services.exceptions.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repository;

    ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    // *****************************

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Contact updateById(Long id, Contact contact) {
        return repository.findById(id)
                .map(data -> {
                    updateData(data, contact);
                    return repository.save(data);
                }).orElseThrow(() -> new NotFoundException(id));
    }

    private void updateData(Contact contactFind, Contact contact) {
        contactFind.setName(contact.getName());
        contactFind.setNickname(contact.getNickname());
        contactFind.setNotes(contact.getNotes());
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(id);
        }
    }
}
