package com.azul.bookstore.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.azul.bookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;

public class BooksWithTitle implements Specification<Book> {
    private String title;

    public BooksWithTitle(String title) {
        super();
        this.title = title;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (title.equals("undefined") || title.equals("")) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
        return criteriaBuilder.like(root.get("title"), this.title);
    }
}
