package com.practice.CustomAnnoatation.controller;

import com.practice.CustomAnnoatation.dtos.BookRequestDTO;
import com.practice.CustomAnnoatation.dtos.BookResponseDTO;
import com.practice.CustomAnnoatation.service.BookServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController
{

    private final BookServiceHandler service;

    // Create book
    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookRequestDTO bookRequestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(bookRequestDTO));
    }


}
