package com.polarbookshop.servicecatalog.controller;

import com.polarbookshop.servicecatalog.domain.Book;
import com.polarbookshop.servicecatalog.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> findBooks(){
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book findBooksByIsbn(@PathVariable String isbn){
        return bookService.viewBookDetail(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book){
        return bookService.addBookToCatalog(book);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn){
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public Book update(@PathVariable String isbn,@Valid @RequestBody Book book){
        return  bookService.editBook(isbn,book);
    }
}
