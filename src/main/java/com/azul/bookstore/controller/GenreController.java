package com.azul.bookstore.controller;

import com.azul.bookstore.dto.GenreDTO;
import com.azul.bookstore.model.Genre;
import com.azul.bookstore.services.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    private GenreService genreService;
    private ModelMapper modelMapper;

    @Autowired
    public GenreController(GenreService genreService, ModelMapper modelMapper) {
        this.genreService = genreService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/genres", method = RequestMethod.POST)
    public ResponseEntity addGenre(@RequestBody GenreDTO genreDTO) {
        return genreService.create(modelMapper.map(genreDTO, Genre.class));
    }
}
