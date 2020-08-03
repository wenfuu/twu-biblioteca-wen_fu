package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleOutput {

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String menuOptions() {
        return "Menu: 1.List of books 2.Exit";
    }

    public int getOption() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void optionResponse() {
        System.out.println(menuOptions());
        int option = getOption();
        if (option == 1){
            BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874), new Book("Title2", "Author2", 1874));
            System.out.println(bookrepo.toList());
        } else if (option == 2) {
            System.exit(0);
        } else {
            optionResponse();
        }
    }
}
