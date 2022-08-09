package com.polarbookshop.servicecatalog.service;




import com.polarbookshop.servicecatalog.domain.Book;
import com.polarbookshop.servicecatalog.exceptions.BookAlreadyExistException;
import com.polarbookshop.servicecatalog.exceptions.BookNotFoundException;
import com.polarbookshop.servicecatalog.persistance.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetail(String isbn) throws BookNotFoundException {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) throws BookAlreadyExistException {
        if (bookRepository.existByIsbn(book.isbn()))
            throw new BookAlreadyExistException(book.isbn());
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBook(String isbn, Book book) {
        return bookRepository.findByIsbn(isbn).map(
                existingBooks -> {
                    var bookToUpdate = new Book(existingBooks.isbn(), book.title(), book.author(), book.price());
                    return bookRepository.save(bookToUpdate);
                }).orElseGet(() -> {
            try {
                return addBookToCatalog(book);
            } catch (BookAlreadyExistException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
