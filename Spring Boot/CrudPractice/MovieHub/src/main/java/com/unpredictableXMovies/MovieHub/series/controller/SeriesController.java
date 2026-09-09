package com.unpredictableXMovies.MovieHub.series.controller;

import com.unpredictableXMovies.MovieHub.series.dtos.SeriesRequestDTO;
import com.unpredictableXMovies.MovieHub.series.dtos.SeriesResponseDTO;
import com.unpredictableXMovies.MovieHub.series.service.SeriesServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/series")
@AllArgsConstructor
public class SeriesController
{
    private final SeriesServiceHelper service;

    // Create
    @PostMapping
    public ResponseEntity<SeriesResponseDTO> create(@Valid @RequestBody SeriesRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<SeriesResponseDTO>> getAllSeries(){
        return ResponseEntity.ok(service.getAllSeries());
    }

    // Get series by id
    @GetMapping("/{id}")
    public ResponseEntity<SeriesResponseDTO> getSeriesById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.getSeriesById(id));
    }

    //Update series
    @PutMapping("/update/{id}")
    public ResponseEntity<SeriesResponseDTO> updateSeries(@PathVariable UUID id, @RequestBody SeriesRequestDTO requestDTO)
    {
        return ResponseEntity.ok(service.updateSeries(id, requestDTO));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.delete(id));
    }

    //Soft delete
    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<String> deleteSoftly(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteSoftly(id));
    }


}
