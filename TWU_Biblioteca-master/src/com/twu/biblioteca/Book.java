package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;
    private boolean availability ;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availability  = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void checkout() {
        this.availability = false;
    }

    public boolean getAvaliability() {
        return availability;
    }
}
