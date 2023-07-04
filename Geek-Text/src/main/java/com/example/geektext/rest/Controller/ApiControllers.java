package com.example.geektext.rest.Controller;

import com.example.geektext.rest.Models.*;
import com.example.geektext.rest.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ApiControllers {
    //REST Setup
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping(value = "/") //TESTER PAGE, UNNECESSARY FOR FUNCTIONALITY
    public String testPage(){return "Welcome to my test page";}

    //Book Functionality & Methods
    @GetMapping(value = "/books") //ADDITIONAL FUNCTIONALITY
    public List<Book> getBooks() {return bookRepo.findAll();}
    @GetMapping(value="/books/{id}") //REQUIRED
    public Book getBook(@PathVariable long id){
        return bookRepo.findById(id).get();
    }
    @PostMapping(value = "/addListing") //REQUIRED
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Saved!";
    }
    @PutMapping(value="/update/{id}") //ADDITIONAL FUNCTIONALITY
    public String updateBook(@PathVariable long id,@RequestBody Book book){
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
    @DeleteMapping(value = "/delete/{id}") //ADDITIONAL FUNCTIONALITY
    public String deleteBook(@PathVariable long id){
        Book deleteBook = bookRepo.findById(id).get();
        bookRepo.delete(deleteBook);
        return "Deleted book with id: " + id;
    }


    //Getting Author Listings
    @GetMapping(value = "/books/author/{id}") //REQUIRED
    public List<Book> authorListings(@PathVariable int id){
        List<Book> allBooks = bookRepo.findAll();
        ArrayList<Book> authorBooks = new ArrayList<Book>();
        for(Book i: allBooks)
            if(i.getAuthor().equals(getAuthor(id)))
                authorBooks.add(i);
        return authorBooks;
    }

    //Author Functionality & Methods
    @GetMapping(value = "/authors") //ADDITIONAL FUNCTIONALITY
    public List<Author> getAuthors() {return authorRepo.findAll();}
    @GetMapping(value = "/authors/{id}") //ADDITIONAL FUNCTIONALITY
    public Author getAuthor(@PathVariable long id) {return authorRepo.findById(id).get();}
    @PostMapping(value = "/addAuthor") //REQUIRED
    public String saveAuthor(@RequestBody Author author){
        authorRepo.save(author);
        return "Saved!";
    }

    @DeleteMapping(value = "/authors/delete/{id}") //ADDITIONAL FUNCTIONALITY
    public String deleteAuthor(@PathVariable long id){
        Author deleteAuthor = authorRepo.findById(id).get();
        authorRepo.delete(deleteAuthor);
        return "Deleted Author with id: " + id;
    }
}
