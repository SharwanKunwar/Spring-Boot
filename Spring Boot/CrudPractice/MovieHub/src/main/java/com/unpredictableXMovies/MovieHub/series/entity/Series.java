package com.unpredictableXMovies.MovieHub.series.entity;

import com.unpredictableXMovies.MovieHub.movie.enums.Genre;
import com.unpredictableXMovies.MovieHub.movie.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "series")
public class Series
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
    private Double imdbRating;

    @NotNull(message = "Total seasons is required.")
    private Integer totalSeasons;


    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "deleted", nullable = false)
    @Builder.Default
    private boolean deleted = false;
}
