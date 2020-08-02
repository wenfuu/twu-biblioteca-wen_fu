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

    public void OptionResponse() {
        System.out.println(MenuOptions());
        int option = GetOption();
        if (option == 1){
            Book book = new Book();
            System.out.println(book.toList());
        } else if (option == 2) {
            System.exit(0);
        } else {
            OptionResponse();
        }
    }
}
