package com.twu.biblioteca;
import	java.util.ArrayList;
import java.util.Arrays;
import	java.util.List;

public class BookRepo {

    private List<Book> bookList = new ArrayList<Book> ();

    public BookRepo(Book... books) {
        bookList.addAll(Arrays.asList(books));
    }

    public String toList() {
        StringBuilder result = new StringBuilder();
        for (Book book : bookList){
            result.append("Title: ").append(book.getTitle()).append(" | Author: ").append(book.getAuthor()).append(" | Year Published: ").append(book.getYear()).append("\n");
        }
        return result.toString();
    }
}
