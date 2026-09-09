package com.unpredictableXMovies.MovieHub.movie.entity;

import com.unpredictableXMovies.MovieHub.movie.enums.Genre;
import com.unpredictableXMovies.MovieHub.movie.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull(message = "IMDB rating is required.")
    @DecimalMin(value = "0.0", message = "Rating must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Rating must be at most 10.0")
    private Double imdbRating;

    @Column(name = "length")
    private Integer length;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "deleted", nullable = false)
    @Builder.Default
    private boolean deleted = false;
}