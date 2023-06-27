package com.example.geektext.rest.Controller;

import com.example.geektext.rest.Models.*;
import com.example.geektext.rest.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping(value = "/")
    public String testPage(){return "Welcome to my test page";}

    @GetMapping(value = "/books")
    public List<Book> getBooks() {return bookRepo.findAll();}
/* INCOMPLETE
    @GetMapping(value = "/authors/{id}")
    public List<Author> getAuthor() {return authorRepo.findAll();}
*/
    @GetMapping(value="/books/{id}")
    public Book getBook(@PathVariable long id){
        return bookRepo.findById(id).get();
    }

    @PostMapping(value = "/addListing")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Saved!";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody Book book){
        Book updatedBook = bookRepo.findById(id).get();
        updatedBook.setBookName(book.getBookName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setGenre(book.getGenre());
        updatedBook.setISBN(book.getISBN());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setPublisher(book.getPublisher());
        updatedBook.setYear(book.getYear());
        updatedBook.setSold(book.getSold());
        bookRepo.save(updatedBook);
        return "Updated!";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        Book deleteUser = bookRepo.findById(id).get();
        bookRepo.delete(deleteUser);
        return "Deleted book with id: " + id;
    }

}
