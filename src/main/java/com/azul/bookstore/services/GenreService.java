package com.azul.bookstore.services;

import com.azul.bookstore.model.Genre;
import org.springframework.http.ResponseEntity;

public interface GenreService {
    public ResponseEntity<?> create(Genre genre);
}
