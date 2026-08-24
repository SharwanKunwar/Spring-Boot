package com.unpredictableXMovies.MovieHub.service.implementation;

import com.unpredictableXMovies.MovieHub.entity.Movie;
import com.unpredictableXMovies.MovieHub.repository.MovieRepository;
import com.unpredictableXMovies.MovieHub.service.MovieServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MovieService implements MovieServiceHandler
{
    private final MovieRepository repository;
    @Override
    public Movie createMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> createMoviesBulk(List<Movie> movies) {
        return repository.saveAll(movies);
    }

    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public Movie updateMovie(UUID id, Movie movie)
    {
        Movie existingMovie = repository.findById(id).orElse(null);
        System.out.println(existingMovie);
        return null;
    }

    @Override
    public void deleteMovie(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllMovies() {
        repository.deleteAll();
    }
}
