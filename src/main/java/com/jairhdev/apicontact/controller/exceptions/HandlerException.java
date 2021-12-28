package com.jairhdev.apicontact.controller.exceptions;

import com.jairhdev.apicontact.model.services.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class HandlerException {

    private final DateTimeFormatter dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest request) {

        final String ERROR = "Not found.";
        final HttpStatus STATUS = HttpStatus.NOT_FOUND;
        ZonedDateTime ts = ZonedDateTime.now(ZoneOffset.UTC);

        return ResponseEntity.status(STATUS).body(
                new StandardError(STATUS.value(), ERROR, e.getMessage(), request.getRequestURI(), ts));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> jsonInvalidException(HttpMessageNotReadableException e, HttpServletRequest request) {

        final String ERROR = "Invalid body.";
        final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
        ZonedDateTime ts = ZonedDateTime.now(ZoneOffset.UTC);

        return ResponseEntity.status(STATUS).body(
                new StandardError(STATUS.value(), ERROR, e.getMessage(), request.getRequestURI(), ts));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> methodInvalidException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {

        final String ERROR = "Invalid path, body or method.";
        final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
        ZonedDateTime ts = ZonedDateTime.now(ZoneOffset.UTC);

        return ResponseEntity.status(STATUS).body(
                new StandardError(STATUS.value(), ERROR, e.getMessage(), request.getRequestURI(), ts));
    }
}
