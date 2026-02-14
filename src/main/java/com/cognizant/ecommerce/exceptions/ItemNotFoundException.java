package com.cognizant.ecommerce.exceptions;

import java.io.Serializable;

public class ItemNotFoundException extends RuntimeException implements Serializable{

    public ItemNotFoundException(Long id) {
        super("Item not found with id: " + id);
    }
}