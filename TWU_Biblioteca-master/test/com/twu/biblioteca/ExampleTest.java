package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExampleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        ConsoleOutput output = new ConsoleOutput();
        String result = output.welcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", result);
    }

    @Test
    public void shouldReturnBookTitle() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874), new Book("Title2", "Author2", 1874));
        assertEquals("Title: Title | Author: Author | Year Published: 1874\nTitle: Title2 | Author: Author2 | Year Published: 1874\n", bookrepo.toList());
    }

    @Test
    public void shouldAbleToCheckoutABook() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874), new Book("Title2", "Author2", 1874));
        bookrepo.getBookList().get(1).checkout();
        assertFalse(bookrepo.getBookList().get(1).getAvaliability());
    }

    @Test
    public void shouldNotReturnCheckedOutBooks() {
        BookRepo bookrepo = new BookRepo(new Book("Title", "Author", 1874), new Book("Title2", "Author2", 1874));
        bookrepo.getBookList().get(1).checkout();
        assertEquals("Title: Title | Author: Author | Year Published: 1874\n", bookrepo.toList());
    }
}
