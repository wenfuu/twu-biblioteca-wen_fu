package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        ConsoleOutput output = new ConsoleOutput();
        String result = output.WelcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", result);
    }

    @Test
    public void shouldReturnBookTitle() {
        Book book = new Book("Title", "Author", 1874);
        assertEquals("Title: Title Author: Author Year Published: 1874", book.toList());
    }
}
