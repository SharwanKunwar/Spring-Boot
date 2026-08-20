package com.unpredictableXMovies.MovieHub.repository;

import com.unpredictableXMovies.MovieHub.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
