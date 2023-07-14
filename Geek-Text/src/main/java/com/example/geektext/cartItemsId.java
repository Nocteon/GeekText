package com.GeekText.groupProject.model;

import java.io.Serializable;

public class cartItemsId implements Serializable {
    private String userId;
    private String bookId;
    public cartItemsId(String userId, String bookId) {
        this.bookId = bookId;
        this.userId = userId;
    }
}
