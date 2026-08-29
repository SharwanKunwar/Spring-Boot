package com.unpredictableXpractice.Books.service;

import com.unpredictableXpractice.Books.dtos.BookRequestDTO;
import com.unpredictableXpractice.Books.dtos.BookResponseDTO;

import java.util.List;
import java.util.UUID;

public interface BookServiceHelper
{
    BookResponseDTO create(BookRequestDTO bookRequest);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO getBookById(UUID id);
    String deleteBook(UUID id);
    String softDeleteBook(UUID id);
}
