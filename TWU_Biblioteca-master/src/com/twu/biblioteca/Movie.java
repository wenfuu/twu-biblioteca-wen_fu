package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private String rating;
    private String imdbCode;

    public Movie(String name, int year, String director, String rating, String imdbCode) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.imdbCode = imdbCode;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() { return rating; }

    public String getImdbCode() {
        return imdbCode;
    }
}
