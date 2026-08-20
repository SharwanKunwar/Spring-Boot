package com.unpredictableXMovies.MovieHub.controller;

import com.unpredictableXMovies.MovieHub.entity.Movie;
import com.unpredictableXMovies.MovieHub.service.MovieServiceHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movie")
@AllArgsConstructor
public class MovieController
{
    private final MovieServiceHandler service;

    // post movie
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(service.createMovie(movie));
    }

    // Get all movies
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(service.getAllMovies());
    }

    //Delete movies
    @DeleteMapping
    public void deleteMovie(UUID id) {
        service.deleteMovie(id);
    }
}
