package com.unpredictableXMovies.MovieHub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie
{
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String shortStory;
    private String genre;
    private Double imdbRating;
    private Integer duration;
    private String imageUrl;
    private String actors;
    private String directors;
    private String country;
    private String language;
    private LocalDate releaseDate;


}
