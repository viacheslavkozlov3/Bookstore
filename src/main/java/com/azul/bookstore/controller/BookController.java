package com.azul.bookstore.controller;

import com.azul.bookstore.dto.BookDTO;
import com.azul.bookstore.model.Book;
import com.azul.bookstore.services.BookstoreService;
import com.azul.bookstore.specification.BooksWithAuthor;
import com.azul.bookstore.specification.BooksWithGenre;
import com.azul.bookstore.specification.BooksWithTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.modelmapper.ModelMapper;

@RestController
public class BookController {

    private BookstoreService bookstoreService;
    private ModelMapper modelMapper;

    @Autowired
    public BookController(BookstoreService bookstoreService, ModelMapper modelMapper) {
        this.bookstoreService = bookstoreService;
        this.modelMapper = modelMapper;
    }

    final int size = 3;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Page<Book> getBooks(@RequestParam(value = "title", required = false, defaultValue = "") String title,
                               @RequestParam(value = "author", required = false, defaultValue = "") String author,
                               @RequestParam(value = "genre", required = false, defaultValue = "") String genre,
                               @RequestParam(defaultValue = "0") int page) {
        Specification<Book> spec = Specification.where(new BooksWithTitle(title)).and(new BooksWithAuthor(author)).and(new BooksWithGenre(genre));
        return bookstoreService.getAll(spec, PageRequest.of(page, size));
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody BookDTO bookDTO) {
        return bookstoreService.create(modelMapper.map(bookDTO, Book.class));
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public ResponseEntity updateBook(@RequestBody BookDTO bookDTO) {
        return bookstoreService.update(modelMapper.map(bookDTO, Book.class));
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookstoreService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
