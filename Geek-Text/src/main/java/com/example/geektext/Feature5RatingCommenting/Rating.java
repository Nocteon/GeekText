package com.geektext.app.rest.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Rating{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Long bookId;

    @Column
    private int ratingScale;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datestamp;

    public Rating() {

    }

    public Rating(Long userId, Long bookId, int ratingScale, Date datestamp) {
        this.userId = userId;
        this.bookId = bookId;
        this.ratingScale = ratingScale;
        this.datestamp = datestamp;
    }

    public Rating(int stars, Date date) {
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

    public int getRatingScale() {
        return ratingScale;
    }

    public void setRatingScale(int ratingScale) {
        this.ratingScale = ratingScale;
    }

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }
}
