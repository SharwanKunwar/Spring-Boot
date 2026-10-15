package com.example.CustomAnnoatationWithAspect.controller;

import com.example.CustomAnnoatationWithAspect.dtos.BookRequestDTO;
import com.example.CustomAnnoatationWithAspect.dtos.BookResponseDTO;
import com.example.CustomAnnoatationWithAspect.service.BookServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController
{
    private final BookServiceHandler service;

    // create
    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookRequestDTO bookRequestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(bookRequestDTO));
    }

}
