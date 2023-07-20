package com.example.geektext.Feature6Wishlist.Models;

import com.example.geektext.Feature6Wishlist.Models.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id")
    private List<Book> wishlist;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Book> cart;

    // Getters and Setters

    // Get the user ID
    public Long getId() {
        return id;
    }

    // Set the user ID
    public void setId(Long id) {
        this.id = id;
    }

    // Get the user's wishlist
    public List<Book> getWishlist() {
        return wishlist;
    }

    // Set the user's wishlist
    public void setWishlist(List<Book> wishlist) {
        this.wishlist = wishlist;
    }

    // Get the user's cart
    public List<Book> getCart() {
        return cart;
    }

    // Set the user's cart
    public void setCart(List<Book> cart) {
        this.cart = cart;
    }
}

