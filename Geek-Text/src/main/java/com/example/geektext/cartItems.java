package com.GeekText.groupProject.model;

import jakarta.persistence.*;

@Entity
@IdClass(cartItemsId.class)
public class cartItems {
    @Id
    private String userId;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }
    @Id
    private String bookId;

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId(){
        return bookId;
    }
}
