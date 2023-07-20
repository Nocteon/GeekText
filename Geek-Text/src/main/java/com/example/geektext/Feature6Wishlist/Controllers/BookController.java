package com.example.geektext.Feature6Wishlist.Controllers;

import com.example.geektext.Feature6Wishlist.Models.Book;
import com.example.geektext.Feature6Wishlist.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add a book to the book table
    @PostMapping
    public Book addBook(@RequestParam String bookId) {
        return bookService.addBook(bookId);
    }
}

