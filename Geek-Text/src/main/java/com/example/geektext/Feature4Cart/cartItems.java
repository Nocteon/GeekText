package com.GeekText.groupProject.model;

import jakarta.persistence.*;

@Entity
@IdClass(cartItemsId.class)
public class cartItems {
    @Id
    private String userId;
    private double subtotal;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }
    @Id
    private Long bookId;

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId(){
        return bookId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private double price;

    private int quantity;

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
