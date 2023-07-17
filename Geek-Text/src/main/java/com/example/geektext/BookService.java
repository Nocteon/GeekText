package com.example.geektext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add a book to the repository
    public Book addBook(String bookId) {
        Book book = new Book();
        book.setBookId(bookId);
        return bookRepository.save(book);
    }
}

