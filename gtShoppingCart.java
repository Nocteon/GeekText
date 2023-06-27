package com.geektext.demo.model;

public class gtShoppingCart {
    private String bookId;
    private String userId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public gtShoppingCart(String userId, String bookId) {
        this.bookId = bookId;
        this.userId = userId;
    }



}


