package com.twu.biblioteca;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleOutput {

    BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String menuOptions() {
        return "Menu: 1.List of books 2.Checkout a book 3.Exit";
    }

    public int getOption() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void optionResponse() {
        System.out.println(menuOptions());
        int option = getOption();
        if (option == 1){
            System.out.println(bookrepo.toList());
            optionResponse();
        } else if (option == 2) {
            System.out.println("Please enter the ISBN of the book you want to checkout.");
            String ISBN = getInput();
            for (Book book : bookrepo.getBookList()){
                if (book.getISBN().equals(ISBN)){
                    book.checkout();
                }
            }
            optionResponse();
        } else if (option == 3) {
            System.exit(0);
        } else {
            System.out.println("Please select a valid option!");
            optionResponse();
        }
    }
}
