package com.geektext.app.rest.Models;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    public Book() {
        // Default constructor, no need to set the bookId here.
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
