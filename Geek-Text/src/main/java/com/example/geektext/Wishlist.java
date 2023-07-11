package com.example.geektext;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String title;

    @ElementCollection
    @CollectionTable(name = "wishlist_books", joinColumns = @JoinColumn(name = "wishlist_id"))
    @Column(name = "book")
    private List<String> books;

    public Wishlist() {
        this.books = new ArrayList<>();
    }

    public Wishlist(String user, String title) {
        this.user = user;
        this.title = title;
        this.books = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getBooks() {
        return books;
    }

    public void addBook(String newBook) {
        this.books.add(newBook);
    }

    public void removeBook(String book) {
        this.books.remove(book);
    }

}
