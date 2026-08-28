package com.unpredictableXpractice.Books.service.implementation;

import com.unpredictableXpractice.Books.dtos.BookRequestDTO;
import com.unpredictableXpractice.Books.dtos.BookResponseDTO;
import com.unpredictableXpractice.Books.entity.Book;
import com.unpredictableXpractice.Books.mapper.BookMapper;
import com.unpredictableXpractice.Books.repository.BookRepository;
import com.unpredictableXpractice.Books.service.BookServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceIMP implements BookServiceHelper
{
    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    public BookResponseDTO create(BookRequestDTO bookRequest)
    {
        Book book = mapper.toEntity(bookRequest);
        Book savedBook = repository.save(book);

        return mapper.toResponse(savedBook);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return List.of();
    }

    @Override
    public BookResponseDTO getBookById(UUID id) {
        return null;
    }

    @Override
    public void deleteBook(UUID id) {

    }

    @Override
    public String softDeleteBook(UUID id) {
        return "";
    }
}
