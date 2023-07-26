
package com.geektext.app.rest.Controllers;

import com.geektext.app.rest.Models.Book;
import com.geektext.app.rest.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestParam Book book) {
        Long id;

        bookRepo.save(book);
        return "Book added successfully!";
    }
}
