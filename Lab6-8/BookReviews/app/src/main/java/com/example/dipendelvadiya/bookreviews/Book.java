package com.example.dipendelvadiya.bookreviews;

/**
 * Created by dipendelvadiya on 4/25/17.
 */

public class Book {

    private String rating;
    private int id;
    private String title;
    private String author;

    public Book(){}

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }
    //getters & setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() {  return author;  }
    public void setAuthor(String author) { this.author = author;}
    public void setRating(String rating) { this.rating = rating; }
    public String getRating() { return rating; }


    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author
                + ", rating=" + rating + "]";
    }

}
