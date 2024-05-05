package com.azul.bookstore.services;

import com.azul.bookstore.model.Author;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    public ResponseEntity<?> create(Author author);
}
