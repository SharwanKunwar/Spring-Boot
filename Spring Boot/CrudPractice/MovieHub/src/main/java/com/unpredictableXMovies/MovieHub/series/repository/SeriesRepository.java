package com.unpredictableXMovies.MovieHub.series.repository;

import com.unpredictableXMovies.MovieHub.series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID>
{
    // Manual queries
    Optional<Series> findByIdAndDeleteFalse(UUID id);
    List<Series> findByDeletedFalse();

}
