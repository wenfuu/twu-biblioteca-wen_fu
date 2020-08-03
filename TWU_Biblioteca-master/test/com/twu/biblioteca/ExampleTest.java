package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        ConsoleOutput output = new ConsoleOutput();
        String result = output.welcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", result);
    }

    @Test
    public void shouldReturnBookTitle() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));
        assertEquals("Title: Title | Author: Author | Year Published: 1874 | ISBN: 9780582534292\nTitle: Title2 | Author: Author2 | Year Published: 1874 | ISBN: 9780582541436\n", bookrepo.toList());
    }

    @Test
    public void shouldAbleToCheckoutABook() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));
        bookrepo.getBookList().get(1).checkout();
        assertFalse(bookrepo.getBookList().get(1).getAvaliability());
    }

    @Test
    public void shouldNotReturnCheckedOutBooks() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));
        bookrepo.getBookList().get(1).checkout();
        assertEquals("Title: Title | Author: Author | Year Published: 1874 | ISBN: 9780582534292\n", bookrepo.toList());
    }

    @Test
    public void shouldAbleToReturnABook() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874, "9780582534292"), new Book("Title2", "Author2", 1874, "9780582541436"));
        bookrepo.getBookList().get(1).checkout();
        bookrepo.getBookList().get(1).returnBook();
        assertTrue(bookrepo.getBookList().get(1).getAvaliability());
    }
}
