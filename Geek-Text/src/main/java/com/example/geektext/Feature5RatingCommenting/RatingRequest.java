package com.geektext.app.rest.Requests;

public class RatingRequest {
    private int stars;
    private Long userId;
    private Long bookId;

    // Constructors, getters, and setters

    // Constructors
    public RatingRequest() {
        // Default constructor
    }

    public RatingRequest(int stars, Long userId, Long bookId) {
        this.stars = stars;
        this.userId = userId;
        this.bookId = bookId;
    }

    // Getters and setters
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
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
