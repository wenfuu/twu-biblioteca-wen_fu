package com.twu.biblioteca;
import	java.util.ArrayList;
import java.util.Arrays;
import	java.util.List;

public class MovieRepo {

    private List<Movie> movieList = new ArrayList<>();

    public MovieRepo(Movie... movies) {
        movieList.addAll(Arrays.asList(movies));
    }

    public String toList() {
        StringBuilder result = new StringBuilder();
        for (Movie movie : movieList){
            result.append("Name: ").append(movie.getName()).append(" | Year: ").append(movie.getYear()).append(" | Director: ").append(movie.getDirector()).append(" | Rating: ").append(movie.getRating()).append(" | IMDb Code: ").append(movie.getImdbCode()).append("\n");
        }
        return result.toString();
    }
}
