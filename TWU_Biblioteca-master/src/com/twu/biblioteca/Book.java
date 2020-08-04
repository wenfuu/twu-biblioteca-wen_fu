package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;
    private boolean availability;
    private String ISBN;
    private String borrower;

    public Book(String title, String author, int year, String ISBN) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availability  = true;
        this.ISBN = ISBN;
        this.borrower = null;
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

    public String getISBN() {
        return ISBN;
    }

    public void checkout(String user) {
        this.availability = false;
        this.borrower = user;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void returnBook() { this.availability = true;
    }

    public String getBorrower() {
        return this.borrower;
    }
}
