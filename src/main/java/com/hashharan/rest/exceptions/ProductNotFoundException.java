package com.hashharan.rest.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Could not find Product with id: " + id);
    }
}
