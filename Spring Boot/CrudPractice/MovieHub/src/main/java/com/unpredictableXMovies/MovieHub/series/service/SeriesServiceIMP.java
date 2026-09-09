package com.unpredictableXMovies.MovieHub.series.service;

import com.unpredictableXMovies.MovieHub.exceptions.ResourceNotFound;
import com.unpredictableXMovies.MovieHub.series.dtos.SeriesRequestDTO;
import com.unpredictableXMovies.MovieHub.series.dtos.SeriesResponseDTO;
import com.unpredictableXMovies.MovieHub.series.entity.Series;
import com.unpredictableXMovies.MovieHub.series.mapper.SeriesMapper;
import com.unpredictableXMovies.MovieHub.series.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SeriesServiceIMP implements SeriesServiceHelper
{

    private final SeriesRepository repository;
    private final SeriesMapper mapper;

    @Override
    public SeriesResponseDTO create(SeriesRequestDTO requestDTO)
    {
        Series series = mapper.toEntity(requestDTO);
        Series savedSeries = repository.save(series);
        return mapper.toResponse(savedSeries);
    }

    @Override
    public List<SeriesResponseDTO> getAllSeries()
    {
        List<Series> series = repository.findByDeletedFalse();
        return series.stream().map(mapper::toResponse).toList();
    }

    @Override
    public SeriesResponseDTO getSeriesById(UUID id)
    {
        Series series = repository.findByIdAndDeleteFalse(id).orElseThrow(() -> new ResourceNotFound("Series Not Found"));
        return mapper.toResponse(series);
    }

    @Override
    public SeriesResponseDTO updateSeries(UUID id, SeriesRequestDTO requestDTO)
    {
        Series series = new Series();
        mapper.toUpdateEntity(series, requestDTO);
        repository.save(series);
        return mapper.toResponse(series);
    }

    @Override
    public String delete(UUID id)
    {
        Series series = repository.findByIdAndDeleteFalse(id).orElseThrow(() -> new ResourceNotFound("Series Not Found"));
        repository.delete(series);
        return "Series Deleted Successfully";
    }

    @Override
    public String deleteSoftly(UUID id)
    {
        Series series = repository.findByIdAndDeleteFalse(id).orElseThrow(() -> new ResourceNotFound("Series Not Found"));
        series.setDeleted(true);
        repository.save(series);
        return "Series Deleted Successfully";
    }
}
