package com.example.geektext.rest.Models;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    private long ISBN;

    @Column
    private String bookName;

    @Column
    private String description;

    @Column
    private String genre;

    @Column
    private float price;

    @JoinColumn
    @ManyToOne
    private Author author;

    @Column
    private String publisher;

    @Column
    private int year;

    @Column
    private int sold;

    /*public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }
    */
    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
