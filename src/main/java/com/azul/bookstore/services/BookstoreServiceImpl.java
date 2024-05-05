package com.azul.bookstore.services;

import com.azul.bookstore.model.Book;

import com.azul.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookstoreServiceImpl implements BookstoreService {

    private BookRepository bookRepository;

    @Autowired
    public BookstoreServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> getAll(Specification<Book> spec, Pageable page) {
        return bookRepository.findAll(spec, page);
    }

    @Override
    public ResponseEntity<?> create(Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
