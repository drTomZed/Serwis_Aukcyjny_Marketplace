package com.projekt_koncowy.serwis_aukcyjny_marketplace.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super("Client creation failed: " + s);
    }
}
