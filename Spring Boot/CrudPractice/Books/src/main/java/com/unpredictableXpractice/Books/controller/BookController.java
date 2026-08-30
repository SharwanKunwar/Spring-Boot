package com.unpredictableXpractice.Books.controller;

import com.unpredictableXpractice.Books.dtos.BookRequestDTO;
import com.unpredictableXpractice.Books.dtos.BookResponseDTO;
import com.unpredictableXpractice.Books.entity.Book;
import com.unpredictableXpractice.Books.service.BookServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController
{
    private final BookServiceHelper service;

    //Create
    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@Valid @RequestBody BookRequestDTO request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    //update
    @PutMapping("/update")
    public ResponseEntity<BookResponseDTO> update(@PathVariable UUID id, @RequestBody BookRequestDTO request)
    {
        return ResponseEntity.ok(service.update(id,request));
    }

    //Get All books
    @GetMapping("/all")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks()
    {
        return ResponseEntity.ok(service.getAllBooks());
    }

    // Get one book
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getOneBook(@PathVariable UUID id)
    {
        BookResponseDTO book = service.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // Hard delete
    @DeleteMapping("/hard/{id}")
    public String deleteBook(@PathVariable UUID id)
    {
        return service.deleteBook(id);
    }

    // Soft delete
    @PatchMapping("/soft/{id}")
    public String deleteSoftly(@PathVariable UUID id)
    {
        return service.softDeleteBook(id);
    }

    // Display all deleted books
    @GetMapping("/deletedBooks")
    public ResponseEntity<List<BookResponseDTO>> getAllDeletedBooks()
    {
        return ResponseEntity.ok(service.displayAllDeletedBooks());
    }
}
