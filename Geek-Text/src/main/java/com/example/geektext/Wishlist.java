package com.example.geektext;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Wishlist {
    @Id
    private String wishlistId;


    @Column(name = "user_id")
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id")
    private List<Book> books;


    // Getters and Setters

    // Get the wishlist ID
    public String getWishlistId() {
        return wishlistId;
    }

    // Set the wishlist ID
    public void setWishlistId(String wishlistId) {
        this.wishlistId = wishlistId;
    }

    // Get the user ID associated with the wishlist
    public Long getUserId() {
        return userId;
    }

    // Set the user ID associated with the wishlist
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Get the books in the wishlist
    public List<Book> getBooks() {
        return books;
    }

    // Set the books in the wishlist
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

