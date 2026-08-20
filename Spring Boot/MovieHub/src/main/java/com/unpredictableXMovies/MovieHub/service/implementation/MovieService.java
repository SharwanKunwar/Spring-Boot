package com.unpredictableXMovies.MovieHub.service.implementation;

import com.unpredictableXMovies.MovieHub.entity.Movie;
import com.unpredictableXMovies.MovieHub.service.MovieServiceHandler;

import java.util.List;
import java.util.UUID;

public class MovieService implements MovieServiceHandler {
    @Override
    public Movie createMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }

    @Override
    public Movie updateMovie(UUID id, Movie movie) {
        return null;
    }

    @Override
    public void deleteMovie(UUID id) {

    }
}
