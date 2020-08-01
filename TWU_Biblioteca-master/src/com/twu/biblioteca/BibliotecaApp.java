package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.WelcomeMessage());
        System.out.println("Menu: 1.List of books 2.Exit");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        app.menu(option);
    }

    public String WelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void menu(int option) {
        switch(option) {
            case 1: {Book book = new Book();
                System.out.println(book.toList());break;}
            case 2 : {
                System.exit(0);
            }
            default :{
                System.out.println("Please select a valid option!");
                break;
            }
        }
    }
}