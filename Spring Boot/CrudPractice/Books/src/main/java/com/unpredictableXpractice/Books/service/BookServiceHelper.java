package com.unpredictableXpractice.Books.service;

import com.unpredictableXpractice.Books.dtos.BookRequestDTO;
import com.unpredictableXpractice.Books.dtos.BookResponseDTO;

import java.util.List;
import java.util.UUID;

public interface BookServiceHelper
{
    BookResponseDTO create(BookRequestDTO request);
    BookResponseDTO update(UUID id, BookRequestDTO request);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO getBookById(UUID id);
    String deleteBook(UUID id);
    String softDeleteBook(UUID id);
    List<BookResponseDTO> displayAllDeletedBooks();
}
