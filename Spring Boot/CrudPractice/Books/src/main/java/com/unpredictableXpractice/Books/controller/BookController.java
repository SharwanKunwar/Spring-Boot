package com.unpredictableXpractice.Books.controller;

import com.unpredictableXpractice.Books.dtos.BookRequestDTO;
import com.unpredictableXpractice.Books.dtos.BookResponseDTO;
import com.unpredictableXpractice.Books.service.BookServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController
{
    private final BookServiceHelper service;

    //Create
    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    //Get All books
    @GetMapping("/all")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }
}
