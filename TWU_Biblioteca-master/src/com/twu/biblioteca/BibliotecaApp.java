package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.WelcomeMessage());
        Book book = new Book();
        System.out.println(book.toList());
    }

    public String WelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}