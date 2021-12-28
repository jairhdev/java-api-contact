package com.jairhdev.apicontact.controller.exceptions;

import java.time.ZonedDateTime;

class StandardError {

    private int status;
    private String error;
    private String message;
    private String path;
    private ZonedDateTime timeStamp;

    StandardError() {
    }

    StandardError(int status, String error, String message, String path, ZonedDateTime timeStamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
