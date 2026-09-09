package com.unpredictableXMovies.MovieHub.series.repository;

import com.unpredictableXMovies.MovieHub.series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID>
{

}
