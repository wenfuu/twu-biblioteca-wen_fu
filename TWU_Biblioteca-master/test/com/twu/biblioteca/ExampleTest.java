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
        assertFalse(bookrepo.getBookList().get(1).getAvailability());
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
        assertTrue(bookrepo.getBookList().get(1).getAvailability());
    }

    @Test
    public void shouldReturnMovieList() {
        MovieRepo movieRepo = new MovieRepo(new Movie("Name", 2014, "Director", "8.6", "tt0816692"), new Movie("Name2", 1997, "Director2", "Unrated", "tt0120338"));
        assertEquals("Name: Name | Year: 2014 | Director: Director | Rating: 8.6 | IMDb Code: tt0816692\nName: Name2 | Year: 1997 | Director: Director2 | Rating: Unrated | IMDb Code: tt0120338\n", movieRepo.toList());
    }

    @Test
    public void shouldAbleToCheckoutAMovie() {
        MovieRepo movieRepo = new MovieRepo(new Movie("Name", 2014, "Director", "8.6", "tt0816692"), new Movie("Name2", 1997, "Director2", "Unrated", "tt0120338"));
        movieRepo.getMovieList().get(1).checkout();
        assertFalse(movieRepo.getMovieList().get(1).getAvailability());
    }
}
