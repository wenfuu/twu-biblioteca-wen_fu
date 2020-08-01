package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp();
        String result = app.WelcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", result);
    }

    @Test
    public void shouldReturnBookTitle() {
        Book book = new Book("Example1 Example2 Example3");
        assertEquals("Example1 Example2 Example3", book.toList());
    }
}
