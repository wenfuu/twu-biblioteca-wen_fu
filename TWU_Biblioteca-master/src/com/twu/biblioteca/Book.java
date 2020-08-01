package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;

    public Book(){

    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toList(){
        StringBuilder result = new StringBuilder();
        result.append("Title: ").append(title).append(" Author: ").append(author).append(" Year Published: ").append(year);
        return result.toString();
    }
}
