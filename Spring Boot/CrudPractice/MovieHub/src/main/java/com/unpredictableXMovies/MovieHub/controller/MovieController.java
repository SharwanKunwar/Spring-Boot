package com.unpredictableXMovies.MovieHub.controller;

import com.unpredictableXMovies.MovieHub.dtos.MovieRequestDTO;
import com.unpredictableXMovies.MovieHub.dtos.MovieResponseDTO;
import com.unpredictableXMovies.MovieHub.service.MovieServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController
{
    private final MovieServiceHandler service;

    // Create movie
    @PostMapping("/create")
    public ResponseEntity<MovieResponseDTO> create(@RequestBody MovieRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createMovie(requestDTO));
    }

    // Get all movies
    @GetMapping("/all")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies()
    {
        return ResponseEntity.ok(service.getAllMovies());
    }


}
