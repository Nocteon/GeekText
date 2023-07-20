package com.example.geektext.Feature1BookBrowsing;

public class GeekText
{
    private String bookId;
    private String bookPublisher;
    private String bookGenre;
    private String bookRank;
    private String bookRate;

    public GeekText() {
    }

    public GeekText(String bookId, String bookPublisher, String bookGenre, String bookRank, String bookRate) {
        this.bookId = bookId;
        this.bookPublisher = bookPublisher;
        this.bookGenre = bookGenre;
        this.bookRank = bookRank;
        this.bookRate = bookRate;
    }


    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getBookPublisher() {
        return bookPublisher;
    }
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
    public String getBookGenre() {
        return bookGenre;
    }
    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
    public String getBookRank() {
        return bookRank;
    }
    public void setBookRank(String bookRank) {
        this.bookRank = bookRank;
    }
    public String getBookRate() {
        return bookRate;
    }
    public void setBookRate(String bookRate) {
        this.bookRate = bookRate;
    }
}
