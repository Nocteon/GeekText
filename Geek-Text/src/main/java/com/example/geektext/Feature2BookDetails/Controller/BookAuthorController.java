package com.example.geektext.Feature2BookDetails.Controller;

import com.example.geektext.Feature2BookDetails.Models.Author;
import com.example.geektext.Feature2BookDetails.Repo.AuthorRepo;
import com.example.geektext.Feature2BookDetails.Models.Book;
import com.example.geektext.Feature2BookDetails.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class BookAuthorController {
    //REST Setup
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping(value = "/") //EXPERIMENTAL TESTER PAGE, UNNECESSARY FOR FUNCTIONALITY
    public String testPage(){return "Welcome to my test page";}

    //Book Functionality & Methods
    @GetMapping(value = "/books") //EXPERIMENTAL FUNCTIONALITY
    public List<Book> getBooks() {return bookRepo.findAll();}
    @GetMapping(value="/books/{id}") //REQUIRED, MAINTAINED
    public Book getBook(@PathVariable String id){
        return bookRepo.findById(id).get();
    }
    @PostMapping(value = "/addListing") //REQUIRED, MAINTAINED
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Saved!";
    }
    @PutMapping(value="/update/{id}") //EXPERIMENTAL FUNCTIONALITY
    public String updateBook(@PathVariable String id,@RequestBody Book book){
        Book updatedBook = bookRepo.findById(id).get();
        updatedBook.setBookId(book.getBookId());
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
    @DeleteMapping(value = "/delete/{id}") //EXPERIMENTAL FUNCTIONALITY
    public String deleteBook(@PathVariable String id){
        Book deleteBook = bookRepo.findById(id).get();
        bookRepo.delete(deleteBook);
        return "Deleted book with id: " + id;
    }


    //Getting Author Listings
    @GetMapping(value = "/books/author/{id}") //REQUIRED, MAINTAINED
    public List<Book> authorListings(@PathVariable int id){
        List<Book> allBooks = bookRepo.findAll();
        ArrayList<Book> authorBooks = new ArrayList<Book>();
        for(Book i: allBooks)
            if(i.getAuthor().equals(getAuthor(id)))
                authorBooks.add(i);
        return authorBooks;
    }

    //Author Functionality & Methods
    @GetMapping(value = "/authors") //EXPERIMENTAL FUNCTIONALITY
    public List<Author> getAuthors() {return authorRepo.findAll();}
    @GetMapping(value = "/authors/{id}") //EXPERIMENTAL FUNCTIONALITY
    public Author getAuthor(@PathVariable int id) {return authorRepo.findById(id).get();}
    @PostMapping(value = "/addAuthor") //REQUIRED, MAINTAINED
    public String saveAuthor(@RequestBody Author author){
        authorRepo.save(author);
        return "Saved!";
    }

    @DeleteMapping(value = "/authors/delete/{id}") //EXPERIMENTAL FUNCTIONALITY
    public String deleteAuthor(@PathVariable int id){
        Author deleteAuthor = authorRepo.findById(id).get();
        try {
            authorRepo.delete(deleteAuthor);
        }
        catch (Exception e){
            return "Error: Likely, Author has dependencies that must be deleted first";
        }
        return "Deleted Author with id: " + id;
    }
}
