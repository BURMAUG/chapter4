package com.polarbookshop.servicecatalog.exceptions;


public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException(String isbn) {
        super("A book with ISBN " + isbn + " already exists.");
    }
}

