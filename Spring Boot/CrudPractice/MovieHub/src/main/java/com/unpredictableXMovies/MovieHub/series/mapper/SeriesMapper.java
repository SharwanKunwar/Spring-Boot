package com.unpredictableXMovies.MovieHub.series.mapper;

import com.unpredictableXMovies.MovieHub.series.dtos.SeriesRequestDTO;
import com.unpredictableXMovies.MovieHub.series.dtos.SeriesResponseDTO;
import com.unpredictableXMovies.MovieHub.series.entity.Series;
import org.springframework.stereotype.Component;

@Component
public class SeriesMapper
{
    // DTO -> toEntity
    public Series toEntity(SeriesRequestDTO requestDTO)
    {
        return Series.builder()
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
                .type(requestDTO.getType())
                .genre(requestDTO.getGenre())
                .releaseDate(requestDTO.getReleaseDate())
                .imdbRating(requestDTO.getImdbRating())
                .totalSeasons(requestDTO.getTotalSeasons())
                .posterUrl(requestDTO.getPosterUrl())
                .build();
    }

    // update entity
    public void toUpdateEntity(Series series, SeriesRequestDTO requestDTO)
    {
        series.setTitle(requestDTO.getTitle());
        series.setDescription(requestDTO.getDescription());
        series.setType(requestDTO.getType());
        series.setGenre(requestDTO.getGenre());
        series.setReleaseDate(requestDTO.getReleaseDate());
        series.setImdbRating(requestDTO.getImdbRating());
        series.setTotalSeasons(requestDTO.getTotalSeasons());
        series.setPosterUrl(requestDTO.getPosterUrl());
    }

    // Entity -> toResponse
    public SeriesResponseDTO toResponse(Series series)
    {
        return SeriesResponseDTO.builder()
                .id(series.getId())
                .title(series.getTitle())
                .description(series.getDescription())
                .type(series.getType())
                .genre(series.getGenre())
                .releaseDate(series.getReleaseDate())
                .imdbRating(series.getImdbRating())
                .totalSeasons(series.getTotalSeasons())
                .build();
    }
}
