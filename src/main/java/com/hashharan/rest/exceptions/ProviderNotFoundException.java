package com.hashharan.rest.exceptions;

public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(Long id) {
        super("Could not find provider with id: " + id);
    }
}
