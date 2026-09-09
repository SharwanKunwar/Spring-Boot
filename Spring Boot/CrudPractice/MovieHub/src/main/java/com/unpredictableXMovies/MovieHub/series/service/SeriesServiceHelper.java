package com.unpredictableXMovies.MovieHub.series.service;

import com.unpredictableXMovies.MovieHub.series.dtos.SeriesRequestDTO;
import com.unpredictableXMovies.MovieHub.series.dtos.SeriesResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SeriesServiceHelper
{
    // Create
    SeriesResponseDTO create(SeriesRequestDTO requestDTO);
    // Get all
    List<SeriesResponseDTO> getAllSeries();
    // Get by id
    SeriesResponseDTO getSeriesById(UUID id);
    // update

}
