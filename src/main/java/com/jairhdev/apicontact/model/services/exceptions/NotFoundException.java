package com.jairhdev.apicontact.model.services.exceptions;

public class NotFoundException extends RuntimeException {

    public <T> NotFoundException(T id) {
        super("Not found. Id: " + id);
    }
}
