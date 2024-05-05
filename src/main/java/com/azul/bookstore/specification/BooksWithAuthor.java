package com.azul.bookstore.specification;

import com.azul.bookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BooksWithAuthor implements Specification<Book> {
    private String author;

    public BooksWithAuthor(String author) {
        super();
        this.author = author;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (author.equals("undefined") || author.equals("")) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
        return criteriaBuilder.equal(root.get("author").get("name"), author);
    }
}
