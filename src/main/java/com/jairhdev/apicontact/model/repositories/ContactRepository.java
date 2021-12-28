package com.jairhdev.apicontact.model.repositories;

import com.jairhdev.apicontact.model.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
