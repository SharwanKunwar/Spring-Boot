package com.unpredictableXMovies.MovieHub.series.dtos;

import com.unpredictableXMovies.MovieHub.movie.enums.Genre;
import com.unpredictableXMovies.MovieHub.movie.enums.Type;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesRequestDTO {

    @NotBlank(message = "Title is required.")
    @Size(min = 3, max = 150, message = "Title must be between 3 and 150 characters.")
    private String title;

    @NotBlank(message = "Description is required.")
    @Size(min = 3, max = 300, message = "Description must be between 3 and 300 characters.")
    private String description;

    @NotNull(message = "Type is required.")
    private Type type;

    @NotNull(message = "Genre is required.")
    private Genre genre;

    @NotNull(message = "Release date is required.")
    private LocalDate releaseDate;

    @NotNull(message = "IMDB rating is required.")
    @DecimalMin(value = "0.0", message = "Rating must be at least 0.0.")
    @DecimalMax(value = "10.0", message = "Rating must be at most 10.0.")
    private Double imdbRating;

    @NotNull(message = "Total seasons is required.")
    @Min(value = 1, message = "Total seasons must be at least 1.")
    private Integer totalSeasons;

    @NotBlank(message = "Poster URL is required.")
    private String posterUrl;
}