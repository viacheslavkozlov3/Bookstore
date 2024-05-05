package com.azul.bookstore.services;

import com.azul.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

public interface BookstoreService {
    public Page<Book> getAll(Specification<Book> spec, Pageable page);

    public ResponseEntity<?> create(Book book);

    public ResponseEntity<?> update(Book book);

    public void delete(Long id);
}
