package com.azul.bookstore.specification;

import com.azul.bookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BooksWithGenre implements Specification<Book> {
    private String genre;

    public BooksWithGenre(String genre) {
        super();
        this.genre = genre;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (genre.equals("undefined") || genre.equals("")) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
        return criteriaBuilder.equal(root.get("genre").get("name"), genre);
    }
}
