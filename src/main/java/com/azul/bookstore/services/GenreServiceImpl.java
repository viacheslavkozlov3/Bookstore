package com.azul.bookstore.services;

import com.azul.bookstore.model.Genre;
import com.azul.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public ResponseEntity<?> create(Genre genre) {
        genreRepository.save(genre);
        return new ResponseEntity<>(genre, HttpStatus.CREATED);
    }
}
