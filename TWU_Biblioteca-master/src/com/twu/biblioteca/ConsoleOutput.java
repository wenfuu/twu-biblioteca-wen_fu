package com.twu.biblioteca;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleOutput {

    BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));
    MovieRepo movieRepo = new MovieRepo(new Movie("Name", 2014, "Director", "8.6", "tt0816692"), new Movie("Name2", 1997, "Director2", "Unrated", "tt0120338"));

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String menuOptions() {
        return "Menu: 1.List of books 2.Checkout a book 3.Return a book 4.List of movies 5.Checkout a movie 6.Exit";
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
            boolean ifFind = false;
            for (Book book : bookrepo.getBookList()){
                if (book.getISBN().equals(ISBN)){
                    book.checkout();
                    ifFind = true;
                    System.out.println("Thank you! Enjoy the book.");
                }
            }
            if (!ifFind){
                System.out.println("Sorry, that book is not available.");
            }
            optionResponse();
        } else if (option == 3) {
            System.out.println("Please enter the ISBN of the book you want to return.");
            String ISBN = getInput();
            boolean ifFind = false;
            for (Book book : bookrepo.getBookList()){
                if (book.getISBN().equals(ISBN)){
                    book.returnBook();
                    ifFind = true;
                    System.out.println("Thank you for returning the book.");
                }
            }
            if (!ifFind){
                System.out.println("That is not a valid book to return.");
            }
            optionResponse();
        } else if (option == 4){
            System.out.println(movieRepo.toList());
            optionResponse();
        } else if (option == 5) {
            System.out.println("Please enter the IMDb Code of the movie you want to checkout.");
            String imdbCode = getInput();
            boolean ifFind = false;
            for (Movie movie : movieRepo.getMovieList()){
                if (movie.getImdbCode().equals(imdbCode)){
                    movie.checkout();
                    ifFind = true;
                    System.out.println("Thank you! Enjoy the movie.");
                }
            }
            if (!ifFind){
                System.out.println("Sorry, that movie is not available.");
            }
            optionResponse();
        } else if (option == 6) {
            System.exit(0);
        } else {
            System.out.println("Please select a valid option!");
            optionResponse();
        }
    }
}
