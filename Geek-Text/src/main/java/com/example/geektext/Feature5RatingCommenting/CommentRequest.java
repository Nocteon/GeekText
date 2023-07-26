package com.geektext.app.rest.Requests;

public class CommentRequest {

    private String comment;
    private Long userId;
    private Long bookId;

    // Constructors, getters, and setters

    // Constructors
    public CommentRequest() {
        // Default constructor
    }

    public CommentRequest(String comment, Long userId, Long bookId) {
        this.comment = comment;
        this.userId = userId;
        this.bookId = bookId;
    }

    // Getters and setters
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
