package com.example.CustomAnnoatationWithAspect.mapper;

import com.example.CustomAnnoatationWithAspect.dtos.BookRequestDTO;
import com.example.CustomAnnoatationWithAspect.dtos.BookResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper
{
    // Request to response
    public BookResponseDTO toResponse(BookRequestDTO bookRequestDTO){
        return BookResponseDTO.builder()
                .title(bookRequestDTO.getTitle())
                .author(bookRequestDTO.getAuthor())
                .price(bookRequestDTO.getPrice())
                .build();
    }
}
