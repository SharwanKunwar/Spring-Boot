package com.unpredictableXpractice.Books.mapper;

import com.unpredictableXpractice.Books.dtos.BookRequestDTO;
import com.unpredictableXpractice.Books.dtos.BookResponseDTO;
import com.unpredictableXpractice.Books.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper
{
    // Request to entity
    public Book toEntity(BookRequestDTO request){
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setPages(request.getPages());
        book.setPrice(request.getPrice());

        return book;
    }

    //Entity to Response
    public BookResponseDTO toResponse(Book book){
        BookResponseDTO response = new BookResponseDTO();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setDescription(book.getDescription());
        response.setAuthor(book.getAuthor());
        response.setPages(book.getPages());
        response.setPrice(book.getPrice());
        return response;
    }


}
