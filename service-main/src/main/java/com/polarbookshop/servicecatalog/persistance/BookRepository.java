package com.polarbookshop.servicecatalog.persistance;

import com.polarbookshop.servicecatalog.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface BookRepository {

    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existByIsbn(String isbn);

    Book save(Book book);

    void deleteByIsbn(String isbn);
}
