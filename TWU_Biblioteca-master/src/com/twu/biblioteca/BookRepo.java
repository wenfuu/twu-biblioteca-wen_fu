package com.twu.biblioteca;
import	java.util.ArrayList;
import java.util.Arrays;
import	java.util.List;
import java.util.stream.Collectors;

public class BookRepo {

    private List<Book> bookList = new ArrayList<Book> ();

    public BookRepo(Book... books) {
        bookList.addAll(Arrays.asList(books));
    }

    public String toList() {
        StringBuilder result = new StringBuilder();
        List<Book> bookListAvailable = bookList.stream().filter(Book::getAvailability).collect(Collectors.toList());
        for (Book book : bookListAvailable){
            result.append("Title: ").append(book.getTitle()).append(" | Author: ").append(book.getAuthor()).append(" | Year Published: ").append(book.getYear()).append(" | ISBN: ").append(book.getISBN()).append("\n");
        }
        return result.toString();
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
