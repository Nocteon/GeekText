package com.example.geektext.Feature6Wishlist.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "WishlistBook")
public class Book {
    @Id
    private String bookId;

    // Getters and Setters

    // Get the book ID
    public String getBookId() {
        return bookId;
    }

    // Set the book ID
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}