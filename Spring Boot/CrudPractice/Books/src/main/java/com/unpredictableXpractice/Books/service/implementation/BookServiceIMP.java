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
import java.util.Optional;
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
    public List<BookResponseDTO> getAllBooks()
    {
        List<Book> books = repository.findByDeletedFalse();
        return books.stream().map(mapper::toResponse).toList();
    }

    @Override
    public BookResponseDTO getBookById(UUID id)
    {
        Optional<Book> book = repository.findByIdAndDeletedFalse(id);
        return book.map(mapper::toResponse).orElseThrow(()-> new RuntimeException("Book not found."));
    }

    @Override
    public String deleteBook(UUID id)
    {
        Book book = repository.findById(id).orElseThrow(()-> new RuntimeException("Book not found."));
        repository.delete(book);
        return "Book deleted successfully";
    }

    @Override
    public String softDeleteBook(UUID id)
    {
        Book book = repository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found."));
        book.setDeleted(true);
        repository.save(book);

        return "Book deleted successfully";
    }

    @Override
    public List<BookResponseDTO> displayAllDeletedBooks()
    {
        List<Book> book = repository.findByDeletedTrue();
        return book.stream().map(mapper::toResponse).toList();
    }
}
