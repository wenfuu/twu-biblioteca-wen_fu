package com.twu.biblioteca;
import	java.util.ArrayList;
import java.util.Arrays;
import	java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieRepo {

    private List<Movie> movieList = new ArrayList<>();

    public MovieRepo(Movie... movies) {
        movieList.addAll(Arrays.asList(movies));
    }

    public String toList() {
        StringBuilder result = new StringBuilder();
        List<Movie> movieListAvailable = movieList.stream().filter(Movie::getAvailability).collect(Collectors.toList());
        for (Movie movie : movieListAvailable){
            result.append("Name: ").append(movie.getName()).append(" | Year: ").append(movie.getYear()).append(" | Director: ").append(movie.getDirector()).append(" | Rating: ").append(movie.getRating()).append(" | IMDb Code: ").append(movie.getImdbCode()).append("\n");
        }
        return result.toString();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Optional<Movie> findAMovie(String imdbCode){
        return movieList.stream().filter(b -> b.getImdbCode().equals(imdbCode)).findFirst();
    }
}
