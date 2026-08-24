package com.unpredictableXMovies.MovieHub.service;

import com.unpredictableXMovies.MovieHub.entity.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieServiceHandler
{
    //create
    Movie createMovie(Movie movie);
    //create movies in bulk
    List<Movie> createMoviesBulk(List<Movie> movies);
    //Read all
    List<Movie> getAllMovies();
    //Update movie
    Movie updateMovie(UUID id, Movie movie);
    //Delete movie
    void deleteMovie(UUID id);
    //Delete all movies
    void deleteAllMovies();
}
