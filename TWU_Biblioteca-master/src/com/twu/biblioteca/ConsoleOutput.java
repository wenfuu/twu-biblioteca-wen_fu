package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleOutput {

    public String WelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String MenuOptions() {
        return "Menu: 1.List of books 2.Exit";
    }

    public int GetOption() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String OptionResponse() {
        int option = GetOption();
        switch(option) {
            case 1: {Book book = new Book();
                return book.toList();}
            case 2 : {
                System.exit(0);
            }
            default :{
                return "Please select a valid option!";
            }
        }
    }
}
