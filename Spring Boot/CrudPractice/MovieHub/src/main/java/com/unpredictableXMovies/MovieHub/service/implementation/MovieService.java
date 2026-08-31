package com.unpredictableXMovies.MovieHub.service.implementation;

import com.unpredictableXMovies.MovieHub.dtos.MovieRequestDTO;
import com.unpredictableXMovies.MovieHub.dtos.MovieResponseDTO;
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
    public MovieRequestDTO createMovie(MovieRequestDTO request) {
        return null;
    }

    @Override
    public List<MovieResponseDTO> createMoviesBulk(List<MovieResponseDTO> movies) {
        return List.of();
    }

    @Override
    public List<MovieResponseDTO> getAllMovies() {
        return List.of();
    }

    @Override
    public MovieResponseDTO getMovieById(UUID id) {
        return null;
    }

    @Override
    public MovieResponseDTO updateMovie(UUID id, Movie movie) {
        return null;
    }

    @Override
    public String deleteHardly(UUID id) {
        return "";
    }

    @Override
    public String deleteSoftly(UUID id) {
        return "";
    }

    @Override
    public String deleteAllMovies() {
        return "";
    }
}
