package com.twu.biblioteca;

public class Book {

    private String title;

    public Book(){

    }

    public Book(String title) {
        this.title = title;
    }

    public String toList(){
        return title;
    }
}
