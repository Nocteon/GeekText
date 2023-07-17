package com.example.geektext;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
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