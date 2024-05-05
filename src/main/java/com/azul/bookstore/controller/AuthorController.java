package com.azul.bookstore.controller;

import com.azul.bookstore.dto.AuthorDTO;
import com.azul.bookstore.model.Author;
import com.azul.bookstore.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private AuthorService authorService;
    private ModelMapper modelMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity addAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.create(modelMapper.map(authorDTO, Author.class));
    }
}
