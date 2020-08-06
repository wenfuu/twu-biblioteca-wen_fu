package com.twu.biblioteca;
import	java.util.HashMap;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Optional;
import	java.util.stream.Collectors;

import java.util.Scanner;

public class ConsoleOutput {

    BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));
    MovieRepo movieRepo = new MovieRepo(new Movie("Name", 2014, "Director", "8.6", "tt0816692"), new Movie("Name2", 1997, "Director2", "Unrated", "tt0120338"));
    UserRepo userRepo = new UserRepo(new User("111-2222", "password", "name", "email@a.com", "1113333"), new User("333-4444", "password2", "name2", "email2@b.com", "3335555"));

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String menuOptions() {
        return "Menu: 1.List of books 2.Checkout a book 3.Return a book 4.List of movies 5.Checkout a movie 6.View my information 7.Exit";
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public enum Command{
        bookList("1"),
        checkoutBook("2"),
        returnBook("3"),
        movieList("4"),
        checkoutMovie("5"),
        viewInfo("6"),
        exit("7");
        private String commandStr;
        Command(String commandStr) {
            this.commandStr = commandStr;
        }
        private static final Map<String, Command> stringToCommand = new HashMap<String, Command> ();
        static {
            for(Command command : values()){
                stringToCommand.put(command.toString(), command);
            }
        }
        public static Command fromString(String commandStr){
            return stringToCommand.get(commandStr);
        }
        @Override
        public String toString(){
            return this.commandStr;
        }
    }

    public void optionResponse() {
        System.out.println(menuOptions());;
        switch (Command.fromString(getInput())) {
            case bookList:
                bookList();
                break;
            case checkoutBook: {
                checkoutBook();
                break;
            }
            case returnBook: {
                returnBook();
                break;
            }
            case movieList:
                movieList();
                break;
            case checkoutMovie:
                checkoutMovie();
                break;
            case viewInfo:
                viewInfo();
                break;
            case exit:
                exit();
            default:
                validOption();
                break;
        }
    }

    public void bookList(){
        System.out.println(bookrepo.toList());
        optionResponse();
    }

    public void checkoutBook(){
        System.out.println("Please enter the ISBN of the book you want to checkout.");
        Optional<Book> Book = bookrepo.findABook(getInput());
        if (Book.isPresent()) {
            Book.get().checkout(login());
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, that book is not available.");
        }
        optionResponse();
    }

    public void returnBook(){
        System.out.println("Please enter the ISBN of the book you want to return.");
        Optional<Book> Book = bookrepo.findABook(getInput());
        if (Book.isPresent()) {
            Book.get().checkout(login());
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
        optionResponse();
    }

    public void movieList(){
        System.out.println(movieRepo.toList());
        optionResponse();
    }

    public void checkoutMovie(){
        System.out.println("Please enter the IMDb Code of the movie you want to checkout.");
        Optional<Movie> Movie = movieRepo.findAMovie(getInput());
        if (Movie.isPresent()) {
            Movie.get().checkout();
            System.out.println("Thank you! Enjoy the movie.");
        } else {
            System.out.println("Sorry, that movie is not available.");
        }
        optionResponse();
    }

    public void viewInfo(){
        showUserInfo(login());
    }

    public void exit(){
        System.exit(0);
    }

    public void validOption() {
        System.out.println("Please select a valid option!");
        optionResponse();
    }

    public String login() {
        System.out.println("Please enter your library number. Enter 'back' to return to menu.");
        String input = getInput();
        String successfulUser = null;
        if (input.equals("back")) {
            optionResponse();
        }
        Optional <User> User = userRepo.findAUser(input);
        if (User.isPresent()){
            System.out.println("Please enter your password.");
            if (User.get().getPassword().equals(getInput())){
                successfulUser = User.get().getUsername();
            } else {
                System.out.println("The password you entered is incorrect.");
                login();
            }
        } else {
            System.out.println("The library number you entered is incorrect.");
            login();
        }
        return successfulUser;
    }

    public void showUserInfo(String user) {
        StringBuilder result = new StringBuilder();
        for (User users : userRepo.getUserList()){
            if (users.getUsername().equals(user)){
                result.append("Library number: ").append(users.getUsername()).append("\n")
                        .append("Name: ").append(users.getName()).append("\n")
                        .append("Email: ").append(users.getEmail()).append("\n")
                        .append("Phone number: ").append(users.getNumber());
            }
        }
        System.out.println(result.toString());
        optionResponse();
    }
}
