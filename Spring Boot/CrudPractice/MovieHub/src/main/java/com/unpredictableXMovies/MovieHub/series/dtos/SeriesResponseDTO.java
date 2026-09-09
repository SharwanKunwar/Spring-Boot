package com.unpredictableXMovies.MovieHub.series.dtos;

import com.unpredictableXMovies.MovieHub.movie.enums.Genre;
import com.unpredictableXMovies.MovieHub.movie.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeriesResponseDTO
{
    private UUID id;
    private String title;
    private String description;
    private Type type;
    private Genre genre;
    private LocalDate releaseDate;
    private Double imdbRating;
    private Integer totalSeasons;
}
