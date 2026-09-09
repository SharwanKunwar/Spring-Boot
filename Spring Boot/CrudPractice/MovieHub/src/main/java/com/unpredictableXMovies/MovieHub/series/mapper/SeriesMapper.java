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
